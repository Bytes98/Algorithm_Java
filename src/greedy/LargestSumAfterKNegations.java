package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/12/12:23
 * @Description:
 *  K 次取反后最大化的数组和
 *  https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/
 */
public class LargestSumAfterKNegations {

    class Mycomparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            // 按绝对值，从大到小
            return Math.abs(o2) - Math.abs(o1);
        }
    }

    class Solution {
        public int largestSumAfterKNegations(int[] nums, int k) {
            int result = 0;
            List<Integer> list = new ArrayList<>();
            nums = IntStream.of(nums)
                    .boxed()
                    .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                    .mapToInt(Integer::intValue).toArray();

            for(int i=0; i<nums.length; i++){
                if(nums[i]<0 && k>0){
                    nums[i] *= -1;
                    k--;
                }
            }
            System.out.println(Arrays.toString(nums));
            // 如果k还大于0(k值 > 原本负数个数)，那么反复转变数值最小的元素，将K用完
            if (k % 2 == 1) nums[nums.length - 1] *= -1;
            return Arrays.stream(nums).sum();
        }
    }
}
