package elements;
import controller.PandemicGame;
import controller.PandemicGrid;
import util.Position;

import java.util.*;

public abstract class VirusEliminator implements Elements {
    PandemicGame model;
    PandemicGrid grid;
    public VirusEliminator(PandemicGrid grid, PandemicGame model){
        this.grid = grid;
        this.model = model;
    }

    protected void eliminate(Position position) {
        model.virus.getVirusPositions().remove(position);
        grid.painter.paint(position.row(), position.col());
    }

    public Position aStepTowardVirus(Position position) {
        Set<Position> seen = new HashSet<>();
        HashMap<Position, Position> firstMove = new HashMap<>();
        Queue<Position> toVisit = new LinkedList<>(model.next(position));
        for (Position initialMove : toVisit)
            firstMove.put(initialMove, initialMove);
        while (!toVisit.isEmpty()) {
            Position current = toVisit.poll();
            if (model.virus.getVirusPositions().contains(current))
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

    @Override
    public void initialisation(int number) {

    }
    @Override
    public void activation() {

    }
}
