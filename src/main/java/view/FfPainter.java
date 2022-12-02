package view;

import controller.Grid;
import javafx.scene.image.Image;

import java.io.File;
import java.net.MalformedURLException;
public class FfPainter extends GridPainter{

    Image ffImage = new Image( new File("../firefighters/src/main/java/view/images/firefighter.png").toURI().toURL().toString());
    Image fireImage = new Image( new File("../firefighters/src/main/java/view/images/flamme.png").toURI().toURL().toString());
    Image ftImage = new Image( new File("../firefighters/src/main/java/view/images/firetruck.png").toURI().toURL().toString());
    Image cloudImage = new Image( new File("../firefighters/src/main/java/view/images/rain.png").toURI().toURL().toString());
    Image mountainImage = new Image( new File("../firefighters/src/main/java/view/images/mountain.png").toURI().toURL().toString());
    Image roadImage = new Image( new File("../firefighters/src/main/java/view/images/road.png").toURI().toURL().toString());
    Image rockImage = new Image( new File("../firefighters/src/main/java/view/images/rocks.png").toURI().toURL().toString());

    public FfPainter(Grid grid) throws MalformedURLException {
        super(grid);
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
