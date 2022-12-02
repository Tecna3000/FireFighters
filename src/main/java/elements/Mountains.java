package elements;

import controller.Grid;
import controller.Model;
import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Mountains implements Elements,Obstacles {
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
            mountainsList.add(setPosition());
    }
    @Override
    public void activation() {
        for(Position mountain : mountainsList)
            grid.painter.paintMountain(mountain.row(),mountain.col());
    }
    @Override
    public List<Position> getPositions() {
        return mountainsList;
    }

    @Override
    public Position setPosition() {
        Position randomPosition = model.randomPosition();
        if(!(model.road.getPositions().contains(randomPosition)||model.rock.getPositions().contains(randomPosition))){
            return  randomPosition;
        }
        return setPosition();
    }
}
