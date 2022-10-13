package Tencent;//import java.awt.*;
import java.util.*;

public class MyQueue{
    int Maxsize;
    int front;
    int rear;
    int[] arr;

    public MyQueue(int maxsize){
        Maxsize = maxsize;
        arr = new int[Maxsize];
        front =0;
        rear = 0;
    }

    public void push(String s){
        int x = Integer.parseInt(s);
        arr[rear] = x;
        rear = (rear+1)% Maxsize;
    }

    public int top(){
        if(rear==front){
            return -1;
        }
        return arr[front];
    }

    public int pop(){
        if(rear == front){
            return -1;
        }
        front = (front+1) % Maxsize;
        return 0;
    }

    public void clear(){
        rear = front;
    }

    public int size() {
        return (rear - front + Maxsize) % Maxsize;

    }

}

class Main {

    public static void main(String[] args){
        int Max = 1000;
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int T = Integer.parseInt(line);
        // T组数据
        for(int i = 0; i<T; i++){
            MyQueue myQuue = new MyQueue(Max); // 初始化
            String line1 = scanner.nextLine();
            int Q = Integer.parseInt(line1);
            // 第i组数据中的 Q 次操作
            for(int j=0; j<Q; j++){
                String string = scanner.nextLine();
                String[] operator = string.split(" ");
                switch (operator[0]){
                    case "PUSH":
                        myQuue.push(operator[1]);
                        break;
                    case "TOP":
                        System.out.println(myQuue.top());
                        break;
                    case "POP":
                        if(myQuue.pop() == -1) System.out.println(-1);
                        break;
                    case "SIZE":
                        System.out.println(myQuue.size());
                        break;
                    case "CLEAR":
                        myQuue.clear();
                        break;
                    default:
                        break;
                }
            }

//            for (int i = 0; i < res.size(); i++) {
//                System.out.println(res.get(i));
//            }
        }
    }

}
