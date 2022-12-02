package controller;

import elements.*;
import util.Position;
import view.GridPainter;


import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class Model {
    public Grid grid;
    public GridPainter painter;

    public double colCount;
    public double rowCount;


    private final FireFighters fireFighters ;
    private final FireTrucks fireTrucks ;
    private final Clouds clouds;
    private final Rocks rock;
    public Fires fires;
    public Mountains mountains;
    public Road road;

    public Model(controller.Grid grid) {
        this.grid = grid;
        try {
            this.painter = new GridPainter(grid);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        colCount = grid.colCount;
        rowCount = grid.rowCount;
        fireFighters = new FireFighters(grid, this);
        fires = new Fires(grid, this);
        clouds = new Clouds(grid, this);
        fireTrucks = new FireTrucks(grid, this);
        mountains = new Mountains(grid, this);
        road = new Road(grid, this);
        rock = new Rocks(grid, this);

    }


    public void initialisation(int fireNumber, int fireFighterNumber, int cloudNumber, int fireTrucksNumber,int mountainsNumber, int roadNumber, int rockNumber) {
        road.initialisation(roadNumber);
        rock.initialisation(rockNumber);
        fireFighters.initialisation(fireFighterNumber);
        clouds.initialisation(cloudNumber);
        fireTrucks.initialisation(fireTrucksNumber);
        mountains.initialisation(mountainsNumber);
        fires.initialisation(fireNumber);


    }

    public void activation() {
        road.activation();
        rock.activation();
        fireFighters.activation();
        clouds.activation();
        fireTrucks.activation();
        mountains.activation();
        fires.activation();
    }

    public List<Position> next(Position position) {
        List<Position> list = new ArrayList<>();
        if (position.row() > 0) list.add(new Position(position.row() - 1, position.col()));
        if (position.col() > 0) list.add(new Position(position.row(), position.col() - 1));
        if (position.row() < rowCount - 1) list.add(new Position(position.row() + 1, position.col()));
        if (position.col() < colCount - 1) list.add(new Position(position.row(), position.col() + 1));
        return list;
    }

    public List<Position> nextSkipMountain(Position position) {
        List<Position> list = next(position);
        for(Position mountain : mountains.getMountainsPositions())
            list.remove(mountain);
        return list;
    }
    //todo: update this methode
    public List<Position> nextSkipMountainAndRoad(Position position) {
        List<Position> list = nextSkipMountain(position);
        for(Position road : road.getRoadPositions())
            list.remove(road);
        return list;
    }
    public Position randomPosition() {
        return new Position((int) (Math.random() *rowCount), (int) (Math.random() * colCount));
    }
}
