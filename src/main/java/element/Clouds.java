package element;

import elements.Fires;

import util.Position;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Clouds extends FireExtinguisher implements FightFire{
    List<Position> cloudsList = new ArrayList<>();
    List<Position> cloudsNewPositions;

    public Clouds(controller.Grid grid,controller.Model model) {
        super(grid,model);
    }



    @Override
    public void initialisation(int number) {
        for (int index = 0; index < number; index++) cloudsList.add(model.randomPosition());
    }

    @Override
    public void activation() {
        cloudsNewPositions = new ArrayList<>();
        for (Position cloud : cloudsList) {
            Position newPosition = fightFire(cloud);
            grid.painter.paint(cloud.row, cloud.col);
            grid.painter.paintCloud(newPosition.row, newPosition.col);
            cloudsNewPositions.add(newPosition);
        }
        cloudsList = cloudsNewPositions;

    }

    public Position randomStep(Position positon){
        List<Position> positions = model.next(positon);
        Random random = new Random();
        int randomPosition = random.nextInt(positions.size());
        return  positions.get(randomPosition);

    }
    @Override
    public Position fightFire(Position position) {
        Position randomPosition = randomStep(position);
        List<Position> nextFires = model.next(randomPosition).stream().filter(Fires.firesSet::contains).toList();
        model.extinguish(randomPosition);
        for (Position fire : nextFires)
            model.extinguish(fire);
        return randomPosition;
    }
    
}