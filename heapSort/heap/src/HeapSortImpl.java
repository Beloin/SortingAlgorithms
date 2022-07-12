public class HeapSortImpl implements HeapSort {
    int heapSize;

    @Override
    public int[] sort(int[] arr, boolean inPlace) {
        if (!inPlace) {
            arr = arr.clone();
        }

        buildMaxHeap(arr);

        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapSize--;

            maxHeapify(arr, 0);
        }

        return arr;
    }

    private void buildMaxHeap(int[] arr) {
        heapSize = arr.length;
        for (int i = (arr.length / 2) - 1; i >= 0; i--) {
            maxHeapify(arr, i);
        }
    }

    private void maxHeapify(int[] arr, int currentIndex) {
        int leftIndex = this.leftIndex(currentIndex);
        int rightIndex = this.rightIndex(currentIndex);

        int maxIndex = currentIndex;

        if (leftIndex < heapSize && arr[leftIndex] > arr[currentIndex]) {
            maxIndex = leftIndex;
        }

        if (rightIndex < heapSize && arr[rightIndex] > arr[maxIndex]) {
            maxIndex = rightIndex;
        }

        if (maxIndex != currentIndex) {
            int aux = arr[currentIndex];
            arr[currentIndex] = arr[maxIndex];
            arr[maxIndex] = aux;

            maxHeapify(arr, maxIndex);
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
