package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    String contentStyle="-fx-padding: 10;";

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        AnchorPane root=new AnchorPane();
        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab("Танилцуулга");
        Tab tab2 = new Tab("Бүртгүүлэх");

        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);

        VBox vBox=titledBorder1();
        tab1.setContent(vBox);

        VBox vBox2=titledBorder2();
        tab2.setContent(vBox2);

        root.getChildren().add(tabPane);
        primaryStage.setTitle("Titled Borders");
        Scene scene=new Scene(root, 500, 600);
        scene.getStylesheets().add
                (Main.class.getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Энэ арга нь бүх гарчигтай хүрээнүүдийг үүсгэнэ
     * */
    VBox titledBorder1(){
        VBox vBox=new VBox();
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setPadding(new Insets(30));
        vBox.setSpacing(30);
        StackPane pane=getTopCenterTitleBorder("Lorem Ipsum","Lorem Ipsum " +
                "is simply dummy text of the printing and typesetting industry.");
        StackPane pane1=getTopLeftTitleBorder("Lorem Ipsum","Lorem Ipsum is " +
                "simply dummy text of the printing and typesetting industry.");
        StackPane pane2=getTopRightTitleBorder("Lorem Ipsum","Lorem Ipsum is " +
                "simply dummy text of the printing");
        StackPane pane3=getTopTitleBorder("Lorem Ipsum","Lorem Ipsum is simply " +
                "dummy text of the printing and Lorem Ipsum is simply dummy text of the printing " +
                "and Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        StackPane pane4=getBottomLeftTitleBorder("Lorem Ipsum","Lorem Ipsum is " +
                "simply dummy text of the printing and typesetting industry.");
        vBox.getChildren().add(pane);
        vBox.getChildren().add(pane1);
        vBox.getChildren().add(pane2);
        vBox.getChildren().add(pane3);
        vBox.getChildren().add(pane4);
        return vBox;
    }

    /**
     * Энэ арга нь бүх гарчигтай хүрээнүүдийг үүсгэнэ
     * */
    VBox titledBorder2(){
        VBox vBox=new VBox();
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setPadding(new Insets(30));
        vBox.setSpacing(30);
        StackPane pane=getTopCenterTitleBorder("Lorem Ipsum and Lorem Ipsum","Lorem Ipsum " +
                "is simply dummy text of the printing and typesetting industry.");
        StackPane pane1=getTopLeftTitleBorder("Lorem","Lorem Ipsum" +
                " is simply dummy text of the printing and typesetting industry." +
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        StackPane pane2=getTopRightTitleBorder("Lorem Ipsum","Lorem Ipsum " +
                "is simply dummy text of the printing");
        StackPane pane3=getTopTitleBorder("Lorem Ipsum","Lorem Ipsum " +
                "is simply dummy text of the printing and Lorem Ipsum is simply dummy text of " +
                "the printing and Lorem Ipsum is simply dummy text of the printing and typesetting " +
                "industry.");
        StackPane pane4=getBottomLeftTitleBorder("Lorem Ipsum","Lorem Ipsum " +
                "is simply dummy text of the printing and typesetting industry " +
                "simply dummy text of the printing and typesetting industry.");
        vBox.getChildren().add(pane);
        vBox.getChildren().add(pane1);
        vBox.getChildren().add(pane2);
        vBox.getChildren().add(pane3);
        vBox.getChildren().add(pane4);
        return vBox;
    }

    /**
     * Энэ арга нь дээд төв хэсэгтэй гарчигтай хүрээ үүсгэнэ
     * @Param title - хүрээний гарчиг
     * @Param con - гарчигтай хүрээн доторх агуулгыг
     * */
    StackPane getTopCenterTitleBorder(String title, String con){
        StackPane pane=new StackPane();
        pane.setPrefWidth(400);
        Label header=new Label("~ "+title+" ~");
        Label content=new Label(con);
        header.setStyle("-fx-background-color: #fdcd3b;"+
                "-fx-translate-y: -15;"+
                "-fx-padding:2 10;");
        pane.setStyle("-fx-border-color: #cc6600;");
        content.setStyle(contentStyle);
        content.setWrapText(true);
        header.setWrapText(true);
        pane.getChildren().add(content);
        pane.setAlignment(content,Pos.CENTER_LEFT);
        pane.getChildren().add(header);
        pane.setAlignment(header,Pos.TOP_CENTER);
        return pane;
    }

    /**
     * Энэ арга нь зүүн дээд төв хэсэгт гарчигтай хүрээ үүсгэнэ
     * @Param title - хүрээний гарчиг
     * @Param con - гарчигтай хүрээн доторх агуулгыг
     * */
    StackPane getTopLeftTitleBorder(String title, String con){
        StackPane pane=new StackPane();
        pane.setPrefWidth(400);
        Label header=new Label("~ "+title+" ~");
        Label content=new Label(con);
        header.setStyle("-fx-background-color: #fdcd3b;"+
                "-fx-translate-y: -15;" +
                "    -fx-translate-x: 10;"+
                "-fx-padding:2 10;");
        pane.setStyle("-fx-border-color: black;");
        content.setStyle(contentStyle);
        content.setWrapText(true);
        pane.getChildren().add(content);
        pane.setAlignment(content,Pos.CENTER_LEFT);
        pane.getChildren().add(header);
        pane.setAlignment(header,Pos.TOP_LEFT);
        return pane;
    }

    /**
     * Энэ арга нь баруун дээд хэсэгт гарчигтай хүрээ үүсгэнэ
     * @Param title - хүрээний гарчиг
     * @Param con - гарчигтай хүрээн доторх агуулгыг
     * */
    StackPane getTopRightTitleBorder(String title, String con){
        StackPane pane=new StackPane();
        pane.setPrefWidth(400);
        Label header=new Label("~ "+title+" ~");
        Label content=new Label(con);
        header.setStyle("-fx-background-color: #ffed4b;"+
                "-fx-translate-y: -15;-fx-translate-x: -10;"+
                ";-fx-padding:2 10;");
        pane.setStyle("-fx-border-color: gray;");
        content.setStyle(contentStyle);
        content.setWrapText(true);
        pane.getChildren().add(content);
        pane.setAlignment(content,Pos.CENTER_LEFT);
        pane.getChildren().add(header);
        pane.setAlignment(header,Pos.TOP_RIGHT);
        return pane;
    }

    /**
     * Энэ арга нь хүрээний дээд зүүн хэсэгт гарчигтай хүрээ үүсгэнэ
     * @Param title - хүрээний гарчиг
     * @Param con - гарчигтай хүрээн доторх агуулгыг
     * */
    StackPane getTopTitleBorder(String title, String con){
        StackPane pane=new StackPane();
        pane.setPrefWidth(400);
        Label header=new Label("~ "+title+" ~");
        Label content=new Label(con);
        header.setStyle("-fx-translate-y: -20;-fx-padding:2 10;");
        pane.setStyle("-fx-border-color: gray;");
        content.setStyle(contentStyle);
        content.setWrapText(true);
        pane.getChildren().add(content);
        pane.setAlignment(content,Pos.CENTER_LEFT);
        pane.getChildren().add(header);
        pane.setAlignment(header,Pos.TOP_LEFT);
        return pane;
    }
    /**
     * Энэ арга нь зүүн доод хэсэгтэй гарчигтай хүрээгүй үүсгэнэ
     * @Param title - хүрээний гарчиг
     * @Param con - гарчигтай хүрээн доторх агуулгыг
     * */
    StackPane getBottomLeftTitleBorder(String title, String con){
        StackPane pane=new StackPane();
        pane.setPrefWidth(400);
        Label header=new Label("~ "+title+" ~");
        Label content=new Label(con);
        header.setStyle("-fx-translate-y: 15;"+
                "-fx-translate-x: 10;-fx-padding:2 10;");
        content.setStyle(contentStyle);
        content.setWrapText(true);
        pane.getChildren().add(content);
        pane.setAlignment(content,Pos.CENTER_LEFT);
        pane.getChildren().add(header);
        pane.setAlignment(header,Pos.BOTTOM_LEFT);
        return pane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
