package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    VBox leftBox,rightBox;
    Label lblFind, lblReplace;
    GridPane centerBox;
    Button btnFind, btnReplace, btnReplaceAll,btnClose,btnHelp;
    String btnStyle= "  -fx-background-color: \n" +
            "        rgba(0,0,0,0.08),\n" +
            "        linear-gradient(#9a9a9a, #909090),\n" +
            "        linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%);\n" +
            "    -fx-background-insets: 0 0 -1 0,0,1;\n" +
            "   -fx-font-family: Arial;\n" +
            "    -fx-background-radius: 4,4,3;\n" +
            "    -fx-padding: 5 10 5 10;\n" +
            "    -fx-text-fill: #242d35;\n" +
            "    -fx-font-size: 12px;" ;
    String lblStyle="   -fx-font-family: Arial;\n" +
            "    -fx-font-size: 12px;\n" +
            "    -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );";


    @Override
    public void start(Stage primaryStage) throws Exception{
        FlowPane root =new FlowPane();
        root.setPadding(new Insets(5));
        root.setHgap(5);
        leftBox=getLeftBox();
        leftBox.setStyle("-fx-padding: 25 10 10 10;");
        rightBox=getRightBox();
        rightBox.setStyle("-fx-padding: 15 10 10 10;");
        centerBox=getCenterBox();
        root.getChildren().addAll(leftBox,centerBox,rightBox);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Find and Replace");
        Scene scene = new Scene(root, 510, 220);
        scene.getStylesheets().add
                (Main.class.getResource("app.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    VBox getLeftBox(){
        VBox vBox=new VBox();
        vBox.setAlignment(Pos.TOP_LEFT);
        vBox.setSpacing(15);
        vBox.setPadding(new Insets(10));
        lblFind=new Label("Find what:");
        lblReplace=new Label("Replace with:");
        lblFind.setStyle("-fx-padding: 10 0 0 0;");
        lblFind.setStyle(lblStyle);
        lblReplace.setStyle(lblStyle);
        vBox.getChildren().addAll(lblFind,lblReplace);
        return vBox;
    }
    VBox getRightBox(){
        VBox vbox=new VBox();
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));
        btnFind=new Button("Find");
        btnFind.setMaxSize(100, 100);
        btnReplace=new Button("Replace");
        btnReplace.setMaxSize(100, 100);
        btnReplaceAll=new Button("Replace All");
        btnReplaceAll.setMaxSize(100, 100);
        btnClose=new Button("Close");
        btnClose.setMaxSize(100, 100);
        btnHelp=new Button("Help"); btnHelp.setMaxSize(100, 100);
        vbox.getChildren().addAll(btnFind, btnReplace, btnReplaceAll, btnClose, btnHelp);
        return vbox;
    }

    GridPane getCenterBox(){
        GridPane gridpane=new GridPane();
        gridpane.setPrefSize(290, 200);
        gridpane.setVgap(5);
        gridpane.setHgap(10);
        VBox textFieldVBox=getTextFieldVBox();
        gridpane.setAlignment(Pos.CENTER);
        VBox checkBoxLeftVBox=getCheckBoxLeftVBox();
        VBox checkBoxRightVBox=getCheckBoxRightVBox();
        gridpane.add(textFieldVBox,0,0,2,1);
        gridpane.add(checkBoxLeftVBox,0,1);
        gridpane.add(checkBoxRightVBox,1,1);
        return gridpane;
    }
    VBox getTextFieldVBox(){
        VBox vBox=new VBox();
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(5,0,5,0));
        vBox.getChildren().addAll(textField1,textField2);
        vBox.setPrefWidth(280);
        return  vBox;
    }
    VBox getCheckBoxLeftVBox(){
        VBox vBox=new VBox();
        CheckBox checkBox1 = new CheckBox("Match Case");
        CheckBox checkBox2 = new CheckBox("Whole Words");
        CheckBox checkBox3 = new CheckBox("Regular Expressions");
        CheckBox checkBox4 = new CheckBox("Highlight Result");
        checkBox1.setStyle(lblStyle);
        checkBox2.setStyle(lblStyle);
        checkBox3.setStyle(lblStyle);
        checkBox4.setStyle(lblStyle);
        vBox.setAlignment(Pos.TOP_LEFT);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(2,0,2,0));
        vBox.getChildren().addAll(checkBox1,checkBox2,checkBox3,checkBox4);
        return  vBox;
    }
    VBox getCheckBoxRightVBox(){
        VBox vBox=new VBox();
        CheckBox checkBox1 = new CheckBox("Wrap Around");
        CheckBox checkBox2 = new CheckBox("Search Selection");
        CheckBox checkBox3 = new CheckBox("Search Backwards");
        CheckBox checkBox4 = new CheckBox("Incremental Search");
        checkBox1.setStyle(lblStyle);
        checkBox2.setStyle(lblStyle);
        checkBox3.setStyle(lblStyle);
        checkBox4.setStyle(lblStyle);
        checkBox2.setDisable(true);
        vBox.setAlignment(Pos.TOP_LEFT);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(2,0,2,0));;
        vBox.getChildren().addAll(checkBox1,checkBox2,checkBox3,checkBox4);
        return  vBox;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
