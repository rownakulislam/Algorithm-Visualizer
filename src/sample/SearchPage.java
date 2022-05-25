package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class SearchPage {
    private ArrayList<SearchNode> searchNodeList;
    private Timeline visualizer;
    public static int arraySize=5;
    public int[] arr;
    public int searchElement;
    @FXML private Button clear;
    @FXML private Label msg;
    @FXML private Label msg1;
    @FXML private Button linearsearch;
    @FXML private Button binarysearch;
    @FXML private TextField noofelements;
    @FXML private TextField searchingelement;
    @FXML private Pane arrayholder;
    @FXML Button back;
    @FXML
    void backbuttonPressed(ActionEvent event) throws IOException {

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("MenuPage.fxml"));
        primaryStage.setTitle("Algorithm Visualization");
        primaryStage.setMaximized(true);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        back.getScene().getWindow().hide();
    }
    @FXML
    void InputButtonPressed(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SearchCustomInput.fxml"));
        primaryStage.setScene(new Scene(root,600,600));
        primaryStage.showAndWait();
        arr = new int[arraySize];
        arr = SearchCustomInputController.arr;

        searchNodeList = new ArrayList<>();

        for(int i=0;i<arraySize;i++){
            searchNodeList.add(new SearchNode(arrayholder,arr[i],i));
        }
    }
    @FXML
    void SizePressed(ActionEvent event) {
        String s = noofelements.getText();
        arraySize = Integer.parseInt(s);
    }
    @FXML
    void ClearButtonPressed(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SearchPage.fxml"));
        primaryStage.setTitle("AlgoVisualizer");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setMaximized(true);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        clear.getScene().getWindow().hide();
    }
    @FXML
    void randomPressed(ActionEvent event) {
        msg.setText("");
        arr = new int[arraySize];
        Random rand = new Random();
        for(int i=0; i<arraySize; i++){
            arr[i] = rand.nextInt(100);
        }
        searchNodeList = new ArrayList<>();
       for(int i=0;i<arraySize;i++){
            searchNodeList.add(new SearchNode(arrayholder,arr[i],i));
        }
    }
    @FXML
    void SearchElementPressed(ActionEvent event){
        String s=searchingelement.getText();
        searchElement=Integer.parseInt(s);
    }
    @FXML
    void BinarySearchButtonPressed(ActionEvent event) {
        for(int i=1; i<arraySize; i++){
            if(arr[i]<arr[i-1]){
                msg.setText("Array is not Sorted");
                return;
            }
        }
        arraySize--;
        msg1.setText("Searching Element in the range between "+0+" "+arraySize);
        binaryRecursion(0,arraySize);
    }
    void binaryRecursion(int l, int r){
        KeyFrame bfsKeyFrame = new KeyFrame(Duration.seconds(5), e->{
            int m=(l+r)/2;
            msg.setText("Middle index is "+m+"\nMiddle Element Value is "+ arr[m]);
            if(r>=l && arr[m]==searchElement){
                searchNodeList.get(m).getNode().setFill(Color.GREENYELLOW);
                visualizer.stop();
                msg.setText("Element Found");
                msg1.setText(" ");
                return;
            }
            else if(r>=l && arr[m]>searchElement){
                searchNodeList.get(m).getNode().setFill(Color.DARKRED);
                m--;
                if(m<l){
                    visualizer.stop();
                    msg1.setText(" ");
                    msg.setText("Element Not Found");
                    return;
                }
                msg1.setText("NEXT: Searching Element in the range between "+l+" "+m);
                binaryRecursion(l,m);
            }
            else if(r>=l && arr[m]<searchElement){
                searchNodeList.get(m).getNode().setFill(Color.DARKRED);
                m++;
                if(m>r){
                    visualizer.stop();
                    msg1.setText(" ");
                    msg.setText("Element Not Found");
                    return;
                }
                msg1.setText("NEXT: Searching Element in the range between "+m+" "+r);
                binaryRecursion(m,r);
            }
            else{
                visualizer.stop();
                msg1.setText(" ");
                msg.setText("Element Not Found");
                return;
            }
        });
        visualizer = new Timeline(bfsKeyFrame);
        visualizer.setCycleCount(Animation.INDEFINITE);
        visualizer.play();
    }

    @FXML
    void LinearSearchButton(ActionEvent event) throws InterruptedException {


        linearRecursion(0, arraySize);

    }
    void linearRecursion(int i, int n){
        KeyFrame bfsKeyFrame = new KeyFrame(Duration.seconds(3), e->{
            if(i<arraySize && arr[i]!=searchElement){
                msg.setText("Current Index "+i);
                msg1.setText("Current element value: "+arr[i]);
                searchNodeList.get(i).getNode().setFill(Color.DARKRED);
                linearRecursion(i+1,n);
            }
            else if(i<arraySize && arr[i]==searchElement){
                searchNodeList.get(i).getNode().setFill(Color.GREENYELLOW);
                msg.setText("Element Found");
                msg1.setText("Current element value: "+arr[i]);
                visualizer.stop();
            }
            else{
                msg.setText("Element Not Found");
                msg.setText(" ");
                visualizer.stop();
            }
        });
        visualizer = new Timeline(bfsKeyFrame);
        visualizer.setCycleCount(Animation.INDEFINITE);
        visualizer.play();
    }
}
