import java.util.*;

public class FireFighter extends Element{
    private Position position;
    List<Position> firefighters = new ArrayList<>();
    List<Position> ffNewPositions;
    Set<Position> fires = new HashSet<>();
    int step = 0;
    Grid grid;;
    public FireFighter(Position position) {
        super();
        this.position = position;
    }

    @Override
    void initialisation(int number) {
        for (int index = 0; index < number; index++)
            firefighters.add(position.randomPosition());

    }

    @Override
    void activation() {
        ffNewPositions = new ArrayList<>();
        for (Position ff : firefighters) {
            Position newPosition = activateFirefighter(ff);
            grid.paint(ff.row, ff.col);
            grid.paintFF(newPosition.row, newPosition.col);
            ffNewPositions.add(newPosition);
        }
        firefighters = ffNewPositions;
        step++;
    }

    private void extinguish(Position position) {
        fires.remove(position);
        grid.paint(position.row, position.col);
    }
    private Position activateFirefighter(Position position) {
        Position randomPosition = aStepTowardFire(position);
        List<Position> nextFires = next(randomPosition).stream().filter(fires::contains).toList();
        extinguish(randomPosition);
        for (Position fire : nextFires)
            extinguish(fire);
        return randomPosition;
    }

    private Position aStepTowardFire(Position position) {
        Queue<Position> toVisit = new LinkedList<>();
        Set<Position> seen = new HashSet<>();
        HashMap<Position, Position> firstMove = new HashMap<>();
        toVisit.addAll(next(position));
        for (Position initialMove : toVisit)
            firstMove.put(initialMove, initialMove);
        while (!toVisit.isEmpty()) {
            Position current = toVisit.poll();
            if (fires.contains(current))
                return firstMove.get(current);
            for (Position adjacent : next(current)) {
                if (seen.contains(adjacent)) continue;
                toVisit.add(adjacent);
                seen.add(adjacent);
                firstMove.put(adjacent, firstMove.get(current));
            }
        }
        return position;
    }
}
