package element;

import controller.Grid;
import controller.Model;
import util.Position;

import java.util.ArrayList;
import java.util.List;

public class Road implements element {

    Grid grid;
    Model model;
    List<Position> roadPositions = new ArrayList<>();
    public Road(Grid grid, controller.Model model) {
        this.grid = grid;
        this.model = model;

    }
    @Override
    public void initialisation(int number) {
        for (int index = 0; index < number; index++)
            roadPositions.add(model.randomPosition());
//        List<Position> list = setPosition(number);
//        roadPositions.addAll(list);

    }

    @Override
    public void activation() {
        for(Position road : roadPositions) grid.painter.paintRoad(road.row(),road.col());

    }
//    public List<Position> setPosition(int roadNumber){
//
//
//    }



    public List<Position> getRoadPositions() {
        return roadPositions;
    }

}
