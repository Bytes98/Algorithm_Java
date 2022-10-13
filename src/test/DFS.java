//
//
//class Node {
//    int x;
//    Node1 next;
//    public Node(int x) {
//        this.x = x;
//        this.next = null;
//    }
//}
//public class DFS {
//    public Node first;
//    public Node last;
//
//    public static int run[] = new int[9];
//    public static DFS head[] = new DFS[9];
//
//    public static void dfs(int current) {
//        run[current] = 1;
//        System.out.print("[" + current + "]");
//
//        while (head[current].first != null) {
//            if (run[head[current].first.x] == 0) { //如果顶点尚未遍历，就进行dfs递归
//                dfs(head[current].first.x);
//            }
//            head[current].first = head[current].first.next;
//        }
//    }
//
//    public boolean isEmpty() {
//        return first == null;
//    }
//
//    public void print() {
//        Node current = first;
//        while (current != null) {
//            System.out.print("[" + current.x + "]");
//            current = current.next;
//        }
//        System.out.println();
//    }
//
//    public void insert(int x) {
//        Node newNode = new Node(x);
//        if (this.isEmpty()) {
//            first = newNode;
//            last = newNode;
//        } else {
//            last.next = newNode;
//            last = newNode;
//        }
//    }
//
//    public static void main(String[] args) {
//        int Data[][] = {{1, 2}, {2, 1}, {1, 3}, {3, 1}, {2, 4}, {4, 2},
//                {2, 5}, {5, 2}, {3, 6}, {6, 3}, {3, 7}, {7, 3}, {4, 5}, {5, 4},
//                {6, 7}, {7, 6}, {5, 8}, {8, 5}, {6, 8}, {8, 6}};
//        int DataNum;
//        int i, j;
//        System.out.println("图形的邻接表内容为：");
//        for (i = 1; i < 9; i++) {
//            run[i] = 0;
//            head[i] = new DFS();
//            System.out.print("顶点" + i + "=>");
//            for (j = 0; j < 20; j++) {
//                if (Data[j][0] == i) {
//                    DataNum = Data[j][1];
//                    head[i].insert(DataNum);
//                }
//            }
//            head[i].print();
//        }
//        System.out.println("深度优先遍历顶点：");
//        dfs(1);
//        System.out.println("");
//    }
//}
