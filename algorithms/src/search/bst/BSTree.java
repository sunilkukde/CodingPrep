package search.bst;

public class BSTree<T extends Comparable<T>, S> {

    private BSTNode<T, S> root;

    public void add(T key, S value) {
        root = add(root, new BSTNode<T, S>(key, value, null, null));

    }

    private BSTNode<T, S> add(BSTNode<T, S> curNode, BSTNode<T, S> newNode) {
        if (curNode == null)
            return newNode;

        if (newNode.getKey().compareTo(curNode.getKey()) < 0) {
            curNode.setLeft(add(curNode.getLeft(), newNode));
        } else if (newNode.getKey().compareTo(curNode.getKey()) > 0) {
            curNode.setRight(add(curNode.getRight(), newNode));
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

        myTree.add('H', "Hello");
        myTree.add('C', "Cat");
        myTree.add('X', "Xmas");
        myTree.add('T', "Toy");
        myTree.add('A', "Apple");
        myTree.add('M', "Money");
        myTree.add('A', "Aeroplane");

        myTree.preOrderTraverse(myTree.root);
        System.out.println();
        myTree.inOrderTraverse(myTree.root);

        System.out.println("Search result: " + myTree.search('T'));
    }
}
