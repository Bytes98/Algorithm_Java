package greedy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/09/10:31
 * @Description:
 * 买卖股票的最佳时机 II
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class MaxProfit {
    /**
     * 注意：
     *  只有一只股票！ 任何时候最多只能持有一股股票， 也就是卖出去之后，才可以再买
     *  当前只有买股票或者卖股票的操作
     *  想获得利润至少要两天为一个交易单元
     *
     * 局部最优：收集每天的正利润，全局最优：求得最大利润。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i]>prices[i-1]) maxProfit += (prices[i]-prices[i-1]);
        }
        return maxProfit;
    }
}
