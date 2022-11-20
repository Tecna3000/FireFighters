package Elements;

import Model.Model;

public abstract class Elements {
    Model model;
    public Elements(Model model) {
        this.model=model;
    }
    public abstract  void initialisation(int number);
    public abstract void activation();
    abstract Position move(Position position);


    public Position randomPosition() {
        return new Position((int) (Math.random() * model.rowCount), (int) (Math.random() * model.colCount));
    }


}