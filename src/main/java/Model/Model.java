package Model;

import Elements.Elements;
import Elements.FireFighters;
import Elements.Fires;
import Elements.Clouds;
import Elements.Position;
import Painter.Painter;


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

    public Model(Grid grid) {
        this.grid = grid;
        this.painter = new Painter(this.grid);
        colCount = grid.colCount;
        rowCount = grid.rowCount;
    }


    public void initialisation(int fireNumber, int fireFighterNumber, int cloudNumber) {
        fires.initialisation(fireNumber);
        fireFighters.initialisation(fireFighterNumber);
        clouds.initialisation(cloudNumber);
    }

    public void activation() {
        fireFighters.activation();
        fires.activation();
        clouds.activation();

    }

    public List<Position> next(Position position) {
        List<Position> list = new ArrayList<>();
        if (position.row > 0) list.add(new Position(position.row - 1, position.col));
        if (position.col > 0) list.add(new Position(position.row, position.col - 1));
        if (position.row < rowCount - 1) list.add(new Position(position.row + 1, position.col));
        if (position.col < colCount - 1) list.add(new Position(position.row, position.col + 1));
        return list;
    }
}
