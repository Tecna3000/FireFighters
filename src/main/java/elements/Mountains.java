package elements;

import controller.Grid;
import controller.Model;
import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Mountains implements Elements {
    private final List<Position> mountainsList = new ArrayList<>();
    Grid grid;
    Model model;
    public Mountains(controller.Grid grid,controller.Model model) {
        this.grid =  grid;
        this.model = model;
    }

    @Override
    public void initialisation(int number) {
        for (int index = 0; index < number; index++)
            mountainsList.add(model.randomPosition());
    }
    @Override
    public void activation() {
        for(Position mountain : mountainsList)
            grid.painter.paintMountain(mountain.row(),mountain.col());
    }
    public List<Position> getMountainsPositions() {
        return mountainsList;
    }

}
