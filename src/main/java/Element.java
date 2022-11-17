public abstract class Element {
    double colCount;
    double rowCount;
    Model model;
    public Element(Model model) {
    }
    abstract  void initialisation(int number);
    abstract void activation();
    abstract Position move(Position position);



}
