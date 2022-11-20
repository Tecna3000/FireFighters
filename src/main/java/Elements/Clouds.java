package Elements;

import Model.Model;
import javafx.scene.image.Image;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class Clouds extends Elements {
    List<Position> cloudsList = new ArrayList<>();
    List<Position> cloudsNewPositions;

    Image cloudImage;
    {
        try {
            cloudImage = new Image( new File("../firefighterstarter/src/main/java/Painter/images/rain.png").toURI().toURL().toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    public Clouds(Model model) {
        super(model);
    }

    @Override
    public void initialisation(int number) {
        for (int index = 0; index < number; index++) cloudsList.add(randomPosition());
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
        Fires.firesList.remove(position);
        model.painter.paint(position.row, position.col);
    }
    @Override
    Position move(Position position) {
        Position randomPosition = randomPosition();
        List<Position> nextFires = model.next(randomPosition).stream().filter(Fires.firesList::contains).toList();
        extinguish(randomPosition);
        for (Position fire : nextFires)
            extinguish(fire);
        return randomPosition;
    }
}
