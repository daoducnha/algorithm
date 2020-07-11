public class GiaiThua {
    public static void main(String[] args) {
//        System.out.println(GT(6));
//        System.out.println(Fibo(5));
        long start = System.currentTimeMillis();
        System.out.println(GT(21));
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("===================");
        start = System.currentTimeMillis();
        System.out.println(GT(21));
        System.out.println(System.currentTimeMillis() - start);
    }


    private static long GT(long n) {
        if (n == 0) {
            return 1;
        }

        return n * GT(n - 1);
    }
    private static long GT_QHD(long n) {
        int[] rs = new int[(int) (n + 1)];
        rs[0] = 1;

        for (int i = 1; i< n+1; i++){
            rs[i] = i * rs[i-1];
        }
        return rs[(int)n];
    }



    private static int Fibo(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return Fibo(n - 1) + Fibo(n - 2);
        }
    }

    private static int comb(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        return comb(n - 1, k - 1) + comb(n - 1, k);
    }

    private static int combQHD(int n, int k) {
        int[][] matrix = new int[n + 1][n + 1];
        matrix[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            matrix[i][0] = 1;
            matrix[i][i] = 1;
            for (int j = 1; j < i; j++) {
                matrix[i][j] = matrix[i - 1][j - 1] + matrix[i - 1][j];
            }
        }
        return matrix[n][k];
    }
}
