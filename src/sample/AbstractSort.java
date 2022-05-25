package sample;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSort {
    public final Color start=Color.BEIGE;
    public final Color select=Color.DARKBLUE;
    public final Color fina=Color.LIGHTGREEN;
    public final Color sorted=Color.DARKRED;
    static public int X;
    ParallelTransition p;
    FillTransition f;
    static {
        X = SortingPage.WINDOW_WIDTH / SortingPage.NO_OF_NODES;
    }
    void fillTransion(Node c, Color color) {
        f = new FillTransition();
        f.setShape((Shape) c.rectangle);
        f.setToValue(color);
        f.setDuration(Duration.millis(SortingPage.SPEED));
        p.getChildren().add(f);
    }
    ParallelTransition colorNode(Node[] arr, Color color, int...a) {
        p = new ParallelTransition();
        for (int i = 0; i < a.length; i++) {
            fillTransion(arr[a[i]], color);
        }
        return p;
    }
    ParallelTransition colorNode(List<Node> list, Color color) {
        p = new ParallelTransition();
        for (Node c : list) {
            fillTransion(c, color);
        }
        return p;
    }
    ParallelTransition swap(Node a[], int i, int j) {
        X = SortingPage.WINDOW_WIDTH / SortingPage.NO_OF_NODES;
        p = new ParallelTransition();
        int dx = j-i;
        p.getChildren().addAll(a[i].moveX(X * dx), a[j].moveX(-X * dx));
        Node tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        return p;
    }
    public abstract ArrayList<Transition> startSort(Node[] a);
    public abstract void setX();
}
