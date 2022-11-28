package view;

import model.Grid;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Painter  {

    double width, height, colCount, rowCount;
    Grid grid;
    GraphicsContext context;
    public Painter(Grid grid)  {
        this.grid = grid;
        context = grid.getGraphicsContext2D();
        this.width = grid.getWidth();
        this.height = grid.getHeight();
        this.colCount = grid.colCount;
        this.rowCount = grid.rowCount;

    }
    public void repaint(){
        for(int col=0; col<colCount; col++)
           context.strokeLine(0, col*width/colCount, height, col*width/colCount);
        for(int row=0; row<rowCount;row++)
            context.strokeLine(row*height/rowCount,0,row*height/rowCount, width);

    }

    public void paint(int row, int col){
        context.setFill(Color.WHITE);
        context.fillRect(row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
    }

    public void paintElement(Image image, int row, int col) {
        context.drawImage(image,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);

    }


}
