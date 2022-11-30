package elements;

import model.Model;
import javafx.scene.image.Image;
import util.Position;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Clouds extends Elements {
    List<Position> cloudsList = new ArrayList<>();
    List<Position> cloudsNewPositions;
    Image cloudImage;
    {
        try {
            cloudImage = new Image( new File("../firefighterstarter/src/main/java/view/images/rain.png").toURI().toURL().toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    public Clouds(Model model) {
        super(model);
    }

    public Position randomStep(Position positon){
        List<Position> positions = model.next(positon);
        Random random = new Random();
        int randomPosition = random.nextInt(positions.size());
        return  positions.get(randomPosition);

    }

    @Override
    public void initialisation(int number) {
        for (int index = 0; index < number; index++) cloudsList.add(model.randomPosition());
    }

    @Override
    public void activation() {
        cloudsNewPositions = new ArrayList<>();
        for (Position cloud : cloudsList) {
            Position newPosition = move(cloud);
            model.painter.paint(cloud.row, cloud.col);
            model.painter.paintElement(cloudImage, newPosition.row, newPosition.col);
            cloudsNewPositions.add(newPosition);
        }
        cloudsList = cloudsNewPositions;

    }
    private void extinguish(Position position) {
        Fires.firesSet.remove(position);
        model.painter.paint(position.row, position.col);
    }
    @Override
    Position move(Position position) {
        Position randomPosition = randomStep(position);
        List<Position> nextFires = model.next(randomPosition).stream().filter(Fires.firesSet::contains).toList();
        extinguish(randomPosition);
        for (Position fire : nextFires)
            extinguish(fire);
        return randomPosition;
    }
}
