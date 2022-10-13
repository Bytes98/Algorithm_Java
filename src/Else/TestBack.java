package Else;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/10/09/17:05
 * @Description:
 */
public class TestBack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//构建一个Scanner对象
        System.out.print("输入数据：");
//        String s1 = sc.next(); // 接收一个单词，空格分隔
//        System.out.println("接收的单词s1："+s1);
        Integer number = sc.nextInt();
        System.out.println(number);
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "xvalue");
        System.out.println(map.get(1));
        List<String> list = new ArrayList<>();
        list.add("xx1");
        list.add("xx2");
        System.out.println(list.get(0));
        list.remove(0);
        System.out.println(list.get(0));

        Collections.sort(list);


    }
}
