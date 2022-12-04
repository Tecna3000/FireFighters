
import firefighters.FireFighterGrid;
import pandemic.PandemicGrid;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.FfPainter;
import view.PandemicPainter;

import java.net.MalformedURLException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class App extends Application {

    boolean isInPause = true;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws MalformedURLException {
        Group root = new Group();
        Button restart = new Button("Restart");
        Button switchPause = new Button("Pause");
        VBox buttons = new VBox();
        HBox total = new HBox();
//        FireFighterGrid grid = new FireFighterGrid(800,800,20,20);
//        FfPainter painter = new FfPainter(grid);

        PandemicGrid grid = new PandemicGrid(800,800,20,20);
        PandemicPainter painter = new PandemicPainter(grid);

        root.getChildren().add(total);
        total.getChildren().add(buttons);
        total.getChildren().add(grid);
        buttons.getChildren().add(restart);
        buttons.getChildren().add(switchPause);
        restart.setOnMouseClicked(grid::restart);
        switchPause.setOnMouseClicked((value)->isInPause = !isInPause);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        painter.repaint();

        ScheduledThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        threadPoolExecutor.scheduleAtFixedRate(() -> {
            if(!isInPause) {
                grid.model.activation();
                painter.repaint();
            }
        }, 0, 50 , TimeUnit.MILLISECONDS);
    }
}