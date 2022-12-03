package controller;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

import java.net.MalformedURLException;

public abstract class Grid extends Canvas implements  Controller {
    int width, height;
    private int colCount, rowCount;

    public Grid(int width, int height, int colCount, int rowCount) {
        super(width, height);
        this.colCount = colCount;
        this.rowCount = rowCount;
        this.width = width;
        this.height = height;
    }

    @Override
    public void restart(MouseEvent mouseEvent) {
    }
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }
}