package view;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.File;
import java.net.MalformedURLException;
public class GridPainter implements Painter {
    double width;
    double height;
    int colCount;
    int rowCount;
    controller.Grid grid;
    GraphicsContext context;
    Image ffImage = new Image( new File("../firefighterstarter/src/main/java/view/images/firefighter.png").toURI().toURL().toString());
    Image fireImage = new Image( new File("../firefighterstarter/src/main/java/view/images/flamme.png").toURI().toURL().toString());
    Image ftImage = new Image( new File("../firefighterstarter/src/main/java/view/images/firetruck.png").toURI().toURL().toString());
    Image cloudImage = new Image( new File("../firefighterstarter/src/main/java/view/images/rain.png").toURI().toURL().toString());
    Image mountainImage = new Image( new File("../firefighterstarter/src/main/java/view/images/mountain.png").toURI().toURL().toString());
    Image roadImage = new Image( new File("../firefighterstarter/src/main/java/view/images/road.png").toURI().toURL().toString());
    Image rockImage = new Image( new File("../firefighterstarter/src/main/java/view/images/rocks.png").toURI().toURL().toString());

    public GridPainter(controller.Grid grid) throws MalformedURLException {
        this.grid = grid;
        context = grid.getGraphicsContext2D();
        this.width = grid.getWidth();
        this.height = grid.getHeight();
        this.colCount = grid.colCount;
        this.rowCount = grid.rowCount;
    }

    @Override
    public void repaint() {
        for(int col=0; col<colCount; col++)
            context.strokeLine(0, col*width/colCount, height, col*width/colCount);
        for(int row=0; row<rowCount;row++)
            context.strokeLine(row*height/rowCount,0,row*height/rowCount, width);
    }

    @Override
    public void paint(int row, int col) {
        context.setFill(Color.WHITE);
        context.fillRect(row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
    }

    public void paintFire(int row, int col) {

        context.drawImage(fireImage,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
    }
    public void paintFF(int row, int col) {
        context.drawImage(ffImage,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);

    }
    public void paintFireTrucks(int row, int col) {
        context.drawImage(ftImage,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);

    }
    public void paintCloud(int row, int col) {
        context.drawImage(cloudImage,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);

    }

    public void  paintMountain(int row, int col) {
        context.drawImage(mountainImage,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);

    }

    public void paintRoad(int row, int col) {
        context.drawImage(roadImage,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);

    }

    public void paintRock(int row, int col) {
        context.drawImage(rockImage,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);

    }

}
