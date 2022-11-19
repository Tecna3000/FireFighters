import java.util.List;

public class Clouds extends Elements {

    List<Position> cloudsNewPositions;
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
