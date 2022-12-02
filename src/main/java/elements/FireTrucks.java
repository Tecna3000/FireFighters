package elements;

import util.Position;

import java.util.*;

public class FireTrucks extends FireExtinguisher implements FightFire {
    private List<Position> firetrucksList = new ArrayList<>();
    private List<Position> ftNewPositions;

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