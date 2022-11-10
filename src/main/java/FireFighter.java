import javax.swing.text.Position;
import java.util.*;

public class FireFighter implements Element {
   Position position;
    Set<Model.Position> fires = new HashSet<>();
    public FireFighter(Position position) {
        this.position = position;

    }


    @Override
    public void activation() {


    }

    @Override
    public void Paint() {

    }

    private List<Model.Position> next(Model.Position position) {
        List<Model.Position> list = new ArrayList<>();
        if (position.row > 0) list.add(new Model.Position(position.row - 1, position.col));
        if (position.col > 0) list.add(new Model.Position(position.row, position.col - 1));
        if (position.row < rowCount - 1) list.add(new Model.Position(position.row + 1, position.col));
        if (position.col < colCount - 1) list.add(new Model.Position(position.row, position.col + 1));
        return list;
    }

    private Model.Position aStepTowardFire(Model.Position position) {
        Queue<Model.Position> toVisit = new LinkedList<>();
        Set<Model.Position> seen = new HashSet<>();
        HashMap<Model.Position, Model.Position> firstMove = new HashMap<>();
        toVisit.addAll(next(position));
        for (Model.Position initialMove : toVisit)
            firstMove.put(initialMove, initialMove);
        while (!toVisit.isEmpty()) {
            Model.Position current = toVisit.poll();
            if (fires.contains(current))
                return firstMove.get(current);
            for (Model.Position adjacent : next(current)) {
                if (seen.contains(adjacent)) continue;
                toVisit.add(adjacent);
                seen.add(adjacent);
                firstMove.put(adjacent, firstMove.get(current));
            }
        }
        return position;
    }



}
