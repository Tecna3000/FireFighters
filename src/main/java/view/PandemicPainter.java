package view;

import controller.FireFighterGrid;
import controller.PandemicGrid;
import javafx.scene.image.Image;

import java.io.File;
import java.net.MalformedURLException;

public class PandemicPainter extends GridPainter {

    Image doctorImage = new Image( new File("../firefighters/src/main/java/view/images/firefighter.png").toURI().toURL().toString());
    Image virusImage = new Image( new File("../firefighters/src/main/java/view/images/flamme.png").toURI().toURL().toString());
    Image peopleImage = new Image( new File("../firefighters/src/main/java/view/images/firetruck.png").toURI().toURL().toString());
    Image doctorVImage = new Image( new File("../firefighters/src/main/java/view/images/rain.png").toURI().toURL().toString());
    Image vpImage = new Image( new File("../firefighters/src/main/java/view/images/mountain.png").toURI().toURL().toString());

    public PandemicPainter(PandemicGrid grid) throws MalformedURLException {
        super(grid);
    }
    public void paintVirus(int row, int col) {

        context.drawImage(virusImage,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
    }
    public void paintDoctor(int row, int col) {
        context.drawImage(doctorImage,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);

    }
    public void paintDv(int row, int col) {
        context.drawImage(doctorVImage,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);

    }
    public void paintPeople(int row, int col) {
        context.drawImage(peopleImage,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);

    }

    public void  paintVp(int row, int col) {
        context.drawImage(vpImage,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);

    }
}
