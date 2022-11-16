import java.util.*;

public class FireFighters extends Element{


    public FireFighters(Model model) {
        super(model);
    }

    @Override
    void initialisation(int number) {
        for (int index = 0; index < number; index++)
            model.firefighters.add(Position.randomPosition((int) super.rowCount, (int) super.colCount));

    }


    @Override
    void activation() {
        model.ffNewPositions = new ArrayList<>();
        for (Position ff : model.firefighters) {
            Position newPosition = activate(ff);
            model.grid.paint(ff.row, ff.col);
            model.grid.paintFF(newPosition.row, newPosition.col);
            model.ffNewPositions.add(newPosition);
        }
        model.firefighters = model.ffNewPositions;
        model.step++;
    }

    private void extinguish(Position position) {
        model.fires.remove(position);
        model.grid.paint(position.row, position.col);
    }
     Position activate(Position position) {
        Position randomPosition = aStepTowardFire(position);
        List<Position> nextFires = model.next(randomPosition).stream().filter(model.fires::contains).toList();
        extinguish(randomPosition);
        for (Position fire : nextFires)
            extinguish(fire);
        return randomPosition;
    }

    private Position aStepTowardFire(Position position) {
        Queue<Position> toVisit = new LinkedList<>();
        Set<Position> seen = new HashSet<>();
        HashMap<Position, Position> firstMove = new HashMap<>();
        toVisit.addAll(model.next(position));
        for (Position initialMove : toVisit)
            firstMove.put(initialMove, initialMove);
        while (!toVisit.isEmpty()) {
            Position current = toVisit.poll();
            if (model.fires.contains(current))
                return firstMove.get(current);
            for (Position adjacent : model.next(current)) {
                if (seen.contains(adjacent)) continue;
                toVisit.add(adjacent);
                seen.add(adjacent);
                firstMove.put(adjacent, firstMove.get(current));
            }
        }
        return position;
    }
}
