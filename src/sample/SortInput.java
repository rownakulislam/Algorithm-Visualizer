package sample;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Random;

public class SortInput {
    public SortInput(){}
    public static Node[] SortRandomInput(int len){
        Node nodes[]=new Node[len];
        Random r=new Random();
        for(int i=0;i<len;i++){
            nodes[i]=new Node(1+r.nextInt(nodes.length));
            nodes[i].setLayoutX(i*(double)(SortingPage.WINDOW_WIDTH/ nodes.length));
            nodes[i].rectangle.setFill(Color.BEIGE);
            setNodeDimension(nodes[i],nodes.length);
        }
        return nodes;
    }
    public static Node[] SortCustomInput(int len,int[] arr){
        int m = 0;
        for(int i = 0; i < len; i++){
            m = Math.max(m,arr[i]);
        }
        Node nodes[]=new Node[len];
        for(int i=0;i<len;i++){
            nodes[i]=new Node(arr[i]);
            nodes[i].setLayoutX(i*(double)(SortingPage.WINDOW_WIDTH/ nodes.length));
            nodes[i].rectangle.setFill(Color.BEIGE);
            nodes[i].rectangle.setWidth((double)SortingPage.WINDOW_WIDTH / len - SortingPage.X_GAP);
            nodes[i].rectangle.setHeight(((double)(SortingPage.WINDOW_HEIGHT) /m) * nodes[i].getValue());
            nodes[i].text.setFont(Font.font("Lucida Console",nodes[i].rectangle.getWidth()*.75));
        }
        return nodes;
    }
    public static void setNodeDimension(Node nodes, int len) {
        nodes.rectangle.setWidth((double)SortingPage.WINDOW_WIDTH / len - SortingPage.X_GAP);
        nodes.rectangle.setHeight(((double)(SortingPage.WINDOW_HEIGHT) / len) * nodes.getValue());
        nodes.text.setFont(Font.font("Lucida Console",nodes.rectangle.getWidth()*.75));
    }
}
