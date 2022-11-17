public abstract class Elements {
    Model model;
    public Elements(Model model) {
        this.model=model;
    }
    abstract  void initialisation(int number);
    abstract void activation();
    abstract Position move(Position position);


    public  Position randomPosition() {
        return new Position((int) (Math.random() * model.rowCount), (int) (Math.random() * model.colCount));
    }


}
