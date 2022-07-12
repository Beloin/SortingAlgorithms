public class Node<T> {
    private int key;
    private T descriptor;

    public Node(T descriptor, int key) {
        this.key = key;
        this.descriptor = descriptor;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public T getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(T descriptor) {
        this.descriptor = descriptor;
    }
}
