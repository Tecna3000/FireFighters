package model;

import util.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class Movement {

    public int rowCount, colCount;

    public Movement(int rowCount, int colCount) {
        this.rowCount = rowCount;
        this.colCount = colCount;
    }

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
}
