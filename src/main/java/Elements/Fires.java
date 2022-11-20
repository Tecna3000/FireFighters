package Elements;

import Model.Model;
import javafx.scene.image.Image;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fires extends Elements {

    static Set<Position> firesList = new HashSet<>();
    Image fireImage;

    {
        try {
            fireImage = new Image( new File("../firefighterstarter/src/main/java/Painter/images/flamme.png").toURI().toURL().toString());
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
            firesList.add(randomPosition());
        }

    }

    @Override
    public void activation() {
        if (model.step % 2 == 0) {
            List<Position> newFires = new ArrayList<>();
            for (Position fire : firesList) {
                newFires.addAll(model.next(fire));
            }
            firesList.addAll(newFires);
            for (Position newFire : newFires)
                model.painter.paintElement(fireImage, newFire.row, newFire.col);

        }
        model.step++;

    }

    @Override
    Position move(Position position) {
        return null;
    }

}
