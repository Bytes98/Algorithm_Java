package dynamicProgramming;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/18/15:32
 * @Description:
 *https://leetcode.cn/problems/integer-break/
 * 整数拆分
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        //1 确定dp数组（dp table）以及下标的含义
        // dp[i]：分拆数字i，可以得到的最大乘积为dp[i]。
        // 2 确定递推公式
        // 一个是j * (i - j) 直接相乘。 两个数相乘
        // 一个是j * dp[i - j]，相当于是拆分(i - j)， 两个以及两个以上的个数相乘。
        // dp[i] = max(dp[i], max((i - j) * j, dp[i - j] * j));

        //dp[i] 为正整数 i 拆分后的结果的最大乘积
        int[] dp = new int[n+1];
        dp[2]=1;
        for(int i=3;i<=n;i++){
            for(int j=1;j<=i-j;j++){
                // 这里的 j 其实最大值为 i-j,再大只不过是重复而已，
                //并且，在本题中，我们分析 dp[0], dp[1]都是无意义的，
                //j 最大到 i-j,就不会用到 dp[0]与dp[1]
                dp[i]=Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
                // j * (i - j) 是单纯的把整数 i 拆分为两个数 也就是 i,i-j ，再相乘
                //而j * dp[i - j]是将 i 拆分成两个以及两个以上的个数,再相乘。
            }
        }
        return dp[n];

    }
}
