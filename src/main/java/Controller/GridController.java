//
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.input.MouseEvent;
//
//public class GridController {
//
//    Controller.Gridbis grid;
//    Painter.GridPainter painter;
//    GraphicsContext context;
//
//    public int width, height;
//    Model model;
//    public GridController(Controller.Gridbis grid){
//        this.grid = grid;
//        this.context = grid.getGraphicsContext2D();
//        grid.setFocusTraversable(true);
//        grid.setOnMousePressed(this::mousePressed);
//        painter = new Painter.GridPainter( grid);
//        this.width = grid.width; this.height = grid.height;
//    }
//
//
//    public void restart(MouseEvent mouseEvent){
//        model = new Model(this);
//        model.initialisation(3,6);
//        context.clearRect(0,0,width,height);
//        painter.repaint();
//    }
//
//    private void mousePressed(MouseEvent mouseEvent) {
//        model.activation();
//        painter.repaint();
//
//    }
//
//}
