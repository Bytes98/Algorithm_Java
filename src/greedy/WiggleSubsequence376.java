package greedy;

/**
 * https://leetcode-cn.com/problems/wiggle-subsequence/
 * 376 摆动数列
 */
public class WiggleSubsequence376 {

    /**
     *             // [0 0] preDiff=0 curDiff=0
     *             // [0 1] preDiff=0 curDiff>0 result++
     *             // [1 0] preDiff=0 curDiff<0 result++
     *             // [0 0 1]  preDiff=0, curDiff>0  result++
     *             // [0 1 2]  preDiff>0, curDiff>0
     *             // [1 0 1]  preDiff<0, curDiff>0  result++
     *             // [1 1 0]  preDiff=0, curDiff<0  result++
     *             // [1 3 2]  preDiff>0, curDiff<0  result++
     *             // [3 2 1]  preDiff<0, curDiff<0
     *             // [1 1 1]  preDiff=0, curDiff=0
     *             // [0 1 1]  preDiff>0, curDiff=0
     *             // [1 0 0]  preDiff<0, curDiff=0
     * @param nums
     * @return
     */
    int wiggleMaxLength(int[] nums){

        if(nums.length <= 1) return nums.length;
        int curDiff = 0;
        int preDiff = 0;
        int result = 1;
        for(int i = 0; i<nums.length-1;i++){
            curDiff = nums[i+1] - nums[i];
            // [0 0] preDiff=0 curDiff=0
            // [0 1] preDiff=0 curDiff>0 result++
            // [1 0] preDiff=0 curDiff<0 result++
            // [0 0 1]  preDiff=0, curDiff>0  result++
            // [0 1 2]  preDiff>0, curDiff>0
            // [1 0 1]  preDiff<0, curDiff>0  result++
            // [1 1 0]  preDiff=0, curDiff<0  result++
            // [1 3 2]  preDiff>0, curDiff<0  result++
            // [3 2 1]  preDiff<0, curDiff<0
            // [1 1 1]  preDiff=0, curDiff=0
            // [0 1 1]  preDiff>0, curDiff=0
            // [1 0 0]  preDiff<0, curDiff=0
            if((preDiff<=0 && curDiff>0)||(preDiff>=0 && curDiff<0)){
                result++;
                preDiff = curDiff;
            }
        }
        return result;
    }

    public static void main(String[] args){
        WiggleSubsequence376 wiggleSubsequence376 = new WiggleSubsequence376();
        int[] nums = {1,2,3};
        System.out.println(wiggleSubsequence376.wiggleMaxLength(nums));
    }
}
