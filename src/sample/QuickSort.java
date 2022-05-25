package sample;

import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;
public class QuickSort extends AbstractSort {
    @FXML Label lable;
    private static final Color PIVOT_COLOR = Color.DARKCYAN;
    private ArrayList<Transition> transitions;
    public QuickSort() {
        this.transitions = new ArrayList<>();
    }
    public void setX() {
        X = SortingPage.WINDOW_WIDTH / SortingPage.num_nodes;
    }


    private int partition(Node[] nodes, int low, int high) {
        int i = low;
        transitions.add(colorNode(nodes, PIVOT_COLOR, high));
        for (int j = low; j < high; j++) {
            transitions.add(colorNode(nodes, Color.TAN, j));
            transitions.add(colorNode(nodes, Color.DARKBLUE, i));
            if (nodes[j].getValue() < nodes[high].getValue()) {
                transitions.add(swap(nodes, i, j));
                transitions.add(colorNode(nodes,Color.BEIGE,j));
                transitions.add(colorNode(nodes, Color.BEIGE, i));
                i++;
                transitions.add(colorNode(nodes, Color.DARKBLUE, i));
            }
            else transitions.add(colorNode(nodes, Color.BEIGE, j));
        }
        transitions.add(swap(nodes, i, high));
        transitions.add(colorNode(nodes, sorted, i));
        transitions.add(colorNode(nodes,Color.BEIGE,high));
        return i;
    }

    private void quickSort(Node[] nodes, int low, int high) {
        if (low < high) {
            //SortingPage.lable.setText("Range: "+low+" to "+high);
            int pivot = partition(nodes, low, high);
            quickSort(nodes, low, pivot-1);
            quickSort(nodes, pivot+1, high);
        }
        else{
            transitions.add(colorNode(nodes,Color.DARKRED,low));
        }
    }
    @Override
    public ArrayList<Transition> startSort(Node[] nodes) {
        System.out.println("quick"+SortingPage.NO_OF_NODES);
        quickSort(nodes, 0, nodes.length-1);
        transitions.add(colorNode(Arrays.asList(nodes), fina));
        return transitions;
    }
}