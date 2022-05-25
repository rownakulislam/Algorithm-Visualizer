package sample;
import javafx.animation.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class SortingPage implements Initializable {
    public static final int WINDOW_WIDTH =1242;
    public static final int WINDOW_HEIGHT = 578;
    @FXML Button back;
    @FXML TextField noofelements;
    @FXML Pane sortingpane;
    @FXML Button pause;
    @FXML Button sort;
    @FXML ChoiceBox<Integer> Speed;
    @FXML Button randominput;
    @FXML Button custominput;
    @FXML ChoiceBox<AbstractSort> sortingmethods;
    @FXML Label lable;
    public static int SPEED=100;
    private Node[] nodes;
    public static AbstractSort abstractSort;
    public static final int X_GAP = 10;
    public static int NO_OF_NODES = 30;
    public static int num_nodes;
    SequentialTransition st;
    boolean running = false;
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
    void setNoofelements(ActionEvent event){
        String s=noofelements.getText();
        NO_OF_NODES=Integer.parseInt(s);
        randomGenerator(NO_OF_NODES);
        System.out.println("func"+NO_OF_NODES);
    }
    @FXML
    void randominputpressed(ActionEvent event){
        randomGenerator(NO_OF_NODES);
    }
    public void randomGenerator(int v){
        sort.setDisable(false);
        sortingpane.getChildren().clear();
        this.nodes=SortInput.SortRandomInput(v);
        sortingpane.getChildren().addAll(Arrays.asList(nodes));
    }
    @FXML
    void CustomButtonAction(ActionEvent event) throws IOException {

        int[] arr = new int[NO_OF_NODES];
        Parent root = FXMLLoader.load(getClass().getResource("SortCustomInput.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root,600,550));
        primaryStage.showAndWait();
        arr = SortCustomInputController.arr;
        customGenerator(NO_OF_NODES,arr);
    }
    public void customGenerator(int v,int[] arr){

        sort.setDisable(false);
        sortingpane.getChildren().clear();
        this.nodes=SortInput.SortCustomInput(v,arr);
        sortingpane.getChildren().addAll(Arrays.asList(nodes));
    }
    @FXML
    void pauseButtonAction(ActionEvent event) {
        if (running) {
            st.pause();
            pause.setText("Continue");
            running = false;
        }
        else {
            st.play();
            pause.setText("Pause");
            running = true;
        }
    }
    @FXML
    void sortButtonAction(ActionEvent event) {
        running = true;
        sort.setDisable(true);
        randominput.setDisable(true);
        pause.setDisable(false);

        abstractSort = sortingmethods.getSelectionModel().getSelectedItem();
        st = new SequentialTransition();
        st.getChildren().addAll(abstractSort.startSort(nodes));
        st.setOnFinished(e -> {
            randominput.setDisable(false);
            pause.setDisable(true);
            running = false;
        });
        st.play();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pause.setDisable(true);
        this.nodes = SortInput.SortRandomInput(NO_OF_NODES);
        sortingpane.getChildren().addAll(Arrays.asList(nodes));
        Integer[] speed = {1, 5, 10, 20, 50, 100, 250, 500};
        Tooltip tt1 = new Tooltip();
        tt1.setStyle("-fx-base: #AE3522; " + "-fx-text-fill: BLACK;" + "-fx-background-color : WHITE;");
        tt1.setText("Choose Speed");
        Speed.setTooltip(tt1);
        Speed.setValue(100);
        Speed.setItems(FXCollections.observableArrayList(speed));

        Speed.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                Integer n = newValue;
                SPEED = n.intValue();
            }
        });
        List<AbstractSort> sortList = new ArrayList<>();
        sortList.add(new MergeSort());
        sortList.add(new InsertionSort());
        sortList.add(new SelectionSort());
        sortList.add(new QuickSort());
        sortList.add(new BubbleSort());
        //sortingmethods.setValue(new BubbleSort());
        Tooltip tt2 = new Tooltip();
        tt2.setStyle("-fx-base: #AE3522; " + "-fx-text-fill: BLACK;" + "-fx-background-color : WHITE;");
        tt2.setText("Choose Sorting Algorithm");
        sortingmethods.setTooltip(tt2);
        sortingmethods.setItems(FXCollections.observableArrayList(sortList));
        sortingmethods.getSelectionModel().select(4);

        sortingmethods.setConverter(new StringConverter<AbstractSort>() {
            @Override
            public String toString(AbstractSort absSort) {
                if (absSort == null) return "";
                else return absSort.getClass().getSimpleName();
            }
            @Override
            public AbstractSort fromString(String s) {
                return null;
            }
        });
    }
}
