package elements;

import javafx.scene.image.Image;
import model.Model;
import util.Position;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class Mountains extends Elements{
    List<Position> mountainsList = new ArrayList<>();
    public Mountains(Model model) {
        super(model);
    }
    Image mountainImage;

    {
        try {
            mountainImage = new Image( new File("../firefighterstarter/src/main/java/view/images/mountain.png").toURI().toURL().toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void initialisation(int number) {
        for (int index = 0; index < number; index++)
            mountainsList.add(model.randomPosition());

    }

    @Override
    public void activation() {
        for(Position mountain : mountainsList)
            model.painter.paintElement(mountainImage,mountain.row(),mountain.col());
    }
    public List<Position> getMountainsPositions() {
        return mountainsList;
    }



    @Override
    Position move(Position position) {
        return null;
    }
}
