import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fire extends Element{
    private Position position;
    Set<Position> fires = new HashSet<>();
    int step = 0;
    Grid grid;;
    public Fire(Position position) {
        super();
        this.position = position;
    }

    @Override
    void initialisation(int number) {
        for (int index = 0; index < number; index++)
            fires.add(position.randomPosition());
    }

    @Override
    void activation() {
        if (step % 2 == 0) {
            List<Position> newFires = new ArrayList<>();
            for (Position fire : fires) {
                newFires.addAll(activateFire(fire));
            }
            for (Position newFire : newFires)
                grid.paintFire(newFire.row, newFire.col);
            fires.addAll(newFires);
        }
        step++;
    }

    private List<Position> activateFire(Position position) {
        return next(position);
    }
}
