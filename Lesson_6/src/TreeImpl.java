/**
 * Created by Misha on 30.07.2018.
 */
public class TreeImpl implements Tree {

    private Node root;
    private int size;
    private int level;


    @Override
    public void insert(int id) {
        Node newNode = new Node(id);
        Node parent = findParentForInsert(newNode);
        if (parent == null) {
            root = newNode;
        } else if (newNode.getId() > parent.getId()) {
            parent.setRightChild(newNode);
        } else {
            parent.setLeftChild(newNode);
        }

        size++;
    }

    private Node findParentForInsert(Node newNode) {
        Node currentNode = root;
        Node parent = null;
        level = 0;
        while (currentNode != null) {
            parent = currentNode;
            if (newNode.getId() > currentNode.getId()) {
                currentNode = currentNode.getRightChild();
            } else {
                currentNode = currentNode.getLeftChild();
            }
            level++;
        }
        return parent;
    }

    @Override
    public boolean remove(int id) {
        Node currentNode = root;
        Node parent = null;
        while (currentNode != null) {
            parent = currentNode;
            if (id == currentNode.getId()) {
                break;
            } else if (id < currentNode.getId()) {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
        }
        if (currentNode == null) {
            return false;
        }
        if (currentNode.isLeaf()) {
            if (currentNode == root) {
                root = null;
            }
            if (parent.getRightChild() == currentNode) {
                parent.setRightChild(null);
            } else {
                parent.setLeftChild(null);
            }
        } else if (currentNode.hasOneChild()) {
            Node removeChild = currentNode.getLeftChild() != null ? currentNode.getLeftChild() : currentNode.getRightChild();
            if (currentNode == root) {
                root = removeChild;
            } else if (parent.getRightChild() == currentNode) {
                parent.setRightChild(removeChild);
            } else {
                parent.setLeftChild(removeChild);
            }
        } else {
            Node successor = getSuccessor(currentNode);
            if (currentNode == root) {
                root = successor;
            } else if (parent.getLeftChild() == currentNode) {
                parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }
            successor.setLeftChild(currentNode.getLeftChild());
            successor.setRightChild(currentNode.getRightChild());
        }

        size--;
        return true;
    }

    private Node getSuccessor(Node node) {
        Node successorParent = null;
        Node successor = node;
        Node current = node.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if (successor != node.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
        }
        return successor;
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
    public int getLevel() {
        return level;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int getRoot() {
        return root.getId();
    }

    @Override
    public void traverse(TraverseMode traverseMode) {
        switch (traverseMode) {
            case PRE_ORDER:
                prePrder(root);
                break;
            case POST_ORDER:
                postPrder(root);
                break;
            case IN_ORDER:
                inOrder(root);
                break;
        }
    }

    private void prePrder(Node node) {
        if (node != null) {
            System.out.println(node.getId());
            prePrder(node.getLeftChild());
            prePrder(node.getRightChild());
        }
    }

    private void postPrder(Node node) {
        if (node != null) {
            prePrder(node.getLeftChild());
            prePrder(node.getRightChild());
            System.out.println(node.getId());
        }
    }

    private void inOrder(Node node) {
        if (node != null) {
            prePrder(node.getLeftChild());
            System.out.println(node.getId());
            prePrder(node.getRightChild());
        }
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
        }
    }

    @Override
    public boolean checkBalance() {
        Node node = root;
        if (node == null) {
            return true;
        }
        int leftHight = height(node.getLeftChild());
        int rightHight = height(node.getRightChild());
        if (leftHight - rightHight <= 1) {
            return true;
        } else {
            return false;
        }


    }
}
