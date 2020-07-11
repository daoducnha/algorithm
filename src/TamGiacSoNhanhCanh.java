//public class TamGiacSoNhanhCanh {
//    public static void main(String[] args) {
//        int[][] data = new int[5][5];
//        data[0] = new int[]{7, -1, -1, -1, -1};
//        data[1] = new int[]{5, 6, -1, -1, -1};
//        data[2] = new int[]{8, 9, 7, -1, -1};
//        data[3] = new int[]{5, 1, 7, 6, -1};
//        data[4] = new int[]{8, 4, 5, 3, 7};
//
//        int len = data.length;
//        int[] tmpAnswers = new int[len]; //Phuong an tot nhat tam thoi
//        int[] solution = new int[len]; // Phuong an toi uu
//        int tgt = data[0][0];
//        int ct = calculateCT(0, 0, data, tgt, 0);
//        int gtlntt = data[0][0]; // can tren, tong gia tri, gia tri lon nhat tam thoi;
//
//        Node root = initRoot(len, tmpAnswers, solution, ct, tgt, gtlntt);
//        branchBounch(1, 0, root);
//        printSolution();
//    }
//
//    private static Node initRoot(int len, int[] tmpAnswers, int[] pa, int ct, int tgt, int gtlntt) {
//        return new Node(len, tmpAnswers, pa, ct, tgt, gtlntt);
//    }
//
//    private static void updateGoodSolution(int tgt, int gtlntt, int[] tmpAnwwers, int[] solution) {
//        if (gtlntt < tgt) {
//            gtlntt = tgt;
//            for (int i = 0; i < tmpAnwwers.length; i++) {
//                solution[i] = tmpAnwwers[i];
//            }
//        }
//    }
//
//    private static int getMaxLineI(int[] line, int i) {
//        int k, max = line[0];
//        for (k = 1; k <= i; k++) {
//            if (line[k] > max) {
//                max = line[k];
//            }
//        }
//        return max;
//    }
//
//    private static int getMaxNextLine(int[] line, int j) {
//        if (j == 0)
//            return line[0] > line[1] ? line[0] : line[1];
//        if (line[j - 1] > line[j] && line[j - 1] > line[j + 1])
//            return line[j - 1];
//        if (line[j] > line[j - 1] && line[j] > line[j + 1])
//            return line[j];
//        return line[j + 1];
//    }
//
//    private static int calculateCT(int i, int j, int[][] matrix, int tgt, int ct) {
//        int k;
//        // ct = tgt root + max all number of next line
//        ct = tgt + getMaxNextLine(matrix[i + 1], j);
//        // add max of another line
//        for (k = i + 2; k < matrix.length; k++) {
//            ct = ct + getMaxLineI(matrix[k], k);
//        }
//
//        return ct;
//    }
//
//    public static void printMatrix(int[][] matrix) {
//        int l = matrix.length;
//        for (int i = 0; i < l; i++) {
//            for (int j = 0; j < l; j++) {
//                System.out.print(matrix[i][j] + ", ");
//            }
//            System.out.println();
//        }
//    }
//
//    private static class Node {
//        int len;
//        int[] tmpAnswers; // Phuong an tot nhat tam thoi
//        int[] PA; // Phuong an toi uu
//        int CT; // can tren
//        int TGT; // tong gia tri
//        int GTLNTT; //  gia tri lon nhat tam thoi;
//
////        public Node() {
////
////        }
//
//        public Node(int len, int[] tmpAnswers, int[] PA, int CT, int TGT, int GTLNTT) {
//            this.len = len;
//            this.tmpAnswers = tmpAnswers;
//            this.PA = PA;
//            this.CT = CT;
//            this.TGT = TGT;
//            this.GTLNTT = GTLNTT;
//        }
//
//        public int getLen() {
//            return len;
//        }
//
//        public void setLen(int len) {
//            this.len = len;
//        }
//
//        public int[] getTmpAnswers() {
//            return tmpAnswers;
//        }
//
//        public void setTmpAnswers(int[] tmpAnswers) {
//            this.tmpAnswers = tmpAnswers;
//        }
//
//        public int[] getPA() {
//            return PA;
//        }
//
//        public void setPA(int[] PA) {
//            this.PA = PA;
//        }
//
//        public int getCT() {
//            return CT;
//        }
//
//        public void setCT(int CT) {
//            this.CT = CT;
//        }
//
//        public int getTGT() {
//            return TGT;
//        }
//
//        public void setTGT(int TGT) {
//            this.TGT = TGT;
//        }
//
//        public int getGTLNTT() {
//            return GTLNTT;
//        }
//
//        public void setGTLNTT(int GTLNTT) {
//            this.GTLNTT = GTLNTT;
//        }
//    }
//}
