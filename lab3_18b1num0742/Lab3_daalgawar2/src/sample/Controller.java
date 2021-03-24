package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Controller class
 *@ersin 1.0
 * @author enkh-erdene
 * */
public class Controller {

    /**    graphic's max height is 215 */
    private final double MAX_HEIGHT_GRAPH=215;
    /**    graphic's max width is 45 */
    private final double MAX_WIDTH_GRAPH=45;
    /** max product sales is 20000*/
    private final double MAX_PRODUCT_SALES=20000;
    /**distance between graphic and the top of the container is 130*/
    private final double DISTANCE_BETWEEN_GRAPH_AND_TOP=130;

    /**
     * represent graphics
     * */
    Rectangle graph1,graph2,graph3,graph4,graph5;

    /**
     * create Rectangle shape
     * @return rectangle shape
     * @param x- shape's x position
     * @param y- shape's y position
     * @param w-shape's width
     * @param h-shape's height
     * @param color-shape's color
     * */
    public Rectangle getRectangle(double x, double y,double w,double h, Color color){
        Rectangle rectangle = new Rectangle();
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setWidth(w);
        rectangle.setHeight(h);
        rectangle.setFill(color);
        return rectangle;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private AnchorPane pane;

    @FXML
    private URL location;

    @FXML
    private TextField txtMonday;

    @FXML
    private TextField txtTuesday;

    @FXML
    private TextField txtWednesday;

    @FXML
    private Button Generate;

    @FXML
    private TextField txtThursday;

    @FXML
    private TextField txtFriday;

    /**
     * generate graph using product sales
     * @param event button click
     * */
    @FXML
    void generateGraph(ActionEvent event) {
        if(txtWednesday.getText()!=null&&!txtWednesday.getText().trim().isEmpty()){
            double t3 = Integer.parseInt(txtWednesday.getText()) * MAX_HEIGHT_GRAPH / MAX_PRODUCT_SALES; //calculate graphic's heigth
            graph3.setHeight(t3);
            graph3.setY(DISTANCE_BETWEEN_GRAPH_AND_TOP + (MAX_HEIGHT_GRAPH - t3));//calculate graphic's y position
        }
        else {
            graph3.setHeight(0);
        }
        if(txtMonday.getText()!=null&&!txtMonday.getText().trim().isEmpty()){
            double t1 = Integer.parseInt(txtMonday.getText()) * MAX_HEIGHT_GRAPH / MAX_PRODUCT_SALES; //calculate graphic's heigth
            graph1.setHeight(t1);
            graph1.setY(DISTANCE_BETWEEN_GRAPH_AND_TOP + (MAX_HEIGHT_GRAPH - t1));//calculate graphic's y position
        }
        else {
            graph1.setHeight(0);
        }
        if(txtTuesday.getText()!=null&&!txtTuesday.getText().trim().isEmpty()){
            double t2 = Integer.parseInt(txtTuesday.getText()) * MAX_HEIGHT_GRAPH / MAX_PRODUCT_SALES; //calculate graphic's  heigth
            graph2.setHeight(t2);
            graph2.setY(DISTANCE_BETWEEN_GRAPH_AND_TOP + (MAX_HEIGHT_GRAPH - t2));//calculate graphic's y position
        }
        else {
            graph2.setHeight(0);
        }
        if(txtThursday.getText()!=null&&!txtThursday.getText().trim().isEmpty()){
            double t4 = Integer.parseInt(txtThursday.getText()) * MAX_HEIGHT_GRAPH / MAX_PRODUCT_SALES;//calculate graphic's heigth
            graph4.setHeight(t4);
            graph4.setY(DISTANCE_BETWEEN_GRAPH_AND_TOP + (MAX_HEIGHT_GRAPH - t4));//calculate graphic's y position
        }
        else {
            graph4.setHeight(0);
        }
        if(txtFriday.getText()!=null && !txtFriday.getText().trim().isEmpty()){
            double t5 = Integer.parseInt(txtFriday.getText()) * MAX_HEIGHT_GRAPH / MAX_PRODUCT_SALES;//calculate graphic's heigth
            graph5.setHeight(t5);
            graph5.setY(DISTANCE_BETWEEN_GRAPH_AND_TOP + (MAX_HEIGHT_GRAPH - t5));//calculate graphic's y position
        }
        else {
            graph5.setHeight(0);
        }
    }

    /**
     * create initial graph using default product sales
     * */
    public void InitialGraph() {
        double t1 = Integer.parseInt(txtMonday.getText()) * MAX_HEIGHT_GRAPH / MAX_PRODUCT_SALES;
        double t2 = Integer.parseInt(txtTuesday.getText()) * MAX_HEIGHT_GRAPH / MAX_PRODUCT_SALES;
        double t3 = Integer.parseInt(txtWednesday.getText()) * MAX_HEIGHT_GRAPH / MAX_PRODUCT_SALES;
        double t4 = Integer.parseInt(txtThursday.getText()) * MAX_HEIGHT_GRAPH / MAX_PRODUCT_SALES;
        double t5 = Integer.parseInt(txtFriday.getText()) * MAX_HEIGHT_GRAPH / MAX_PRODUCT_SALES;
        graph1 = getRectangle(35, DISTANCE_BETWEEN_GRAPH_AND_TOP + (MAX_HEIGHT_GRAPH - t1), MAX_WIDTH_GRAPH, t1, Color.RED);
        graph2 = getRectangle(105, DISTANCE_BETWEEN_GRAPH_AND_TOP + (MAX_HEIGHT_GRAPH - t2), MAX_WIDTH_GRAPH, t2, Color.BLUE);
        graph3 = getRectangle(178, DISTANCE_BETWEEN_GRAPH_AND_TOP + (MAX_HEIGHT_GRAPH - t3), MAX_WIDTH_GRAPH, t3, Color.PINK);
        graph4 = getRectangle(245, DISTANCE_BETWEEN_GRAPH_AND_TOP + (MAX_HEIGHT_GRAPH - t4), MAX_WIDTH_GRAPH, t4, Color.YELLOW);
        graph5 = getRectangle(320, DISTANCE_BETWEEN_GRAPH_AND_TOP + (MAX_HEIGHT_GRAPH - t5), MAX_WIDTH_GRAPH, t5, Color.GREEN);
        pane.getChildren().addAll(graph1,graph2,graph3,graph4,graph5);
    }
    @FXML
    void initialize() {
        InitialGraph();
    }
}