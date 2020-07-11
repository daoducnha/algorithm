import java.util.Arrays;

public class TimDayConDaiNhatTangDan {
    public static void main(String[] args) {
        int[] data = {11, 4, 15, 6, 7, 1, 10, 4, 10, 9};

        Node[] rs = getSubArr(data);
        Arrays.stream(rs).forEach(System.out::println);
    }

    public static Node[] getSubArr(int[] arr) {
        int len = arr.length;
        int[] L = new int[len];
        int[] T = new int[len];

        updateTable(arr, L, T);

        return getSubArr(arr, L, T);
    }

    private static void updateTable(int[] arr, int[] L, int[] T) {
        int i, j, lenMax, indexOfMax;
        L[0] = 1;
        T[0] = 0;


        for (i = 1; i < arr.length; i++) {
            lenMax = 0;
            indexOfMax = i;
            for(j = i-1; j > 0; j--){
                if(arr[j] <= arr[i] && lenMax < L[j]) {
                    lenMax = L[j];
                    indexOfMax = j;
                }
            }
            L[i] = lenMax + 1;
            T[i] = indexOfMax;
        }

























//        for (i = 1; i < arr.length; i++) {
//            lMax = 0;
//            jMax = i;
//            for (j = 0; j < i; j++) {
//                if (arr[j] <= arr[i] && lMax < L[j]) {
//                    lMax = L[j];
//                    jMax = j;
//                }
//            }
//            L[i] = lMax + 1;
//            T[j] = jMax;
//        }
        System.out.println("L arr:");
        printArr(L);
        System.out.println("T arr:");
        printArr(T);
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    private static Node[] getSubArr(int[] arr, int[] L, int[] T) {

        int maxValue = L[0];
        int lastIndexOfSubArray = 0;
        for (int i = 1; i < L.length; i++) {
            if (L[i] > maxValue) {
                maxValue = L[i];
                lastIndexOfSubArray = i;
            }
        }

        Node[] nodes = new Node[maxValue];

        for (int i = maxValue - 1; i > 0; i--) {
            nodes[i] = new Node(lastIndexOfSubArray, arr[lastIndexOfSubArray]);
            lastIndexOfSubArray = T[lastIndexOfSubArray];
        }
        nodes[0] = new Node(lastIndexOfSubArray, arr[lastIndexOfSubArray]);

        return nodes;
    }

    private int getMaxLength(int[] L) {
//        int max = L[0];
//        for (int i =1; i< L.length; i++) {
//            if(L[i] > max){
//                max = L[i];
//            }
//        }
        return 0;
    }

    static class Node {
        int index;
        int value;

        public Node() {

        }

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", value=" + value +
                    '}';
        }
    }
}
