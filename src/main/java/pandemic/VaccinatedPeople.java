package pandemic;

import model.Elements;
import util.Position;

import java.util.ArrayList;
import java.util.List;

public class VaccinatedPeople implements Elements {
    private final List<Position> vpPositions = new ArrayList<>();
    PandemicGrid grid;
    PandemicGame model;
    public VaccinatedPeople(PandemicGrid grid, PandemicGame model) {
        this.grid = grid;
        this.model = model;
    }
    @Override
    public void initialisation(int number) {
        for (int index = 0; index < number; index++)
            vpPositions.add(model.randomPosition());

    }

    @Override
    public void activation() {
        for(Position people : vpPositions) grid.painter.paintVp(people.row(),people.col());

    }
    public List<Position> getPositions() {
        return vpPositions;
    }
}

