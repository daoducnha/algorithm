import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;


public class KMSTest {
    private static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {

//        int[] testData = {5, 10, 4, 4, 4, 5};
        int[] testData = {0, 1, 2, 3, 4, 5};


        resolve(testData);

    }

    private static void test() {
        int[] dt = {0, 1, 2, 3, 4, 5};
        for (int i = 0; i < dt.length; i++) {
            for (int j = i + 1; j < dt.length; j++) {
                for (int k = j + 1; k < dt.length; k++) {
                    System.out.println("arr: [" + i + ", " + j + ", " + k + "]");
                }
            }
        }
    }


    private static int resolve(int[] arr) {
        int length = arr.length;
        int[][] matrix = new int[length][length];

        //Init matrix:
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i + j < length) {
                    matrix[i][j] = j + i;
                } else {
                    matrix[i][j] = -1;
                }

            }
        }

        for (int s = 3; s <= length; s++) {
            for (int i = 0; i < s; i++) {
                for (int j = 0; j <= length - s; j++) {
                    List<Integer> tmp = new ArrayList<>();
                    for (int k = 0; k < s; k++) {

                        tmp.add(matrix[k][i]);

                    }
                    System.out.println(tmp);
                }
            }
        }
        return 1;
    }

}
