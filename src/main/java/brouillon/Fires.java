package brouillon;

import controller.Grid;
import controller.Model;
import javafx.scene.image.Image;
import util.Initializer;
import util.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fires implements Initializer {

    Grid grid;
    Model model;
    Set<Position> firesSet = new HashSet<>();

    public Fires(Grid grid, Model model) {
        this.grid =  grid;
        this.model = model;
    }

    @Override
    public void initialisation(int number) {
        for (int index = 0; index < number; index++){
            firesSet.add(model.randomPosition());
        }
    }

    @Override
    public void activation() {
        if (model.step % 2 == 0) {
            List<Position> newFires = new ArrayList<>();
            for (Position fire : firesSet) {
                newFires.addAll(model.next(fire));
            }
            firesSet.addAll(newFires);
            for (Position newFire : newFires)
                model.painter.paintFire(newFire.row, newFire.col);

        }
        model.step++;

    }
}
