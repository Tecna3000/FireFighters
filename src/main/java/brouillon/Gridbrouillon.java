//import javafx.scene.canvas.Canvas;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.paint.Color;
//import java.io.File;
//import java.net.MalformedURLException;
//
//import javafx.scene.image.Image;
//public class Grid extends Canvas{
//    double width;
//    double height;
//    double colCount;
//    double rowCount;
//    Model model;
//    Painter painter;
//    public Grid(int width, int height, int colCount, int rowCount) throws MalformedURLException {
//        super(width,height);
//        this.width = width;
//        this.height = height;
//        this.colCount = colCount;
//        this.rowCount = rowCount;
//        setFocusTraversable(true);
//        setOnMousePressed(this::mousePressed);
//        this.painter = new Painter( width,  height,  colCount,  rowCount);
//        model = new Model(this);
//        model.initialisation(3,8);
//    }
//
//    public void restart(MouseEvent mouseEvent){
//        model = new Model(this);
//        model.initialisation(3,6);
//        getGraphicsContext2D().clearRect(0,0,width, height);
//        repaint();
//    }
//    private void mousePressed(MouseEvent mouseEvent) {
//        model.activation();
//        repaint();
//    }
//    void repaint(){
//        for(int col=0; col<colCount; col++)
//            getGraphicsContext2D().strokeLine(0, col*width/colCount, height, col*width/colCount);
//        for(int row=0; row<rowCount;row++)
//            getGraphicsContext2D().strokeLine(row*height/rowCount,0,row*height/rowCount, width);
//
//    }
//}
