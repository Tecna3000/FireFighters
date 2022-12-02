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
