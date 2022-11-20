package Elements;

import Model.Model;

public abstract class FireExtinguisher {
    Model model;
    public FireExtinguisher(Model model){
        this.model = model;
    }
    abstract void extinguish(Position position);
    abstract Position move();
    abstract Position aStepTowardFire(Position position);
}
