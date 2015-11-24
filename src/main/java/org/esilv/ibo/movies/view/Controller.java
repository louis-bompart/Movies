package org.esilv.ibo.movies.view;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;


public class Controller {
    @FXML
    private Label labelone;
    @FXML
    private PieChart pieChartOne;
    @FXML
    private TableView tableOne;
    @FXML
    private Button buttonPlus;
    @FXML
    private  Button buttonMinus;

    private int i=0;



    // Reference to the main application.
    private Main mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public Controller() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        labelone.setText("capacity:"+i+"");

    }



    /**
     * Called when the user clicks on the delete button.
     */

    @FXML
    private void handlePlus() {
        //change code here to make sure that i is set by M
        i++;
        labelone.setText("capacity:"+i+"");
    }
    @FXML
    private void handleMinus() {
        //change code here to make sure that i is set by M
        i--;
        labelone.setText("capacity:"+i+"");
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;


    }

}