public class HeapSortTest {

    public static void testHeapSort() throws Exception {
        int[] testArray1 = {1, 2, 3, 4, 5, 6, 7};
        int[] testArray2
                = {220, 196, 117, 177, 302, 50, 110, 319, 313, 116, 79, 372, 96, 353, 72, 421, 137, 444, 59, 128};
        int[] testArray2Sorted = {50, 59, 72, 79, 96, 110, 116, 117, 128, 137, 177, 196, 220, 302, 313, 319, 353, 372, 421, 444};
        int[] testArray3 = {236, 250, 443, 293, 434, 88, 322, 311, 185, 146, 183, 81, 427, 396, 215, 194, 233, 36, 178, 294};
        int[] testArray3Sorted = {36, 81, 88, 146, 178, 183, 185, 194, 215, 233, 236, 250, 293, 294, 311, 322, 396, 427, 434, 443};

        HeapSort heapSort = new HeapSortImpl();

        heapSort.sort(testArray1, true);
        raiseIfNotEquals(testArray1, testArray1);

        heapSort.sort(testArray2, true);
        raiseIfNotEquals(testArray2, testArray2Sorted);

        heapSort.sort(testArray3, true);
        raiseIfNotEquals(testArray3, testArray3Sorted);
    }

    private static void raiseIfNotEquals(int[] array1, int[] array2) throws Exception {
        if (!assertEquals(array1, array2)) {
            throw new Exception("Array is not Equal");
        }
    }

    private static boolean assertEquals(int[] array1, int[] array2) {
        if (array1.length != array2.length) return false;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }

        return true;
    }
}
