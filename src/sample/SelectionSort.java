package sample;

import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSort extends AbstractSort {
    private ArrayList<Transition> transitions;
    private ParallelTransition ColorNode(Node nodes[], int x, int y, Color A, Color B) {
        ParallelTransition p = new ParallelTransition();
        p.getChildren().addAll(colorNode(nodes, A, x), colorNode(nodes, B, y));
        return p;
    }
    public void setX(){
        X = SortingPage.WINDOW_WIDTH / SortingPage.NO_OF_NODES;
    }
    public ArrayList <Transition> startSort(Node[] nodes) {
        System.out.println(SortingPage.NO_OF_NODES);
        transitions = new ArrayList<>();
        int minIdx;
        for (int i = 0; i < nodes.length - 1; i++) {
            minIdx = i;
            transitions.add(colorNode(nodes, select, minIdx));
            for (int j = i+1; j < nodes.length; j++) {
                transitions.add(colorNode(nodes, Color.DARKCYAN, j));
                if (nodes[j].getValue() < nodes[minIdx].getValue()) {
                    if (minIdx == i) transitions.add(ColorNode(nodes,minIdx,j,Color.DARKBLUE,Color.DARKBLUE));
                    else transitions.add(ColorNode(nodes, minIdx, j, Color.BEIGE, Color.DARKBLUE));
                    minIdx = j;
                }
                else transitions.add(colorNode(nodes, Color.BEIGE, j));
            }
            if (minIdx != i) transitions.add(swap(nodes, i, minIdx));
            transitions.add(colorNode(nodes, sorted,i));
            transitions.add(colorNode(nodes,start,minIdx));
        }
        transitions.add(colorNode(Arrays.asList(nodes), fina));
        return transitions;
    }
}