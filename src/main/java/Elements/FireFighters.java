package Elements;

import Model.Model;
import javafx.scene.image.Image;

import java.io.File;
import java.net.MalformedURLException;
import java.util.*;

public class FireFighters extends Elements {


    List<Position> firefightersList = new ArrayList<>();
    List<Position> ffNewPositions;
    Image ffImage;

    {
        try {
            ffImage = new Image( new File("../firefighterstarter/src/main/java/Painter/images/firefighter.png").toURI().toURL().toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    public FireFighters(Model model) {
        super(model);
    }

    @Override
    public void initialisation(int number) {
        for (int index = 0; index < number; index++)
            firefightersList.add(randomPosition());

    }


    @Override
    public void activation() {

        ffNewPositions = new ArrayList<>();
        for (Position ff : firefightersList) {
            Position newPosition = move(ff);
            model.painter.paint(ff.row, ff.col);
            model.painter.paintElement(ffImage, newPosition.row, newPosition.col);
            ffNewPositions.add(newPosition);
        }
       firefightersList = ffNewPositions;

    }

    private void extinguish(Position position) {
        Fires.firesList.remove(position);
        model.painter.paint(position.row, position.col);
    }
     Position move(Position position) {
        Position randomPosition = aStepTowardFire(position);
        List<Position> nextFires = model.next(randomPosition).stream().filter(Fires.firesList::contains).toList();
        extinguish(randomPosition);
        for (Position fire : nextFires)
            extinguish(fire);
        return randomPosition;
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
            if (Fires.firesList.contains(current))
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
}