package controller;

import util.Position;
import view.GridPainter;


import java.util.ArrayList;
import java.util.List;

public class Model {
    public controller.Grid grid;
    public GridPainter painter;

    public double colCount;
    public double rowCount;

    public element.Fires fires;
    element.FireFighters fireFighters ;
    element.FireTrucks fireTrucks ;

    element.Clouds clouds;

    public element.Mountains mountains;
    public element.Road road;


    public Model(controller.Grid grid) {
        this.grid = grid;
        this.painter = new GridPainter(grid);
        colCount = grid.colCount;
        rowCount = grid.rowCount;
        fireFighters = new element.FireFighters(grid, this);
        fires = new element.Fires(grid, this);
        clouds = new element.Clouds(grid, this);
        fireTrucks = new element.FireTrucks(grid, this);
        mountains = new element.Mountains(grid, this);
        road = new element.Road(grid, this);


    }


    public void initialisation(int fireNumber, int fireFighterNumber, int cloudNumber, int fireTrucksNumber,int mountainsNumber, int roadNumber) {
        fireFighters.initialisation(fireFighterNumber);
        clouds.initialisation(cloudNumber);
        fireTrucks.initialisation(fireTrucksNumber);
        fires.initialisation(fireNumber);
        mountains.initialisation(mountainsNumber);
        road.initialisation(roadNumber);
    }

    public void activation() {
        fireFighters.activation();
        clouds.activation();
        fireTrucks.activation();
        mountains.activation();
        fires.activation();
        road.activation();

    }

    public List<Position> next(Position position) {
        List<Position> list = new ArrayList<>();
        if (position.row > 0) list.add(new Position(position.row - 1, position.col));
        if (position.col > 0) list.add(new Position(position.row, position.col - 1));
        if (position.row < rowCount - 1) list.add(new Position(position.row + 1, position.col));
        if (position.col < colCount - 1) list.add(new Position(position.row, position.col + 1));
        return list;
    }

    public List<Position> nextSkipMountain(Position position) {
        List<Position> list = next(position);
        for(Position mountain : mountains.getMountainsPositions())
            list.remove(mountain);
        return list;
    }
    public void extinguish(Position position) {
        fires.getFiresPositions().remove(position);
        painter.paint(position.row, position.col);
    }



    public Position randomPosition() {
        return new Position((int) (Math.random() *rowCount), (int) (Math.random() * colCount));
    }
}
