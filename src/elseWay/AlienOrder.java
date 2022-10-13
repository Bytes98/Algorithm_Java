package elseWay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/08/02/21:16
 * @Description:
 */
public class AlienOrder {
    public String alienOrder(String[] words) {
        return "ok";
    }

    //可变参数写法
    public static int getSum(int... arr) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        return sum;
    }


    public static void main(String[] args){
        String word1 = "abc";
        String word2 = "ab";
        System.out.println(word1.startsWith(word2)); // true
        for(int i =0 ; i<word1.length(); i++){
            System.out.println(Character.toUpperCase(word1.charAt(i)));
        }


        int[] nums = {5,3,2,4,1};
        
        int sum = Arrays.stream(nums).sum();
        System.out.println(sum);
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {5,3,2,4,1};
        System.out.println(Arrays.equals(nums, arr1));
        System.out.println(Arrays.equals(nums, arr2));

         List<Integer> list = new ArrayList<>();
         list.add(3);
         list.add(2);
         list.add(4);
         Collections.sort(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }


        //  求 8 位二进制整数0110 1100从左数起的第 2 个（从 0 开始计数）数位。
        //  我们先将 0110 1100 右移5位（7-2=5）得到0000 0011，
        //  再将它和0000 0001做位与运算，结果为0000 0001，即1。
        //  8 位二进制整数 0110 1100 从左边数起的第 2 个数位的确是1。
        int[] a = {3};
        int[] b = {3};
        System.out.println(a+" "+b);
        String sa = "3";
        String sb = "3";
        String sc = sa;
        String sd = new String("3");
        System.out.println(sa+" "+sb+" "+sc);
        System.out.println(sa.equals(sb)+" "+sb.equals(sc)+" "+sa.equals(sd));
        System.out.println(sa.hashCode() + " " + sb.hashCode() + " " + sc.hashCode() + " " + sd.hashCode());


        System.out.println(getSum(nums));
    }

}
