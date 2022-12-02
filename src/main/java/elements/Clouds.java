package elements;


import util.Position;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Clouds extends FireExtinguisher implements FightFire{
    private List<Position> cloudsList = new ArrayList<>();

    public Clouds(controller.Grid grid,controller.Model model) {
        super(grid,model);
    }

    @Override
    public void initialisation(int number) {
        for (int index = 0; index < number; index++) cloudsList.add(model.randomPosition());
    }

    @Override
    public void activation() {
        List<Position> cloudsNewPositions = new ArrayList<>();
        for (Position cloud : cloudsList) {
            Position newPosition = fightFire(cloud);
            grid.painter.paint(cloud.row(), cloud.col());
            grid.painter.paintCloud(newPosition.row(), newPosition.col());
            cloudsNewPositions.add(newPosition);
        }
        cloudsList = cloudsNewPositions;
    }

    public Position randomStep(Position position){
        List<Position> positions = model.next(position);
        Random random = new Random();
        int randomPosition = random.nextInt(positions.size());
        if(!model.road.getRoadPositions().contains(positions.get(randomPosition)) ){
            return  positions.get(randomPosition);
        }
       return randomStep(position);
    }
    @Override
    public Position fightFire(Position position) {
        Position randomPosition = randomStep(position);
        List<Position> nextFires = model.next(randomPosition).stream().filter(model.fires.getFiresPositions()::contains).toList();
        extinguish(randomPosition);
        for (Position fire : nextFires)
            extinguish(fire);
        return randomPosition;
    }
}
