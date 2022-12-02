package util;

public record Position(int row, int col) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row && col == position.col;
    }

    @Override
    public String toString() {
        return "Elements.Position[" +
                "row=" + row + ", " +
                "col=" + col + ']';
    }
}