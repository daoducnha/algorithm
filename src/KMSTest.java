import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;


public class KMSTest {
    private static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {

        int[] testData = {5, 10, 4, 4, 4, 5};
//        int[] testData = {0, 1, 2, 3, 4, 5};


        resolve2(testData);

    }


    private static void resolve2(int[] arr) {
        int len = arr.length;
        List<List<Integer>>[] baseList = initTmpRs(len - 3 + 1);

        // Create data for s = 3;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (arr[i] + arr[j] > arr[k]
                            && arr[j] + arr[k] > arr[i]
                            && arr[i] + arr[k] > arr[j]) {
                        baseList[0].add(Arrays.asList(i, j, k));
                    }
                }
            }
        }

        // update for another case
        for (int i = 1; i <= len - 3; i++) {
            List<List<Integer>> pre = baseList[i - 1];
            for (int j = 0; j < pre.size(); j++) {
                List<Integer> currentList = pre.get(j);
                int maxIndex = currentList.get(currentList.size() - 1);
                for (int k = maxIndex + 1; k < len; k++) {
                    List<Integer> t = new ArrayList<>(currentList);
                    t.add(k);
                    if (isValid(arr, t)) {
                        baseList[i].add(t);
                    }
                }
            }
        }

        for (int i = 0; i < baseList.length; i++) {
            if (baseList[i].size() != 0) {
                System.out.println(baseList[i]);
            }
        }
    }

    private static boolean isValid(int[] arr, List<Integer> tmp) {

        int size = tmp.size();
        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size; k++) {
                    if (arr[tmp.get(i)] + arr[tmp.get(j)] < arr[tmp.get(k)]
                            || arr[tmp.get(i)] + arr[tmp.get(k)] < arr[tmp.get(j)]
                            || arr[tmp.get(j)] + arr[tmp.get(k)] < arr[tmp.get(i)]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static List<List<Integer>>[] initTmpRs(int s) {
        List<List<Integer>>[] listResults = new List[s];
        for (int i = 0; i < s; i++) {
            listResults[i] = new ArrayList<>();
        }
        return listResults;
    }

}
