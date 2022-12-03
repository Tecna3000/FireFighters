package elements;

import controller.FireFighterGrid;
import controller.FireFighterGame;
import util.Position;

import java.util.*;

public abstract class FireExtinguisher implements Elements {
    FireFighterGame model;
    FireFighterGrid grid;
    public FireExtinguisher(FireFighterGrid grid, FireFighterGame model){
        this.grid = grid;
        this.model = model;
    }

    void extinguish(Position position) {
        model.fires.getFiresPositions().remove(position);
        model.painter.paint(position.row(), position.col());
    }

    Position aStepTowardFire(Position position) {
        Set<Position> seen = new HashSet<>();
        HashMap<Position, Position> firstMove = new HashMap<>();
        Queue<Position> toVisit = new LinkedList<>(model.nextSkipMountain(position));
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
    public void initialisation(int number) {

    }
    @Override
    public void activation() {

    }
}
