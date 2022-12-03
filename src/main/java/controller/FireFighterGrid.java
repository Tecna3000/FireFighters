package controller;

import javafx.scene.input.MouseEvent;

import view.FfPainter;

import java.net.MalformedURLException;


public class FireFighterGrid extends Grid{
    private final int width,height;
    public FireFighterGame model;
    public FfPainter painter;
    public final int colCount;
    public final int rowCount;


    public FireFighterGrid(int width, int height, int colCount, int rowCount) throws MalformedURLException {
        super(width, height,colCount,rowCount);
        this.colCount = colCount;this.rowCount = rowCount;
        this.width = width;this.height = height;
        painter = new FfPainter(this);
        setFocusTraversable(true);
        setOnMousePressed(this::mousePressed);
        model = new FireFighterGame(this);
        model.initialisation();
    }
    @Override
    public void restart(MouseEvent mouseEvent) {
        model = new FireFighterGame(this);
        model.initialisation();
        try {
            painter = new FfPainter(this);
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

