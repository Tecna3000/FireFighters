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

    FireFighters fireFighters = new FireFighters(this) ;
    Fires fires = new Fires(this);
    Clouds clouds = new Clouds(this);
    FireTrucks fireTrucks = new FireTrucks(this);
    Mountains mountains= new Mountains(this);
    Road road = new Road(this);


    public Model(Grid grid) {
        this.grid = grid;
        this.painter = new Painter(this.grid);
        colCount = grid.colCount;
        rowCount = grid.rowCount;
    }


    public void initialisation(int fireNumber, int fireFighterNumber, int cloudNumber, int fireTrucksNumber,int mountainsNumber,int roadNumber) {
        fires.initialisation(fireNumber);
        fireFighters.initialisation(fireFighterNumber);
        clouds.initialisation(cloudNumber);
        fireTrucks.initialisation(fireTrucksNumber);
        mountains.initialisation(mountainsNumber);
        road.initialisation(roadNumber);
    }

    public void activation() {
        fireFighters.activation();
        clouds.activation();
        fireTrucks.activation();
        mountains.activation();
        road.activation();
        fires.activation();
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