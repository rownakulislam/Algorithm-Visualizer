package sample;

import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSort extends AbstractSort {
    private ArrayList<Transition> transitions;
    public InsertionSort() {
        this.transitions = new ArrayList<>();
        System.out.println(SortingPage.NO_OF_NODES);
    }
    public void setX(){
        X = SortingPage.WINDOW_WIDTH / SortingPage.NO_OF_NODES;
    }
    @Override
    public ArrayList <Transition> startSort(Node[] nodes) {
        for (int i = 1; i < nodes.length; i++) {
            int j = i - 1;
            Node number = nodes[i];

            ParallelTransition p = new ParallelTransition();
            transitions.add(colorNode(nodes, select, i));
            while (j >= 0 && nodes[j].getValue() > number.getValue()) {
                transitions.add(colorNode(nodes, Color.DARKCYAN, j));
                p.getChildren().add(nodes[j].moveX(X));
                nodes[j+1] = nodes[j];
                transitions.add(colorNode(nodes, sorted, j));
                j--;
            }
            nodes[j+1] = number;
            p.getChildren().add(number.moveX(X * (j+1-i)));
            transitions.add(colorNode(nodes,Color.DARKRED,j+1));
            transitions.add(p);
        }
        transitions.add(colorNode(Arrays.asList(nodes), fina));
        return transitions;
    }
}