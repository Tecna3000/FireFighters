package element;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Mountains implements element {
    List<Position> mountainsList = new ArrayList<>();
    controller.Grid grid;
    controller.Model model;
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
