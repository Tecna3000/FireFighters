import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Model {

    Grid grid;
    double colCount;
    double rowCount;
    List<Position> firefightersList = new ArrayList<>();
    Set<Position> firesList = new HashSet<>();
    List<Position> ffNewPositions;
    int step = 0;
    List<Element> elements = new ArrayList<>();
    Element fireFighters = new FireFighters(this) ;
    Element fires = new Fires(this);

    public Model(Grid grid) {
        this.grid = grid;
        colCount = grid.colCount;
        rowCount = grid.rowCount;
    }


    public void initialisation(int fireNumber, int fireFighterNumber) {
        fires.initialisation(fireNumber);
        fireFighters.initialisation(fireFighterNumber);
    }

    public void activation() {
        fireFighters.activation();
        fires.activation();

    }

    List<Position> next(Position position) {
        List<Position> list = new ArrayList<>();
        if (position.row > 0) list.add(new Position(position.row - 1, position.col));
        if (position.col > 0) list.add(new Position(position.row, position.col - 1));
        if (position.row < rowCount - 1) list.add(new Position(position.row + 1, position.col));
        if (position.col < colCount - 1) list.add(new Position(position.row, position.col + 1));
        return list;
    }
}
