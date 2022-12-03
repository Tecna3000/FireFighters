package pandemic;

import controller.PandemicGame;
import controller.PandemicGrid;
import elements.Elements;
import util.Position;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            List<Position> newVirus = new ArrayList<>();
            for (Position virus : virusSet) {
                newVirus.addAll(model.next(virus));
            }
            for (Position virus : newVirus )
                grid.painter.paintVirus( virus.row(), virus.col());
            virusSet.addAll(newVirus);
        }
        step++;
    }
    public Set<Position> getVirusPositions() {
        return virusSet;
    }
}
