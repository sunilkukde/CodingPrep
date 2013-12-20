package search.bst;

public class BSTNode<T extends Comparable<T>, S> {

    private T key;
    private S value;
    private BSTNode<T, S> left;
    private BSTNode<T, S> right;

    public BSTNode(T key, S value, BSTNode<T, S> left, BSTNode<T, S> right) {
        super();
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public S getValue() {
        return value;
    }

    public void setValue(S value) {
        this.value = value;
    }

    public BSTNode<T, S> getLeft() {
        return left;
    }

    public void setLeft(BSTNode<T, S> left) {
        this.left = left;
    }

    public BSTNode<T, S> getRight() {
        return right;
    }

    public void setRight(BSTNode<T, S> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BSTNode [key=" + key + ", value=" + value + ", left=" + left + ", right=" + right + "]";
    }

}
