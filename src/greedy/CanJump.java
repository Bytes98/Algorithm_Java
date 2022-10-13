package greedy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/10/10:45
 * @Description:
 */
public class CanJump {
    /**
     * 不用拘泥于每次究竟跳几步，而是看覆盖范围，覆盖范围内一定是可以跳过来的，不用管是怎么跳的。
     * 小细节 ：  i <= coverArea
     * for (int i = 0; i <= coverArea; i++){}
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverArea = 0; // 统计最大可覆盖的范围
        int currentIcoverArea = 0; // 对i而言，i所能覆盖的范围
        for (int i = 0; i <= coverArea; i++) { // 小细节， i <= coverArea
            currentIcoverArea = i + nums[i]; // 既然是i开始算了，那么(0,i) 肯定能覆盖, 所以i+。 然后再去往后面最最大的范围为nums[i]
            // 所以对i而言，i所能覆盖的范围就是 (0,i) + 往后跳的最大步数， 即i+nums[i].
            coverArea = Math.max(coverArea, currentIcoverArea); // 更新覆盖的范围
            if (coverArea >= nums.length - 1) { //如果能全部覆盖
                return true;
            }
        }
        return false;
    }

}
