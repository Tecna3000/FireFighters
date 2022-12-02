package element;

import controller.Grid;
import controller.Model;
import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Rocks implements elements {
    Grid grid;
    Model model;
    List<Position> rockPositions = new ArrayList<>();
    public Rocks(Grid grid, controller.Model model) {
        this.grid = grid;
        this.model = model;

    }
    @Override
    public void initialisation(int number) {
        for (int index = 0; index < number; index++)
            rockPositions.add(model.randomPosition());
    }

    @Override
    public void activation() {
        for(Position road : rockPositions) grid.painter.paintRock(road.row(),road.col());
    }
}
