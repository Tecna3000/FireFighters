import java.util.ArrayList;
import java.util.List;

public class Fires extends Element{

    public Fires(Model model) {
        super(model);

    }

    @Override
    void initialisation(int number) {
        for (int index = 0; index < number; index++){
            model.firesList.add(randomPosition());
        }

    }

    @Override
    void activation() {
        System.out.println(model.step);
        if (model.step % 2 == 0) {
            List<Position> newFires = new ArrayList<>();
            for (Position fire : model.firesList) {
                newFires.addAll(model.next(fire));
            }
            System.out.println(newFires);

            model.firesList.addAll(newFires);
            for (Position newFire : newFires)
                model.grid.paintFire(newFire.row, newFire.col);

        }
        model.step++;

    }

    @Override
    Position move(Position position) {
        return null;
    }

}
