package element;

import util.Position;

public abstract class FireExtinguisher implements element {
    controller.Model model;
    controller.Grid grid;
    public FireExtinguisher(controller.Grid grid, controller.Model model){
        this.grid = grid;
        this.model = model;

    }

    void extinguish(Position position) {
        model.fires.getFiresPositions().remove(position);
        model.painter.paint(position.row, position.col);
    }

    @Override
    public void initialisation(int number) {

    }
    @Override
    public void activation() {

    }
}
