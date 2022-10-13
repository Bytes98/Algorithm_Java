package greedy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/12/10:04
 * @Description:
 * 跳跃游戏 II
 * https://leetcode.cn/problems/jump-game-ii/
 */
public class Jump {

    public int jump(int[] nums) {
//        if(nums==null || nums.length <=1)  return 0;
        if ( nums.length == 1)  return 0;   // leetcode上，1 <= nums.length <= 104，;   0 <= nums[i] <= 1000

        int maxCover=0; //最大的覆盖区域
        int jumpCount = 0; //记录跳跃的次数
        int curDistanceIndex = 0;    // 当前覆盖最远距离下标
        for(int i=0; i<=nums.length; i++){
            int currentCover= i + nums[i];
            maxCover = Math.max(maxCover,currentCover);// 更新下一步覆盖最远距离下标
            if(i == curDistanceIndex){ // 遇到当前覆盖最远距离下标
                if(curDistanceIndex != nums.length-1){  // 如果当前覆盖最远距离下标不是终点
                    jumpCount++;  // 需要走下一步
                    curDistanceIndex = maxCover; // 更新当前覆盖最远距离下标（相当于加油了）
                    if(maxCover >= nums.length - 1) break; // 下一步的覆盖范围已经可以达到终点，结束循环
                }else break; // 当前覆盖最远距离下标是集合终点，不用做ans++操作了，直接结束
            }

        }
        return jumpCount;
    }

    public int jump2(int[] nums){
        int curDistanceIndex = 0;    // 当前覆盖最远距离下标
        int jumpCount = 0; //记录跳跃的次数
        int maxCover=0; //最大的覆盖区域
        for(int i =0; i<nums.length-1; i++){ // 注意这里是小于nums.size() - 1，这是关键所在
                                   //            其精髓在于控制移动下标i只移动到nums.size() - 2的位置，
                                   //            所以移动下标只要遇到当前覆盖最远距离的下标，直接步数加一，不用考虑别的了。
            int currentCover= i + nums[i];
            maxCover = Math.max(maxCover,currentCover);// 更新下一步覆盖最远距离下标
            if(i == curDistanceIndex){ // 遇到当前覆盖的最远距离下标
                curDistanceIndex = maxCover;   // 更新当前覆盖的最远距离下标
                jumpCount++;
            }
        }
        return jumpCount;
    }
}
