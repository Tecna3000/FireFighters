import javafx.scene.image.Image;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

public class Clouds extends Elements{

    List<Position> cloudsNewPositions;

    Image cloudImage;
    {
        try {
            cloudImage = new Image( new File("../firefighterstarter/src/main/images/rain.png").toURI().toURL().toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    public Clouds(Model model) {
        super(model);
    }

    @Override
    void initialisation(int number) {
        for (int index = 0; index < number; index++) cloudsNewPositions.add(randomPosition());
    }

    @Override
    void activation() {

    }

    @Override
    Position move(Position position) {
        return null;
    }
}
