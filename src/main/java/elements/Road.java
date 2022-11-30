package elements;

import javafx.scene.image.Image;
import model.Model;
import util.Position;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class Road extends Elements{
    public Road(Model model) {
        super(model);
    }
    List<Position> roadPositions = new ArrayList<>();
    Image roadImage;

    {
        try {
            roadImage = new Image( new File("../firefighterstarter/src/main/java/view/images/road.png").toURI().toURL().toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialisation(int number) {
        for (int index = 0; index < number; index++)
            roadPositions.add(model.randomPosition());

    }

    @Override
    public void activation() {
        for(Position road : roadPositions) model.painter.paintElement(roadImage,road.row(),road.col());

    }

    @Override
    Position move(Position position) {
        return null;
    }
}
