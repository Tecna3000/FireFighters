package firefighters;

import util.Position;
import java.util.*;

public class FireFighters extends FireExtinguisher implements FightFire  {
    private List<Position> firefightersList = new ArrayList<>();

    public FireFighters(FireFighterGrid grid, FireFighterGame model) {
        super(grid,model);
    }

    @Override
    public void initialisation(int number) {
        for (int index = 0; index < number; index++)
            firefightersList.add(model.randomPosition());
    }

    @Override
    public void activation() {
        List<Position> ffNewPositions = new ArrayList<>();
        for (Position ff : firefightersList) {
            Position newPosition = this.fightFire(ff);
            grid.painter.paint(ff.row(), ff.col());
            grid.painter.paintFF(newPosition.row(), newPosition.col());
            ffNewPositions.add(newPosition);
        }
        firefightersList = ffNewPositions;
    }

    @Override
    public Position fightFire(Position position) {
        Position randomPosition = aStepTowardFire(position);
        List<Position> nextFires = grid.model.next(randomPosition).stream().filter(model.fires.getFiresPositions()::contains).toList();
        extinguish(randomPosition);
        for (Position fire : nextFires)
          extinguish(fire);
        return randomPosition;
    }
}
