import java.util.*;

public class FireFighters extends Elements {


    public FireFighters(Model model) {
        super(model);
    }

    @Override
    void initialisation(int number) {
        for (int index = 0; index < number; index++)
            model.firefightersList.add(randomPosition());

    }


    @Override
    void activation() {

        model.ffNewPositions = new ArrayList<>();
        for (Position ff : model.firefightersList) {
            Position newPosition = move(ff);
            model.grid.paint(ff.row, ff.col);
            model.grid.paintFF(newPosition.row, newPosition.col);
            model.ffNewPositions.add(newPosition);
        }
        model.firefightersList = model.ffNewPositions;

    }

    private void extinguish(Position position) {
        model.firesList.remove(position);
        model.grid.paint(position.row, position.col);
    }
     Position move(Position position) {
        Position randomPosition = aStepTowardFire(position);
        List<Position> nextFires = model.next(randomPosition).stream().filter(model.firesList::contains).toList();
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
            if (model.firesList.contains(current))
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
