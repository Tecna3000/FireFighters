//import javafx.scene.canvas.Canvas;
//import javafx.scene.input.MouseEvent;
//import java.net.MalformedURLException;
//public class Gridbrouillon extends Canvas {
//    double width;
//    double height;
//    double colCount;
//    double rowCount;
//    Model model;
//
//    Painter painter;
//    public Gridbrouillon(int width, int height, int colCount, int rowCount) throws MalformedURLException {
//        super(width,height);
//        this.width = width;
//        this.height = height;
//        this.colCount = colCount;
//        this.rowCount = rowCount;
//        setFocusTraversable(true);
//        setOnMousePressed(this::mousePressed);
//        painter = new Painter( width,  height,  colCount,  rowCount);
//        model = new Model(this,this.painter);
//        model.initialisation(3,8);
//    }
//
//    public void restart(MouseEvent mouseEvent){
//        model = new Model(this,this.painter);
//        model.initialisation(3,6);
//        getGraphicsContext2D().clearRect(0,0,width, height);
//        painter.repaint();
//    }
//    private void mousePressed(MouseEvent mouseEvent) {
//        model.activation();
//        painter.repaint();    }
//
//
//
//}
