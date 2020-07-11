import java.util.Arrays;
import java.util.List;

public class Balo {
    public static void main(String[] args) {
        int n = 5;
        int W = 9;

        List<Node> data = Arrays.asList(
                new Node("Gao 1 bui", 3, 4),
                new Node("Nep cai hoa vang", 4, 5),
                new Node("Gao nang huong", 5, 6),
                new Node("Gao tai nguyen", 2, 3),
                new Node("Gao thai", 1, 1)

        );

        float[][] F = new float[n][W + 1];
        int[][] X = new int[n][W + 1];

        createTable(data, F, X, W, n);
        search(data, n, W, X);
        printData(data);
    }



    public static void createTable(List<Node> nodes, float[][] F, int[][] X, int W, int n) {
        int xMax, V;
        float fMax;
        int yk;
        // fill data for first row of X and F tables
        for (int v = 0; v < W; v++) {
            X[0][v] = v / nodes.get(0).getWeight();
            F[0][v] = X[0][v] * nodes.get(0).getPrice();
        }

        // fill data for another row of X and F tables

        for (int k = 1; k < n; k++) {
            for (int v = 0; v <= W; v++) {
                fMax = F[k - 1][v];
                xMax = 0;
                yk = v / nodes.get(k).getPrice();

                for (int xk = 1; xk <= yk; xk++) {
                    if (F[k - 1][v - xk * nodes.get(k).getWeight()] + xk * nodes.get(k).getPrice() > fMax) {
                        fMax = F[k - 1][v - xk * nodes.get(k).getWeight()] + xk * nodes.get(k).getPrice();
                        xMax = xk;
                    }
                }
                F[k][v] = fMax;
                X[k][v] = xMax;
            }
        }
    }

    public static void search(List<Node> nodes, int n, int W, int[][] X) {
        int k, V;
        V = W;
        for (k = n - 1; k >= 0; k--) {
            nodes.get(k).setNumberOfChoice(X[k][V]);
            V = V - X[k][V] * nodes.get(k).getWeight();
        }
    }

    private static void printData(List<Node> nodes) {
        nodes.stream().forEach(node -> System.out.println(node.toString()));
    }

    private static class Node {
        private String name;
        private int price;
        private int weight;
        private int numberOfChoice;

        public Node() {
        }

        public Node(String name, int weight, int price) {
            this.name = name;
            this.price = price;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getNumberOfChoice() {
            return numberOfChoice;
        }

        public void setNumberOfChoice(int numberOfChoice) {
            this.numberOfChoice = numberOfChoice;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", weight=" + weight +
                    ", numberOfChoice=" + numberOfChoice +
                    '}';
        }
    }
}
