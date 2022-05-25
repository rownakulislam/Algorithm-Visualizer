package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class SortCustomInputController implements Initializable {
    @FXML private Button OkButton;
    @FXML private TextArea TextInput;
    public static int[] arr;
    @FXML
    void OkButtonPressed(ActionEvent event) {
        arr = new int[SortingPage.NO_OF_NODES];
        String numbers = TextInput.getText();
        String temp = new String();
        int j=0;
        for (int i=0;i<numbers.length();i++)
        {
            if (numbers.charAt(i)!=' ')
                temp+=numbers.charAt(i);
            if (numbers.charAt(i)==' '){
                arr[j]=Integer.parseInt(temp);
                j++;
                temp="";
            }
        }
        arr[j]=Integer.parseInt(temp);

        OkButton.getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
