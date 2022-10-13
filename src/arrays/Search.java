package arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/15/10:38
 * @Description:
 * Offer 53 - I. 在排序数组中查找数字 I
 * https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class Search {

    /**
     * 最优 ，
     * 找头尾的基础上 -》 有序 -》 查  -》 二分查找
     * 分别用二分法找到 left、 right， 然后 right - left + 1;
     * 找到跟target一样的数了，判断是不是最左边的, 分类讨论：
    *              middleIndex > 0
    *                 middleIndex+1 就不用判断了，因为在找right  ×
    *                 middleIndex-1的数大于middleIndex的数  因为有序，从小到大，所以不可能  ×
    *                 middleIndex-1的数小于middleIndex的数  找到了，说明middleIndex一定是right  bingo
    *                 middleIndex-1的数等于middleIndex的数  说明还得往左边找
    *              middleIndex = 0   说明一定是right bingo
    *              middleIndex < 0   ×
     */
    public int search(int[] nums, int target) {
        if(nums!=null && nums.length>0){
            int left = getLeftTarget(nums, target, 0, nums.length-1);
            int right = getRightTarget(nums, nums.length, target, 0, nums.length-1);
            if(left>-1 && right>-1)
            {
                return right-left+1;
            }
        }
        return 0;
    }


    private int getLeftTarget(int[] data, int target, int startIndex, int endIndex){
        if(startIndex > endIndex) return -1;

        int middleIndex = (startIndex+endIndex)/2;
        int middleData = data[middleIndex];

        if(middleData == target){ // 找到跟target一样的数了
//             判断是不是最左边的, 分类讨论：
//             middleIndex > 0
//                middleIndex+1 就不用判断了，因为在找right  ×
//                middleIndex-1的数大于middleIndex的数  因为有序，从小到大，所以不可能  ×
//                middleIndex-1的数小于middleIndex的数  找到了，说明middleIndex一定是right  bingo
//                middleIndex-1的数等于middleIndex的数  说明还得往左边找
//             middleIndex = 0   说明一定是right bingo
//             middleIndex < 0   ×

            // 综上所述，如下：
            // 1 iddleIndex就是right
            // middleIndex>0 && data[middleIndex-1]!=target  , middleInde的前面（左边）一个数不是，middleIndex就是right
            // middleIndex==0  说明一定是right
            if((middleIndex>0 && data[middleIndex-1]!=target) || middleIndex==0) return middleIndex;
                //2 iddleIndex 不是right
            else endIndex = middleIndex-1; // 继续往左边找
        }else if(middleData > target) endIndex = middleIndex-1; // // 继续往左边找
        else startIndex = middleIndex + 1; // // 继续往右边找

        return getLeftTarget(data, target, startIndex, endIndex);
    }


    private int getRightTarget(int[] data,int numsLength,int target, int startIndex, int endIndex){
        if(startIndex > endIndex) return -1;

        int middleIndex = (startIndex+endIndex)/2;
        int middleData = data[middleIndex];

        if(middleData == target){ // 找到跟target一样的数了
            // 判断是不是最右边的
            if((middleIndex<numsLength-1 && data[middleIndex+1]!=target) || middleIndex==numsLength-1) return middleIndex;
            else startIndex = middleIndex+1;
        }else if(middleData < target) startIndex = middleIndex +1;
        else endIndex = middleIndex - 1;

        return getRightTarget(data, numsLength, target, startIndex, endIndex);
    }

    /**
     * 双指针，相比重头遍历，是优化了
     *
     * @param nums
     * @param target
     * @return
     */
     public int search2(int[] nums, int target) {
         for(int left=0, right=nums.length-1; left<=right;){
             if(nums[left]!=target) left++;
             if(nums[right]!=target) right--;
             if(left<=right && nums[right]==target && nums[left]==target) return right-left+1;
         }
         return 0;
     }
    /**
     * 最基础， 时间赋值度大
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        int count=0;
        for(Integer n: nums){
            if(n==target) count++;
        }
        return count;
    }



}

