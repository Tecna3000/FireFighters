package elements;

import model.Model;
import javafx.scene.image.Image;
import util.Position;
import view.GridPainter;

import java.io.File;
import java.net.MalformedURLException;
import java.util.*;

public class FireTrucks extends Elements{
    List<Position> firetrucksList = new ArrayList<>();
    List<Position> ftNewPositions;

    GridPainter painter = new GridPainter(model.grid);
    Image ftImage;
    {
        try {
            ftImage = new Image( new File("../firefighterstarter/src/main/java/view/images/firetruck.png").toURI().toURL().toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    public FireTrucks(Model model) {
        super(model);
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
            Position newPosition = move(ft);
            model.painter.paint(ft.row, ft.col);
            painter.paint(newPosition.row, newPosition.col);
            ftNewPositions.add(newPosition);
        }
        firetrucksList = ftNewPositions;

    }

    private void extinguish(Position position) {
        Fires.firesSet.remove(position);
        model.painter.paint(position.row, position.col);
    }
    Position move(Position position) {
        Position randomPosition = twoStepsTowardFire(position);
        List<Position> nextFires = model.next(randomPosition).stream().filter(Fires.firesSet::contains).toList();
        extinguish(randomPosition);
        for (Position fire : nextFires)
            extinguish(fire);
        return randomPosition;
    }
    private Position twoStepsTowardFire(Position position){
        Position firstStep = aStepTowardFire(position);
        return aStepTowardFire(firstStep);
    }
    private Position aStepTowardFire(Position position) {
        Queue<Position> toVisit = new LinkedList<>();
        Set<Position> seen = new HashSet<>();
        HashMap<Position, Position> firstMove = new HashMap<>();
        toVisit.addAll(model.next(position));
        for (Position initialMove : toVisit)
            firstMove.put(initialMove, initialMove);
        while (!toVisit.isEmpty()) {
            Position current = toVisit.poll();
            if (Fires.firesSet.contains(current))
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
}
