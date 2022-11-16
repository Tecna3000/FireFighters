import java.util.ArrayList;
import java.util.List;

public abstract class Element {
    double colCount;
    double rowCount;
    Model model;
    public Element(Model model) {
    }
    abstract  void initialisation(int number);
    abstract void activation();
    abstract Position activate(Position position);

    List<Position> next(Position position) {
        List<Position> list = new ArrayList<>();
        if (position.row > 0) list.add(new Position(position.row - 1, position.col));
        if (position.col > 0) list.add(new Position(position.row, position.col - 1));
        if (position.row < rowCount - 1) list.add(new Position(position.row + 1, position.col));
        if (position.col < colCount - 1) list.add(new Position(position.row, position.col + 1));
        return list;
    }


}
