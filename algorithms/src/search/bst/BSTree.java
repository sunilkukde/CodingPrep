package search.bst;

public class BSTree<T extends Comparable<T>, S> {

    private BSTNode<T, S> root;

    public void addKey(T key, S value) {
        root = addKey(root, new BSTNode<T, S>(key, value, null, null));

    }

    private BSTNode<T, S> addKey(BSTNode<T, S> curNode, BSTNode<T, S> newNode) {
        if (curNode == null)
            return newNode;

        if (newNode.getKey().compareTo(curNode.getKey()) < 0) {
            curNode.setLeft(addKey(curNode.getLeft(), newNode));
        } else if (newNode.getKey().compareTo(curNode.getKey()) > 0) {
            curNode.setRight(addKey(curNode.getRight(), newNode));
        } else {
            curNode.setValue(newNode.getValue());
        }

        return curNode;

    }

    public S search(T key) {
        return search(root, key);
    }

    private S search(BSTNode<T, S> node, T key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.getKey()) < 0) {
            return search(node.getLeft(), key);
        } else if (key.compareTo(node.getKey()) > 0) {
            return search(node.getRight(), key);
        } else {
            return node.getValue();
        }
    }

    public void preOrderTraverse(BSTNode<T, S> node) {
        if (node != null) {
            preOrderTraverse(node.getLeft());
            System.out.println(node);
            preOrderTraverse(node.getRight());
        }

    }

    public void inOrderTraverse(BSTNode<T, S> node) {
        if (node != null) {
            System.out.println(node);
            inOrderTraverse(node.getLeft());
            inOrderTraverse(node.getRight());
        }

    }

    public static void main(String[] args) {
        BSTree<Character, String> myTree = new BSTree<Character, String>();

        myTree.addKey('H', "Hello");
        myTree.addKey('C', "Cat");
        myTree.addKey('X', "Xmas");
        myTree.addKey('T', "Toy");
        myTree.addKey('A', "Apple");
        myTree.addKey('M', "Money");
        myTree.addKey('A', "Aeroplane");

        myTree.preOrderTraverse(myTree.root);
        System.out.println();
        myTree.inOrderTraverse(myTree.root);

        System.out.println("Search result: " + myTree.search('T'));
    }
}
