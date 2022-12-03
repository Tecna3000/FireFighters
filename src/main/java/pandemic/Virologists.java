package pandemic;

import controller.PandemicGame;
import controller.PandemicGrid;
import elements.EliminateVirus;
import elements.VirusEliminator;
import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Virologists extends VirusEliminator implements EliminateVirus {
    private List<Position> virologistsList = new ArrayList<>();
    PandemicGrid grid;
    PandemicGame model;
    public Virologists(PandemicGrid grid, PandemicGame model) {
        super(grid,model);
        this.grid = grid;
        this.model = model;
    }

    @Override
    public void initialisation(int number) {
        for (int index = 0; index < number; index++)
            virologistsList.add(model.randomPosition());
    }

    @Override
    public void activation() {
        List<Position> vNewPositions = new ArrayList<>();
        for (Position vir : virologistsList) {
            Position newPosition = this.eliminateVirus(vir);
            grid.painter.paint(vir.row(), vir.col());
            grid.painter.paintVir(newPosition.row(), newPosition.col());
            vNewPositions.add(newPosition);
        }
        virologistsList = vNewPositions;
    }
    @Override
    public Position eliminateVirus(Position position) {
        Position randomPosition = twoStepsTowardVirus(position);
        List<Position> nextVirus = grid.model.next(randomPosition).stream().filter(model.virus.getVirusPositions()::contains).toList();
        eliminate(randomPosition);
        for (Position virus : nextVirus)
            eliminate(virus);
        return randomPosition;
    }
    private Position twoStepsTowardVirus(Position position){
        Position firstStep = aStepTowardVirus(position);
        return aStepTowardVirus(firstStep);
    }
}
