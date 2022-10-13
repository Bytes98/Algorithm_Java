package greedy;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 53. 最大子数组和
 */
public class MaximumSubarray {
    /**
     *  特别巧妙：
     *  if (count<=0) count=0; // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和, 为了下一轮。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count=0;
        for(int i = 0; i < nums.length; i++){
            count += nums[i];
            if (count>result) result=count; //// 取区间累计的最大值（相当于不断确定最大子序终止位置）
            if (count<=0) count=0; // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和, 为了下一轮。
        }
        return result;
    }
    public static void main(String[] args){
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maximumSubarray.maxSubArray(nums));
    }
}
