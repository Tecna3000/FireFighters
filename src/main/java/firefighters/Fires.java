package firefighters;

import model.Elements;
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
    @Override
    public void activation() {
        int tour = 1;
        if (step % 2 == 0) {
            List<Position> newFires = new ArrayList<>();
            for(Position fire : firesSet){
                newFires.addAll(model.skipMountainAndRoad(fire));
            }
            List<Position> rock = new ArrayList<>();
            for (Position fire : newFires) {
                if (tour < 4 && model.rock.getPositions().contains(fire)) {
                    rock.add(fire);
                    tour++;
                }
                if (tour == 4){
                    model.rock.getPositions().remove(fire);
                    tour = 0;
                }
            }
            newFires.removeAll(rock);
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
