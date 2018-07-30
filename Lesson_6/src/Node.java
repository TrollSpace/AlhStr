/**
 * Created by Misha on 30.07.2018.
 */
public class Node {

    private int id;
    private Node leftChild;
    private Node rightChild;

    public Node(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}
