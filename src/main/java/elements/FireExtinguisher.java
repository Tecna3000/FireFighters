package elements;

import model.Model;
import util.Position;

public abstract class FireExtinguisher {
    Model model;
    public FireExtinguisher(Model model){
        this.model = model;
    }
    abstract void extinguish(Position position);
    abstract Position move();
    abstract Position aStepTowardFire(Position position);
}
