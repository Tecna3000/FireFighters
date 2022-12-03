package elements;

import model.Elements;
import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Rocks implements Elements, Obstacles {
    FireFighterGrid grid;
    FireFighterGame model;
    private final List<Position> rockPositions = new ArrayList<>();
    public Rocks(FireFighterGrid grid, FireFighterGame model) {
        this.grid = grid;
        this.model = model;
    }
    @Override
    public void initialisation(int number) {
        for (int index = 0; index < number; index++)
            rockPositions.add(setPosition());
    }
    @Override
    public void activation() {
        for(Position road : rockPositions) grid.painter.paintRock(road.row(),road.col());
    }
    @Override
    public Position setPosition(){
        Position randomPosition = model.randomPosition();
        if(!(model.road.getPositions().contains(randomPosition)||model.mountains.getPositions().contains(randomPosition))){
            return  randomPosition;
        }
        return setPosition();
    }
    @Override
    public List<Position> getPositions() {
        return rockPositions;
    }
}
