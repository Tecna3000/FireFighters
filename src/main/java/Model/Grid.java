package Model;

import Model.Model;
import Painter.Painter;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import javafx.scene.image.Image;
public class Grid extends Canvas{
    int width;
    int height;
    public int colCount;
    public int rowCount;
    public Model model;
    public Painter painter;
    public Grid(int width, int height, int colCount, int rowCount)  {
        super(width,height);
        this.width = width;
        this.height = height;
        this.colCount = colCount;
        this.rowCount = rowCount;
        painter = new Painter(this);
        setFocusTraversable(true);
        setOnMousePressed(this::mousePressed);
        model = new Model(this);
        model.initialisation(3,8,4,3);

    }

    public void restart(MouseEvent mouseEvent){
        model = new Model(this);
        model.initialisation(3,6,4,3);
        painter = new Painter(this);
        getGraphicsContext2D().clearRect(0,0,width, height);
        painter.repaint();
    }
    private void mousePressed(MouseEvent mouseEvent) {
        model.activation();
        painter.repaint();
    }
}