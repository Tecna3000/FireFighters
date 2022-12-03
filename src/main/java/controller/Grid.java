package controller;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
public abstract class Grid extends Canvas implements  Controller {
    public int colCount, rowCount;
    public Grid(int width, int height, int colCount, int rowCount) {
        super(width, height);
        this.colCount = colCount;this.rowCount = rowCount;


    }

    @Override
    public void restart(MouseEvent mouseEvent) {
    }
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }
}