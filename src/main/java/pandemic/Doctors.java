package pandemic;


import controller.PandemicGame;
import controller.PandemicGrid;
import elements.EliminateVirus;
import elements.VirusEliminator;
import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Doctors extends VirusEliminator implements EliminateVirus {
    private List<Position> doctorsList = new ArrayList<>();
    PandemicGrid grid;
    PandemicGame model;
    public Doctors(PandemicGrid grid, PandemicGame model) {
        super(grid,model);
        this.grid = grid;
        this.model = model;

    }

    @Override
    public void initialisation(int number) {
        for (int index = 0; index < number; index++)
            doctorsList.add(model.randomPosition());
    }

    @Override
    public void activation() {
        List<Position> doctorsNewPositions = new ArrayList<>();
        for (Position doctor : doctorsList) {
            Position newPosition = this.eliminateVirus(doctor);
            grid.painter.paint(doctor.row(), doctor.col());
            grid.painter.paintDoctor(newPosition.row(), newPosition.col());
            doctorsNewPositions.add(newPosition);
        }
        doctorsList = doctorsNewPositions;
    }


    @Override
    public Position eliminateVirus(Position position) {
        Position randomPosition = aStepTowardVirus (position);
        List<Position> nextVirus = grid.model.next(randomPosition).stream().filter(model.virus.getVirusPositions()::contains).toList();
        eliminate(randomPosition);
        for (Position virus : nextVirus)
            eliminate(virus);
        return randomPosition;
    }

}
