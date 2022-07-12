public class Main {
    public static void main(String[] args) throws Exception {
        String[] items = {"Jabulani", "OK Google", "Singapura", "Jesus"};
        int[] values = {3, 12, 1, 9999999};

        PriorityQueue<String> pKey = new HeapPriorityQueue<>(items, values);

        for (int i = 0; i < items.length; i++) {
            System.out.println(pKey.extractMaximum());
        }
    }
}
