/**
 * Created by Misha on 30.07.2018.
 */
public class TreeImpl implements Tree {

    private Node root;
    private int size;


    @Override
    public void insert(int id) {
        Node newNode = new Node(id);
        Node parrent = findParentForInsert(newNode);
        if(parrent == null){
            root = newNode;
        }
        if(newNode.getId() > parrent.getId()){
            parrent.setRightChild(newNode);
        }
        else{
            parrent.setLeftChild(newNode);
        }

        size++;
    }

    private Node findParentForInsert(Node newNode) {
        Node currentNode = root;
        Node parrent = null;
        while (currentNode != null) {
            parrent = currentNode;
            if (newNode.getId() > currentNode.getId()) {
                currentNode = currentNode.getRightChild();
            } else {
                currentNode = currentNode.getLeftChild();
            }
        }
        return parrent;
    }

    @Override
    public boolean remove(int id) {
        size--;
        return false;
    }

    @Override
    public boolean find(int id) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.getId() == id) {
                return true;
            }
            if (id < currentNode.getId()) {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
        }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int getRoot() {
        return root.getId();
    }
}
