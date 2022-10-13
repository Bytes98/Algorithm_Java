package test;

import java.util.Arrays;
import java.util.Comparator;


class Mycomparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
//        从小到大
//        return Math.abs(o1) - Math.abs(o2);
//        从大到小
        return Math.abs(o2) - Math.abs(o1);
    }
}

public class TestArraysSort {

    public static void main(String[] args) {
//        Random random = new Random();
//        Integer[] arr = new Integer[20];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = random.nextInt(100);
//        }
        Integer[] arr = {3,4,-4,8,1,0,-1};
        Mycomparator myComparator = new Mycomparator();
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, myComparator);
        System.out.println(Arrays.toString(arr));
    }

}
