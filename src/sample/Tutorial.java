package sample;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Tutorial implements Initializable {
    @FXML
    private Button back;
    @FXML
    private HBox hbox;
    @FXML
    private Button ib;
    @FXML
    private Button sb;
    @FXML
    private Button qb;
    @FXML
    private Button mb;
    @FXML
    private Button bb;
    @FXML
    private Button bsb;
    @FXML
    private Button lsb;
    @FXML
    private WebView webview ;
    private WebEngine engine;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        engine=webview.getEngine();
        engine.load("https://www.geeksforgeeks.org/fundamentals-of-algorithms/");
    }

    public void insertionsort(javafx.event.ActionEvent event) {
        engine.load("https://www.geeksforgeeks.org/insertion-sort/");
    }

    public void selectionsort(ActionEvent event) {
        engine.load("https://www.geeksforgeeks.org/selection-sort/");
    }

    public void quicksort(ActionEvent event) {
        engine.load("https://www.geeksforgeeks.org/quick-sort/");
    }

    public void mergesort(ActionEvent event) {
        engine.load("https://www.geeksforgeeks.org/merge-sort/");
    }

    public void bubblesort(ActionEvent event) {
        engine.load("https://www.geeksforgeeks.org/bubble-sort/");
    }

    public void binarysearch(ActionEvent event) {
        engine.load("https://www.geeksforgeeks.org/binary-search/");
    }

    public void linearsearch(ActionEvent event) {
        engine.load("https://www.geeksforgeeks.org/linear-search/");
    }

    public void backbuttonpressed(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("MenuPage.fxml"));
        primaryStage.setTitle("Algorithm Visualization");
        primaryStage.setMaximized(true);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        back.getScene().getWindow().hide();
    }
}
