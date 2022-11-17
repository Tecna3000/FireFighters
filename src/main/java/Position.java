import java.util.Objects;

public  final class Position {
    final int row;
    final int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int row() {
        return row;
    }

    public int col() {
        return col;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that =  obj;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }


    @Override
    public String toString() {
        return "Position[" +
                "row=" + row + ", " +
                "col=" + col + ']';
    }

    public static Position randomPosition(double rowCount, double colCount) {
        return new Position((int) (Math.random() * rowCount), (int) (Math.random() * colCount));
    }

}