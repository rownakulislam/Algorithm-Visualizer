package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Node extends StackPane {
    private int val;
    Rectangle rectangle=new Rectangle();
    Text text;
    public Node(int n){
        val=n;
        text =new Text(String.valueOf(val));
        this.getChildren().addAll(rectangle,text);
    }
    public int getValue(){
        return val;
    }
    public TranslateTransition moveX(int x){
        TranslateTransition t=new TranslateTransition();
        t.setNode(this);
        t.setDuration(Duration.millis(SortingPage.SPEED));
        t.setByX(x);
        return t;
    }
}
