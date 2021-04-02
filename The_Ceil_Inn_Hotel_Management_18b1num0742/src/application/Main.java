package application;

import application.controllers.HomePageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Hotel management system
 * @version 1.0
 * @author EnkhErdene
 */
public class Main extends Application {
    /**
     * Programiin vndsen tsonh
     */
    private Stage primaryStage;
    /**
     * Programiin vndsen tsonhnii aguulagch
     */
    private FlowPane homePage;
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Programiig ehlvvleh method
     * @param primaryStage = programiin vndsen tsonh
     */
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Ceil Inn");
        initHomePageLoad();
    }

    /**
     * Programiin vndsen page-iig vvsgene
     */
    public void initHomePageLoad(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Homepage.fxml"));
            homePage = (FlowPane) loader.load();
            Scene scene = new Scene(homePage);
            primaryStage.setScene(scene);
            HomePageController controller = loader.getController();
            controller.setMain(this);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

}
