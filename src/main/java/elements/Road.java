package elements;

import controller.Grid;
import controller.Model;
import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Road implements Elements,Obstacles{

    Grid grid;
    Model model;
    private final List<Position> roadPositions = new ArrayList<>();
    public Road(Grid grid, Model model) {
        this.grid = grid;
        this.model = model;

    }
    @Override
    public void initialisation(int number) {
        for (int index = 0; index < number; index++)
            roadPositions.add(setPosition());
    }

    @Override
    public void activation() {
        for(Position road : roadPositions) grid.painter.paintRoad(road.row(),road.col());

    }
    @Override
    public Position setPosition() {
        Position randomPosition = model.randomPosition();
        if(!(model.mountains.getPositions().contains(randomPosition)||model.rock.getPositions().contains(randomPosition))){
            return  randomPosition;
        }
        return setPosition();
    }
    @Override
    public List<Position> getPositions() {
        return roadPositions;
    }
}
