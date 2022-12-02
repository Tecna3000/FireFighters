package element;

import util.Position;

import java.util.*;

public class FireTrucks extends FireExtinguisher implements FightFire {
    List<Position> firetrucksList = new ArrayList<>();
    List<Position> ftNewPositions;

    public FireTrucks(controller.Grid grid,controller.Model model) {
            super(grid,model);
        }

    @Override
    public void initialisation(int number) {
        for (int index = 0; index < number; index++)
            firetrucksList.add(model.randomPosition());
    }

    @Override
    public void activation() {

        ftNewPositions = new ArrayList<>();
        for (Position ft : firetrucksList) {
            Position newPosition = fightFire(ft);
            model.painter.paint(ft.row, ft.col);
            grid.painter.paintFireTrucks(newPosition.row, newPosition.col);
            ftNewPositions.add(newPosition);
        }
        firetrucksList = ftNewPositions;

    }

    private Position twoStepsTowardFire(Position position){
        Position firstStep = aStepTowardFire(position);
        return aStepTowardFire(firstStep);
    }
    private Position aStepTowardFire(Position position) {
        Queue<Position> toVisit = new LinkedList<>();
        Set<Position> seen = new HashSet<>();
        HashMap<Position, Position> firstMove = new HashMap<>();
        toVisit.addAll(model.nextSkipMountain(position));
        for (Position initialMove : toVisit)
            firstMove.put(initialMove, initialMove);
        while (!toVisit.isEmpty()) {
            Position current = toVisit.poll();
            if (model.fires.getFiresPositions().contains(current))
                return firstMove.get(current);
            for (Position adjacent : model.nextSkipMountain(current)) {
                if (seen.contains(adjacent)) continue;
                toVisit.add(adjacent);
                seen.add(adjacent);
                firstMove.put(adjacent, firstMove.get(current));
            }
        }
        return position;
    }
    @Override
    public Position fightFire(Position position) {
        Position randomPosition = twoStepsTowardFire(position);
        List<Position> nextFires = grid.model.next(randomPosition).stream().filter(model.fires.getFiresPositions()::contains).toList();
        extinguish(randomPosition);
        for (Position fire : nextFires)
            extinguish(fire);
        return randomPosition;
    }
}