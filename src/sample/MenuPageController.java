package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;

public class MenuPageController {
       @FXML private Button search;
       @FXML private Button sort;
       @FXML private Button tutorials;
    @FXML
    void SearchButtonPressed(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SearchPage.fxml"));
        primaryStage.setTitle("Algorithm Visualization");
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setMaximized(true);
        primaryStage.setResizable(false);
        primaryStage.show();

        search.getScene().getWindow().hide();
    }
    @FXML
    void SortButtonPressed(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SortingPage2.fxml"));
        primaryStage.setTitle("Algorithm Visualization");
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setMaximized(true);
        primaryStage.setResizable(false);
        primaryStage.show();

        sort.getScene().getWindow().hide();
    }
    @FXML
    void TutorialsButtonPressed(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Tutorial.fxml"));
        primaryStage.setTitle("Algorithm Visualization");
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setMaximized(true);
        primaryStage.setResizable(false);
        primaryStage.show();
        tutorials.getScene().getWindow().hide();
    }
}
