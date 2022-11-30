//package view;
//
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.image.Image;
//import javafx.scene.paint.Color;
//import model.Grid;
//
//import java.io.File;
//import java.net.MalformedURLException;
//
//public class GridPainter implements Paint{
//    double width;
//    double height;
//    int colCount;
//    int rowCount;
//    Grid grid;
//    GraphicsContext context;
//
//    Image ffImage;
//
//    {
//        try {
//            ffImage = new Image( new File("../images/firefighter.png").toURI().toURL().toString());
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    Image fireImage;
//
//    {
//        try {
//            fireImage = new Image( new File("../images/flamme.png").toURI().toURL().toString());
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    Image ftImage;
//
//    {
//        try {
//            ftImage = new Image( new File("../images/firetruck.png").toURI().toURL().toString());
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    Image cloudImage;
//
//    {
//        try {
//            cloudImage = new Image( new File("../images/rain.png").toURI().toURL().toString());
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    Image mountainImage;
//
//    {
//        try {
//            mountainImage = new Image( new File("../images/mountain.png").toURI().toURL().toString());
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//    Image roadImage;
//
//    {
//        try {
//            roadImage = new Image( new File("../images/road.png").toURI().toURL().toString());
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    Image rockImage;
//
//    {
//        try {
//            rockImage = new Image( new File("../images/rocks.png").toURI().toURL().toString());
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public GridPainter(Grid grid){
//        this.grid = grid;
//        context = grid.getGraphicsContext2D();
//        this.width = grid.getWidth();
//        this.height = grid.getHeight();
//        this.colCount = grid.colCount;
//        this.rowCount = grid.rowCount;
//    }
//
//    @Override
//    public void repaint() {
//        for(int col=0; col<colCount; col++)
//            context.strokeLine(0, col*width/colCount, height, col*width/colCount);
//        for(int row=0; row<rowCount;row++)
//            context.strokeLine(row*height/rowCount,0,row*height/rowCount, width);
//    }
//
//    @Override
//    public void paint(int row, int col) {
//        context.setFill(Color.WHITE);
//        context.fillRect(row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
//    }
//
//    public void paintFire(int row, int col) {
//        context.drawImage(fireImage,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
//    }
//    public void paintFF(int row, int col) {
//        context.drawImage(ffImage,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
//
//    }
//    public void paintFireTrucks(int row, int col) {
//        context.drawImage(ftImage,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
//
//    }
//    public void paintCloud(int row, int col) {
//        context.drawImage(cloudImage,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
//
//    }
//
//    public void  paintMountain(int row, int col) {
//        context.drawImage(mountainImage,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
//
//    }
//
//    public void paintRoad(int row, int col) {
//        context.drawImage(roadImage,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
//
//    }
//
//    public void paintRock(int row, int col) {
//        context.drawImage(rockImage,row*height/rowCount,col*width/colCount,height/rowCount,width/colCount);
//
//    }
//
//}
