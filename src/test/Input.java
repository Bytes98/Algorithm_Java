package test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    // 本题为考试单行多行输入输出规范示例，无需提交，不计分。
    static class Input1 {

        public void Input1() {
            Scanner in = new Scanner(System.in);
            // 一行输入， 以空格为分割，连续读取两个数求和, 及时一行超过
            // input 12 12
            // output 24
            //
            // input 12 34 51 135
            // output 46
            //        186
            //
            // while (in.hasNextInt())  读取一行数据， in.buf ="12 34 51 135\n", 即收到回车进入循环
            // position
            // hasNextResult   hasNextPosition
            //
            while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
                try{
                    int a = in.nextInt();
                    int b = in.nextInt(); // 当Scanner.nextInt() 读取不到整数时，即"12C\n"  or "12X 12"时，会报错
                    System.out.println(a + b);
                } catch(Exception  e){
//                    e.printStackTrace();
                    in.next(); // 不执行这句，就直接结束循环了,  换句话说，如果读取整数出错又想继续循环，需要加这句话。
                    System.out.println("输入整数");// nextInt()
                }
            } // 输入 Z z 时，会推出循环

        }
    }

    // 本题为考试多行输入输出规范示例，无需提交，不计分。
    static class Input2 {
        public void Input2(){
            Scanner sc = new Scanner(System.in);
            try {
                int n = sc.nextInt();
                int ans = 0, x;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) { // 输入n*n个数据
                        x = sc.nextInt();
                        ans += x;
                    }
                }
                System.out.println(ans);
            }catch(Exception  e){
                System.out.println("输入整数");// nextInt()
            }
        }
    }

    public static void main(String[] args){
        System.out.println("Start input1");
        Input1 input1 = new Input1();
        input1.Input1();
        System.out.println("Start input2");
        Input2 input2 = new Input2();
        input2.Input2();
    }

}

