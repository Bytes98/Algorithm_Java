package arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/14/10:28
 * @Description:
 */
public class GetLeastNumbers {
    /**
     * way1 基于快排
     * way2 用基于红黑树的集合（multiSet？）、大根堆， 存放k个， 放满k个之后， 每次用该集合最大值跟下一个比较。 适合海量数据
     * 注意 TreeSet 不能包含重复元素
     * @param arr
     * @param k
     * @return
     */

    public int[] getLeastNumbers1(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }
    private void quickSort(int[] arr, int l, int r) {
        // 子数组长度为 1 时终止递归
        if (l >= r) return;
        // 哨兵划分操作（以 arr[l] 作为基准数）
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        // 递归左（右）子数组执行哨兵划分
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int[] getLeastNumbers2(int[] arr, int k){
        int[] result = new int[k];
        if(k==0) return result;

        //大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2)->o2.compareTo(o1));
        for(int i=0; i<k; i++){
            queue.add(arr[i]);
        }
        // System.out.println(queue);

        for(int i=k; i<arr.length; i++){
            int tempMax = queue.peek();
            if(tempMax>arr[i]){
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        int i=0;
        for(Integer num : queue){
            result[i] = num;
            i++;
        }

        return result;
    }

}
