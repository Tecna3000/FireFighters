package Painter;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class GridPainter extends Canvas {
    int width, height, colCount, rowCount;
    Grid grid;

    public GridPainter(Gridbis grid)  {

        this.width = grid.width;
        this.height = grid.height;
        this.colCount = grid.colCount;
        this.rowCount = grid.rowCount;


    }
    void repaint(){
        for(int col=0; col<colCount; col++)
            getGraphicsContext2D().strokeLine(0, col*width/colCount, height, col*width/colCount);
        for(int row=0; row<rowCount;row++)
            getGraphicsContext2D().strokeLine(row*height/rowCount,0,row*height/rowCount, width);

    }

    void paint(int row, int col){
        getGraphicsContext2D().setFill(Color.WHITE);
        getGraphicsContext2D().fillRect(row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
    }

    public void paintElement(Image image, int row, int col) {
        getGraphicsContext2D().drawImage(image,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
    }

}
