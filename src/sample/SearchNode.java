package sample;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SearchNode {
    private int id;
    private int value;
    private Circle node;
    public SearchNode(Pane displayNode, int n, int i){
        this(createnode(i*50+i*15, 25, 25), i, n);
        drawNode(displayNode, n);
    }
    public SearchNode(Circle node,int nodeid,int nodeval){
        id=nodeid;
        value=nodeval;
        this.node=node;
    }
    public static Circle createnode(double x,double y,double r){
        Circle gnode =new Circle(x,y,r);
        gnode.setFill(Color.BEIGE);
        return gnode;
    }
    public void drawNode(Pane displayPane,int n){
        Text textNodeId=new Text(String.valueOf(n));
        textNodeId.setFill(Color.BLACK);
        textNodeId.setFont(Font.font(node.getRadius()));
        StackPane nodePane=new StackPane(node,textNodeId);
        nodePane.setLayoutX(node.getCenterX() - node.getRadius());
        nodePane.setLayoutY(node.getCenterY() - node.getRadius());
        displayPane.getChildren().add(nodePane);
    }
    public Circle getNode(){
        return node;
    }
    public void setNode(Circle node){
        this.node=node;
    }
    int getNodeId(){
        return id;
    }
    void setNodeId(int n){
        id=n;
    }
    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
