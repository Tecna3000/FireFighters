package controller;

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
        model.initialisation(10,8,5,10,20,20,10);
    }
}
