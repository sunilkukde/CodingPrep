package search.bst;

public class BSTNode<T extends Comparable<T>> {

    private T key;
    private BSTNode<T> left;
    private BSTNode<T> right;

    public BSTNode(T key, BSTNode<T> left, BSTNode<T> right) {
        super();
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public BSTNode<T> getLeft() {
        return left;
    }

    public void setLeft(BSTNode<T> left) {
        this.left = left;
    }

    public BSTNode<T> getRight() {
        return right;
    }

    public void setRight(BSTNode<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BSTNode [key=" + key + ", left=" + left + ", right=" + right + "]";
    }

}
