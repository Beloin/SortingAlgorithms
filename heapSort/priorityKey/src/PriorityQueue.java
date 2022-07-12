public interface PriorityQueue<T> {
    void insert(T item, int key) throws Exception;
    T getMaximum();
    T extractMaximum() throws Exception;
    void increaseKey(int key, int newKey) throws Exception;
}
