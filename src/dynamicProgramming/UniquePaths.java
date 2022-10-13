package dynamicProgramming;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/17/8:54
 * @Description:
 * 不同路径
 * https://leetcode.cn/problems/unique-paths/
 */
public class UniquePaths {
    /**
     * 按照动规五部曲来分析：
     * 1 确定dp数组（dp table）以及下标的含义
     *   dp[i][j] ：表示从（0 ，0）出发，到(i, j) 有dp[i][j]条不同的路径。
     * 2 确定递推公式
     *   想要求dp[i][j]，只能有两个方向来推导出来，即dp[i - 1][j] 和 dp[i][j - 1]。
     *   此时在回顾一下 dp[i - 1][j] 表示啥，是从(0, 0)的位置到(i - 1, j)有几条路径，dp[i][j - 1]同理。
     *   那么很自然，dp[i][j] = dp[i - 1][j] + dp[i][j - 1]，因为dp[i][j]只有这两个方向过来。
     * 3 dp数组的初始化
     *   如何初始化呢，首先dp[i][0]一定都是1，因为从(0, 0)的位置到(i, 0)的路径只有一条，那么dp[0][j]也同理。
     *   for (int i = 0; i < m; i++) dp[i][0] = 1; // 所有 dp[i][0]
     *   for (int j = 0; j < n; j++) dp[0][j] = 1; // 所有 dp[0][j]
     * 4 确定遍历顺序
     *   这里要看一下递归公式dp[i][j] = dp[i - 1][j] + dp[i][j - 1]，dp[i][j]都是从其上方和左方推导而来，那么从左到右一层一层遍历就可以了。
     *   这样就可以保证推导dp[i][j]的时候，dp[i - 1][j] 和 dp[i][j - 1]一定是有数值的。
     * 5 举例推导dp数组
     *  m=3 n=4
     *  1 1 1 1
     *  1 2 3 4
     *  1 3 6 10
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) dp[i][0] = 1;
        for(int j=0; j<n; j++) dp[0][j] = 1;
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
