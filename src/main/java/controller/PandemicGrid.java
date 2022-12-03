package controller;

import javafx.scene.input.MouseEvent;
import view.FfPainter;
import view.PandemicPainter;

import java.net.MalformedURLException;

public class PandemicGrid extends Grid{
    private final int width,height;
    public PandemicGame model;
    public PandemicPainter painter;
    final int colCount;
    final int rowCount;

    public PandemicGrid(int width, int height,int colCount, int rowCount) throws MalformedURLException {
        super(width, height,colCount,rowCount);
        this.colCount = colCount;this.rowCount = rowCount;
        this.width = width;this.height = height;
        painter = new PandemicPainter(this);
        setFocusTraversable(true);
        setOnMousePressed(this::mousePressed);
        model = new PandemicGame(this);
        model.initialisation(0,0,0,0,0,0,0);
    }
    @Override
    public void restart(MouseEvent mouseEvent) {
        model = new PandemicGame(this);
        model.initialisation(0,0,0,0,0,0,0);
        try {
            painter = new PandemicPainter(this);
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
