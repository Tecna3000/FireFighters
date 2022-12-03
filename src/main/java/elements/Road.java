package elements;

import controller.FireFighterGrid;
import controller.FireFighterGame;
import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Road implements Elements,Obstacles{

    FireFighterGrid grid;
    FireFighterGame model;
    private final List<Position> roadPositions = new ArrayList<>();
    public Road(FireFighterGrid grid, FireFighterGame model) {
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
