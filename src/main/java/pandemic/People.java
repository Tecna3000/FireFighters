package pandemic;

import controller.PandemicGame;
import controller.PandemicGrid;
import elements.Elements;
import util.Position;

import java.util.ArrayList;
import java.util.List;

public class People implements Elements {
    private final List<Position> peoplePositions = new ArrayList<>();
    PandemicGrid grid;
    PandemicGame model;
    public People(PandemicGrid grid, PandemicGame model) {
        this.grid = grid;
        this.model = model;
    }
    @Override
    public void initialisation(int number) {
        for (int index = 0; index < number; index++)
            peoplePositions.add(model.randomPosition());

    }

    @Override
    public void activation() {
        for(Position people : peoplePositions) grid.painter.paintPeople(people.row(),people.col());

    }
    public List<Position> getPeoplePositions() {
        return peoplePositions;
    }

}
