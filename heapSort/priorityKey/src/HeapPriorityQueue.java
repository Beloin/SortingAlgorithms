
public class HeapPriorityQueue<T> implements PriorityQueue<T> {
    private Node<T>[] heap;
    private int heapSize;
    private int maxHeapSize;

    public HeapPriorityQueue(T[] items, int[] keys) {
        assert (items.length == keys.length) : "Items and Keys must be same Length";
        createNodeArray(items, keys);
    }

    private void createNodeArray(T[] items, int[] keys) {
        this.heap = this.createArray(items.length);
        for (int i = 0; i < items.length; i++) {
            heap[i] = new Node<>(items[i], keys[i]);
        }
        buildMaxHeap();
    }

    @Override
    public void insert(T item, int key) throws Exception {
        int minInteger = 0b10000000000000000000000000000000; // Min integer, or Integer.MIN_VALUE. Or 0x80000000
        Node<T> newNode = new Node<>(item, minInteger);
        int newSize = this.heapSize + 1;
        Node<T>[] newArray = this.createArray(newSize);

        // Copy new Array
        if (this.heapSize >= 0) {
            System.arraycopy(this.heap, 0, newArray, 0, this.heapSize);
        }

        newArray[newSize - 1] = newNode;

        this.heapSize = newSize;
        this.heap = newArray;

        updateMaxHeapSize();
        increaseKey(newSize - 1, key);
    }

    @SuppressWarnings("unchecked")
    private Node<T>[] createArray(int size) {
        return new Node[size];
    }

    @Override
    public T getMaximum() {
        return this.heap[0].getDescriptor();
    }

    @Override
    public T extractMaximum() throws Exception {
        if (this.heapSize < 1) {
            throw new Exception("Underflow");
        }
        Node<T> maxNode = this.heap[0];
        this.heap[0] = heap[heapSize - 1];

        // resize array?
        this.heapSize--;
        maxHeapify(0);
        return maxNode.getDescriptor();
    }

    @Override
    public void increaseKey(int key, int newKey) throws Exception {
        if (newKey < this.heap[key].getKey()) {
            throw new Exception("Cannot give a smaller value to an existing Key");
        }

        this.heap[key].setKey(newKey);
        while (key > 0 && this.heap[parentIndex(key)].getKey() < this.heap[key].getKey()) {
            Node<T> aux = this.heap[key];
            this.heap[key] = this.heap[parentIndex(key)];
            this.heap[parentIndex(key)] = aux;
            key = parentIndex(key);
        }
    }


    private void buildMaxHeap() {
        heapSize = this.heap.length;
        for (int i = (this.heap.length / 2) - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    private void maxHeapify(int currentIndex) {
        int leftIndex = this.leftIndex(currentIndex);
        int rightIndex = this.rightIndex(currentIndex);

        int maxIndex = currentIndex;

        if (leftIndex < heapSize && this.heap[leftIndex].getKey() > this.heap[currentIndex].getKey()) {
            maxIndex = leftIndex;
        }

        if (rightIndex < heapSize && this.heap[rightIndex].getKey() > this.heap[maxIndex].getKey()) {
            maxIndex = rightIndex;
        }

        if (maxIndex != currentIndex) {
            Node<T> aux = this.heap[currentIndex];
            this.heap[currentIndex] = this.heap[maxIndex];
            this.heap[maxIndex] = aux;

            maxHeapify(maxIndex);
        }
    }

    private void updateMaxHeapSize() {
        if (this.heapSize > this.maxHeapSize) {
            this.maxHeapSize = heapSize;
        }
    }

    private int parentIndex(int index) {
        return index / 2;
    }

    private int leftIndex(int index) {
        return (index * 2) + 1;
    }

    private int rightIndex(int index) {
        return (index * 2) + 2;
    }
}
