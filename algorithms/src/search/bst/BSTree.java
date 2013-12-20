package search.bst;

public class BSTree<T extends Comparable<T>> {

    private BSTNode<T> root;

    public void addKey(T key) {
        BSTNode<T> newNode = new BSTNode<T>(key, null, null);
        if (root == null) {
            root = newNode;
        } else {
            addKey(root, newNode);
        }

    }

    private void addKey(BSTNode<T> curNode, BSTNode<T> newNode) {
        if (newNode.getKey().compareTo(curNode.getKey()) < 0) {
            if (curNode.getLeft() == null) {
                curNode.setLeft(newNode);
            } else {
                addKey(curNode.getLeft(), newNode);
            }
        } else if (newNode.getKey().compareTo(curNode.getKey()) > 0) {
            if (curNode.getRight() == null) {
                curNode.setRight(newNode);
            } else {
                addKey(curNode.getRight(), newNode);
            }
        } else {
            curNode = newNode;
        }
    }

    public void preOrderTraverse(BSTNode<T> node) {
        if (node == null) {
            return;
        }

        preOrderTraverse(node.getLeft());
        System.out.println(node.getKey());
        preOrderTraverse(node.getRight());
    }

    public void inOrderTraverse(BSTNode<T> node) {
        if (node == null) {
            return;
        }

        System.out.println(node.getKey());
        inOrderTraverse(node.getLeft());
        inOrderTraverse(node.getRight());
    }

    public static void main(String[] args) {
        BSTree<Character> myTree = new BSTree<Character>();

        myTree.addKey('H');
        myTree.addKey('C');
        myTree.addKey('X');
        myTree.addKey('T');
        myTree.addKey('A');
        myTree.addKey('M');
        myTree.addKey('A');

        myTree.preOrderTraverse(myTree.root);
        System.out.println();
        myTree.inOrderTraverse(myTree.root);
    }
}
