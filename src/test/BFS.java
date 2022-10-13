//class Node {
//    int x;
//    Node1 next;
//    public Node1(int x) {
//        this.x = x;
//        this.next = null;
//    }
//}
//public class BFS {
//    public Node first;
//    public Node last;
//
//    public static int run[] = new int[9];
//    public static BFS head[] = new BFS[9];
//    public final static int MAXSIZE = 10;
//    static int[] queue = new int[MAXSIZE];
//    static int front = -1;
//    static int rear = -1;
//
//    public static void enqueue(int value) {
//        if(rear>=MAXSIZE) return;
//        rear++;
//        queue[rear] = value;
//    }
//
//    public static int dequeue() {
//        if(front == rear) return -1;
//        front++;
//        return queue[front];
//    }
//
//    public static void bfs(int current) {
//        Node tempNode;
//        enqueue(current);
//        run[current] = 1;
//        System.out.print("[" + current + "]");
//        while (front != rear) {
//            current = dequeue();
//            tempNode = head[current].first;
//            while (tempNode != null) {
//                if(run[tempNode.x] == 0) {
//                    enqueue(tempNode.x);
//                    run[tempNode.x] = 1;
//                    System.out.print("[" + tempNode.x + "]");
//                }
//                tempNode = tempNode.next;
//            }
//        }
//    }
//
//    public boolean isEmpty() {
//        return first == null;
//    }
//
//    public void print() {
//        Node current = first;
//        while(current != null) {
//            System.out.print("[" + current.x + "]");
//            current = current.next;
//        }
//        System.out.println();
//    }
//    public void insert(int x) {
//        Node newNode = new Node(x);
//        if(this.isEmpty()) {
//            first = newNode;
//            last = newNode;
//        }
//        else {
//            last.next = newNode;
//            last = newNode;
//        }
//    }
//
//    public static void main(String[] args) {
//        int Data[][] = { {1,2}, {2,1}, {1,3}, {3,1}, {2,4}, {4,2},
//                {2,5}, {5,2}, {3,6}, {6,3}, {3,7}, {7,3}, {4,5}, {5,4},
//                {6,7}, {7,6}, {5,8}, {8,5}, {6,8}, {8,6} };
//        int DataNum;
//        int i,j;
//        System.out.println("图形的邻接表内容为：");
//        for(i=1;i<9;i++) {
//            run[i] = 0;
//            head[i] = new BFS();
//            System.out.print("顶点" + i + "=>");
//            for (j=0;j<20;j++) {
//                if(Data[j][0] == i) {
//                    DataNum = Data[j][1];
//                    head[i].insert(DataNum);
//                }
//            }
//            head[i].print();
//        }
//        System.out.println("深度优先遍历顶点：");
//        bfs(1);
//        System.out.println("");
//    }
//
//}