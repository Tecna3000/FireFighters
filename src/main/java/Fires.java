import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fires extends Element{

    public Fires(Model model) {
        super(model);

    }

    @Override
    void initialisation(int number) {
        for (int index = 0; index < number; index++)
            model.fires.add(Position.randomPosition((int) super.rowCount, (int) super.colCount));
    }

    @Override
    void activation() {
        if (model.step % 2 == 0) {
            List<Position> newFires = new ArrayList<>();
            for (Position fire : model.fires) {
                newFires.addAll(model.next(fire));
            }
            for (Position newFire : newFires)
                model.grid.paintFire(newFire.row, newFire.col);
            model.fires.addAll(newFires);
        }
        model.step++;
    }

    @Override
    Position move(Position position) {
        return null;
    }

}
