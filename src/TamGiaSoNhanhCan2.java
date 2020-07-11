//import java.util.List;
//
//public class TamGiaSoNhanhCan2 {
//
//    public static void main(String[] args) {
//        int[][] data = new int[5][5];
//        data[0] = new int[]{7, -1, -1, -1, -1};
//        data[1] = new int[]{5, 6, -1, -1, -1};
//        data[2] = new int[]{8, 9, 7, -1, -1};
//        data[3] = new int[]{5, 1, 7, 6, -1};
//        data[4] = new int[]{8, 4, 5, 3, 7};
//
//        Node root = initRoot(data);
//    }
//
//    private static Node initRoot(int[][] data){
//        Node root =  new Node(data[0][0], 0, 0, 0);
//    }
//
//
//    private static class Node{
//        private int total;
//        private int top;
//        private int line;
//        private int column;
//        private Node[] nodes;
//
//        public Node(int total, int top, int line, int column) {
//            this.total = total;
//            this.top = top;
//            this.line = line;
//            this.column = column;
//        }
//
//        public int getTotal() {
//            return total;
//        }
//
//        public void setTotal(int total) {
//            this.total = total;
//        }
//
//        public int getTop() {
//            return top;
//        }
//
//        public void setTop(int top) {
//            this.top = top;
//        }
//
//        public int getLine() {
//            return line;
//        }
//
//        public void setLine(int line) {
//            this.line = line;
//        }
//
//        public int getColumn() {
//            return column;
//        }
//
//        public void setColumn(int column) {
//            this.column = column;
//        }
//
//        public Node[] getNodes() {
//            return nodes;
//        }
//
//        public void setNodes(Node[] nodes) {
//            this.nodes = nodes;
//        }
//    }
//}
