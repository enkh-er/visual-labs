package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Georgetown Cleaning Services - Cleaning Orders
 * @author enkh-erdene
 * @version 1.0
 */
public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(".//view//cleaningOrder.fxml"));
        primaryStage.setTitle("Georgetown Cleaning Services - Cleaning Orders");
        Scene scene=new Scene(root, 600, 680);
        String css=Main.class.getResource("application.css").toExternalForm();
        scene.getStylesheets().add(css);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
