package elements;

import controller.Grid;
import controller.Model;
import util.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rocks implements elements {
    Grid grid;
    Model model;
    private List<Position> rockPositions = new ArrayList<>();
    public Rocks(Grid grid, controller.Model model) {
        this.grid = grid;
        this.model = model;

    }
    @Override
    public void initialisation(int number) {
        for (int index = 0; index < number; index++)
            rockPositions.add(setPosition());
    }
    public Position setPosition(){
        Position randomPosition = model.randomPosition();
        if(!(model.road.getRoadPositions().contains(randomPosition)||model.mountains.getMountainsPositions().contains(randomPosition))){
            return  randomPosition;
        }
        return setPosition();
    }

    @Override
    public void activation() {
        for(Position road : rockPositions) grid.painter.paintRock(road.row(),road.col());
    }
}
