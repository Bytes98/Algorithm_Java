package dynamicProgramming;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/17/9:14
 * @Description:
 * 不同路径II
 * https://leetcode.cn/problems/unique-paths-ii/
 */
public class UniquePathsWithObstacles {
    /**
     * 错误初始化思路：  初始化不必所有位置都 赋值1
     * 正确的初始化思路：应该是在i发现有障碍，i之后就没必要赋值了
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        int[][] dp = new int[rows][columns];
        // 错误初始化思路， 应该是在i发现有障碍，i之后就没必要赋值了
        //        for(int i=0; i<rows; i++) {
        //            if(obstacleGrid[i][0]==0) dp[i][0] = 1;
        //            else dp[i][0] = 0;
        //        }
        //        for(int j=0; j<columns; j++){
        //            if(obstacleGrid[0][j]==0) dp[0][j] = 1;
        //            else dp[0][j] = 0;
        //        }

        // 在i发现有障碍，i之后就没必要赋值了
        for(int i=0; i<rows && obstacleGrid[i][0]==0; i++) dp[i][0] = 1;
        for(int j=0; j<columns && obstacleGrid[0][j]==0; j++) dp[0][j] = 1;
        for(int i=1; i<rows; i++){
            for(int j=1; j<columns; j++){
                if(obstacleGrid[i][j]==0) dp[i][j] = dp[i-1][j] + dp[i][j-1];
                else  dp[i][j] = 0;
            }
        }
        return dp[rows-1][columns-1];
    }
}
