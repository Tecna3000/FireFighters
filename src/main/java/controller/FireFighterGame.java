package controller;

import elements.*;
import util.Position;
import view.FfPainter;


import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class FireFighterGame implements Model {
    public FireFighterGrid grid;
    public FfPainter painter;

    public double colCount;
    public double rowCount;


    private final FireFighters fireFighters ;
    private final FireTrucks fireTrucks ;
    private final Clouds clouds;
    public final Rocks rock;
    public Fires fires;
    public Mountains mountains;
    public Road road;

    public FireFighterGame(FireFighterGrid grid) {
        this.grid = grid;
        try {
            this.painter = new FfPainter(grid);
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

    @Override
    public void initialisation(int fireNumber, int fireFighterNumber, int cloudNumber, int fireTrucksNumber,int mountainsNumber, int roadNumber, int rockNumber) {
        road.initialisation(roadNumber);
        rock.initialisation(rockNumber);
        fireFighters.initialisation(fireFighterNumber);
        clouds.initialisation(cloudNumber);
        fireTrucks.initialisation(fireTrucksNumber);
        mountains.initialisation(mountainsNumber);
        fires.initialisation(fireNumber);


    }
    @Override
    public void activation() {
        clouds.activation();
        road.activation();
        rock.activation();
        fireFighters.activation();
        fireTrucks.activation();
        mountains.activation();
        fires.activation();
    }
    @Override
    public Position randomPosition() {
        return new Position((int) (Math.random() *rowCount), (int) (Math.random() * colCount));
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
        for(Position mountain : mountains.getPositions())
            list.remove(mountain);
        return list;
    }
    public List<Position> nextSkipMountainAndRoad(Position position) {
        List<Position> list = nextSkipMountain(position);
        for(Position road : road.getPositions())
            list.remove(road);
        return list;
    }

}
