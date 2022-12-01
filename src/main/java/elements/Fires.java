package elements;

import model.Model;
import javafx.scene.image.Image;
import util.Position;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fires extends Elements {

    public static Set<Position> firesSet = new HashSet<>();
    int step = 0;
    Image fireImage;

    {
        try {
            fireImage = new Image( new File("../firefighterstarter/src/main/java/view/images/flamme.png").toURI().toURL().toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public Fires(Model model) {
        super(model);

    }

    @Override
    public void initialisation(int number) {
        for (int index = 0; index < number; index++){
            firesSet.add(model.randomPosition());
        }

    }

    @Override
    public void activation() {
        if (step % 2 == 0) {
            List<Position> newFires = new ArrayList<>();
            for (Position fire : firesSet) {
                newFires.addAll(model.next(fire));
            }
            firesSet.addAll(newFires);
            for (Position newFire : newFires)
                model.painter.paintElement(fireImage, newFire.row, newFire.col);

        }
        step++;


    }

    @Override
    Position move(Position position) {
        return null;
    }

    public Set<Position> getFiresPositions() {
        return firesSet;
    }

}
