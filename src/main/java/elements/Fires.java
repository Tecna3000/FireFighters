package elements;

import controller.FireFighterGrid;
import controller.FireFighterGame;
import util.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fires implements Elements {
    FireFighterGrid grid;
    FireFighterGame model;
    private final Set<Position> firesSet = new HashSet<>();
    int step = 0;
    public Fires(FireFighterGrid grid, FireFighterGame model) {
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
            for (Position newFire : newFires)
                grid.painter.paintFire( newFire.row(), newFire.col());
            firesSet.addAll(newFires);
        }
        step++;
    }
    public Set<Position> getFiresPositions() {
        return firesSet;
    }
}
