import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fires extends Elements {

    static Set<Position> firesList = new HashSet<>();
    public Fires(Model model) {
        super(model);

    }

    @Override
    void initialisation(int number) {
        for (int index = 0; index < number; index++){
            firesList.add(randomPosition());
        }

    }

    @Override
    void activation() {
        if (model.step % 2 == 0) {
            List<Position> newFires = new ArrayList<>();
            for (Position fire : firesList) {
                newFires.addAll(model.next(fire));
            }
            firesList.addAll(newFires);
            for (Position newFire : newFires)
                model.painter.paintFire(newFire.row, newFire.col);

        }
        model.step++;

    }

    @Override
    Position move(Position position) {
        return null;
    }

}
