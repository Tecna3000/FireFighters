package element;

import util.Position;
import java.util.*;

public class FireFighters extends FireExtinguisher implements FightFire  {
    List<Position> firefightersList = new ArrayList<>();
    List<Position> ffNewPositions;

    public FireFighters(controller.Grid grid,controller.Model model) {
        super(grid,model);
    }

    @Override
    public void initialisation(int number) {
        for (int index = 0; index < number; index++)
            firefightersList.add(model.randomPosition());

    }


    @Override
    public void activation() {
        ffNewPositions = new ArrayList<>();
        for (Position ff : firefightersList) {
            Position newPosition = this.fightFire(ff);
            grid.painter.paint(ff.row, ff.col);
            grid.painter.paintFF(newPosition.row, newPosition.col);
            ffNewPositions.add(newPosition);
        }
        firefightersList = ffNewPositions;
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
        Position randomPosition = aStepTowardFire(position);
        List<Position> nextFires = grid.model.next(randomPosition).stream().filter(model.fires.getFiresPositions()::contains).toList();
        model.extinguish(randomPosition);
        for (Position fire : nextFires)
          model.extinguish(fire);
        return randomPosition;
    }
}
