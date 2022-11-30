package model;

import elements.*;
import util.Position;
import view.Painter;


import java.util.ArrayList;
import java.util.List;
public class Model {

    public Grid grid;
    public Painter painter;

    public double colCount;
    public double rowCount;

    public int step = 0;
    Elements fireFighters = new FireFighters(this) ;
    Elements fires = new Fires(this);
    Elements clouds = new Clouds(this);
    Elements fireTrucks = new FireTrucks(this);
    Mountains mountains= new Mountains(this);


    public Model(Grid grid) {
        this.grid = grid;
        this.painter = new Painter(this.grid);
        colCount = grid.colCount;
        rowCount = grid.rowCount;
    }


    public void initialisation(int fireNumber, int fireFighterNumber, int cloudNumber, int fireTrucksNumber,int mountainsNumber) {
        fires.initialisation(fireNumber);
        fireFighters.initialisation(fireFighterNumber);
        clouds.initialisation(cloudNumber);
        fireTrucks.initialisation(fireTrucksNumber);
        mountains.initialisation(mountainsNumber);
    }

    public void activation() {
        fireFighters.activation();
        fires.activation();
        clouds.activation();
        fireTrucks.activation();
        mountains.activation();

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


    public Position randomPosition() {
        return new Position((int) (Math.random() *rowCount), (int) (Math.random() * colCount));
    }


}
