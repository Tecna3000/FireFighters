public abstract class Element {
    double colCount;
    double rowCount;
    Model model;
    public Element(Model model) {
        this.model=model;
    }
    abstract  void initialisation(int number);
    abstract void activation();
    abstract Position move(Position position);


    public  Position randomPosition() {
        return new Position((int) (Math.random() * model.rowCount), (int) (Math.random() * model.colCount));
    }


}
