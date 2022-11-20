package Controller;

import javafx.scene.canvas.Canvas;

public class Gridbis extends Canvas{
    public int width, height, colCount, rowCount;
    Model model;


    public Gridbis(int width, int height, int colCount, int rowCount) {
        super(width,height);
        this.width = width;
        this.height = height;
        this.colCount = colCount;
        this.rowCount = rowCount;

    }

}
