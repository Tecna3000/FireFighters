package element;

import util.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fires implements element {

    controller.Grid grid;
    controller.Model model;
    public Set<Position> firesSet = new HashSet<>();

    int step = 0;


    public Fires(controller.Grid grid, controller.Model model) {
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
        if (step % 2 == 0) {
            List<Position> newFires = new ArrayList<>();
            for (Position fire : firesSet) {
                newFires.addAll(model.next(fire));
            }
            List<Position> occupied = new ArrayList<>();

            for (Position newFire : newFires){
                if (model.road.getRoadPositions().contains(newFire) || model.mountains.getMountainsPositions().contains(newFire)) {
                    occupied.add(newFire);
                }
            }
            occupied.forEach(firesSet::remove);
            for (Position newFire : newFires){
                model.painter.paintFire( newFire.row, newFire.col);
            }
            firesSet.addAll(newFires);
        }
        step++;
    }

    public Set<Position> getFiresPositions() {
        return firesSet;
    }
}
