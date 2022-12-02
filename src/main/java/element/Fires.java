package element;

import controller.Grid;
import controller.Model;
import util.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fires implements elements {
    Grid grid;
    Model model;
    public Set<Position> firesSet = new HashSet<>();
    int step = 0;


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
//todo: update this methode
    @Override
    public void activation() {
        if (step % 2 == 0) {
            List<Position> newFires = new ArrayList<>();
            for (Position fire : firesSet) {
                newFires.addAll(model.nextSkipMountainAndRoad(fire));
            }
            List<Position> occupied = new ArrayList<>();

//            for (Position newFire : newFires){
//                if (model.road.getRoadPositions().contains(newFire) || model.mountains.getMountainsPositions().contains(newFire)) {
//                    occupied.add(newFire);
//                }
//            }
            //occupied.forEach(firesSet::remove);
            for (Position newFire : newFires)
                grid.painter.paintFire( newFire.row, newFire.col);
            firesSet.addAll(newFires);
        }
        step++;
    }

    public Set<Position> getFiresPositions() {
        return firesSet;
    }
}
