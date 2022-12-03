package pandemic;

import model.Elements;
import util.Position;

import java.util.*;

public class Virus implements Elements {
    PandemicGrid grid;
    PandemicGame model;
    private final Set<Position> virusSet = new HashSet<>();
    int step = 0;
    public Virus(PandemicGrid grid, PandemicGame model) {
        this.grid =  grid;
        this.model = model;
    }

    @Override
    public void initialisation(int number) {
        for (int index = 0; index < number; index++){
            virusSet.add(model.randomPosition());
        }
    }
    //todo: update this methode
    @Override
    public void activation() {
        if (step % 2 == 0) {
            List<Position> newFires = new ArrayList<>();
            for (Position virus : virusSet) {

                newFires.addAll(model.next(virus));
            }
            for (Position newVirus : newFires)
                grid.painter.paintVirus(newVirus.row(), newVirus.col());
            virusSet.addAll(newFires);
        }
        step++;
    }

    public Set<Position> getVirusPositions() {
        return virusSet;
    }
}
