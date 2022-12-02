package controller;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

import view.GridPainter;

import java.net.MalformedURLException;


public class Grid extends Canvas implements Controller {
    int width, height;
     public int colCount;
    public int rowCount;
    public controller.Model model;
    public GridPainter painter;

    public Grid(int width, int height, int colCount, int rowCount) throws MalformedURLException {
        super(width,height);
        this.colCount = colCount;this.rowCount = rowCount;
        this.width = width;this.height = height;
        painter = new GridPainter(this);
        setFocusTraversable(true);
        setOnMousePressed(this::mousePressed);
        model = new controller.Model(this);
        model.initialisation(5,8,3,3,6,4,5);
    }

    @Override
    public void restart(MouseEvent mouseEvent) {
        model = new controller.Model(this);
        model.initialisation(5,6,3,3,6,4,5);
        try {
            painter = new GridPainter(this);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        getGraphicsContext2D().clearRect(0,0,width, height);
        painter.repaint();
    }
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        model.activation();
        painter.repaint();
    }
}

