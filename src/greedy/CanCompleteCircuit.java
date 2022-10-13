package greedy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/13/10:06
 * @Description:
 */
public class CanCompleteCircuit {
    /**
     * 局部最优：当前累加rest[j]的和curSum一旦小于0，起始位置startIndex至少要是j+1，因为从j开始一定不行。
     * 全局最优：找到可以跑一圈的起始位置。
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int startIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            int rest = gas[i] - cost[i];
            totalSum += rest;
            curSum += rest;
            if(curSum<0){ //前累加rest[j]的和curSum一旦小于0
                curSum=0;
                startIndex = i+1;
            }
        }
        if(totalSum<0)  return -1;
        return startIndex;
    }
}
