package search.bst;

public class BSTree<T extends Comparable<T>> {

    private BSTNode<T> root;

    public void addKey(T key) {
        root = addKey(root, new BSTNode<T>(key, null, null));

    }

    private BSTNode<T> addKey(BSTNode<T> curNode, BSTNode<T> newNode) {
        if (curNode == null)
            return newNode;

        if (newNode.getKey().compareTo(curNode.getKey()) < 0) {
            curNode.setLeft(addKey(curNode.getLeft(), newNode));
        } else if (newNode.getKey().compareTo(curNode.getKey()) > 0) {
            curNode.setRight(addKey(curNode.getRight(), newNode));
        }
        
        return curNode;

    }

    public void preOrderTraverse(BSTNode<T> node) {
        if (node != null) {
            preOrderTraverse(node.getLeft());
            System.out.println(node.getKey());
            preOrderTraverse(node.getRight());
        }

    }

    public void inOrderTraverse(BSTNode<T> node) {
        if (node != null) {
            System.out.println(node.getKey());
            inOrderTraverse(node.getLeft());
            inOrderTraverse(node.getRight());
        }

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
