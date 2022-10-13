package dynamicProgramming;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/18/12:13
 * @Description:
 * 礼物的最大价值
 * https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
public class MaxValue {
    public int maxValue(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0]=grid[0][0];
        for(int i=1; i<rows; i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for(int j=1; j<columns; j++){
            dp[0][j] = dp[0][j-1]+grid[0][j];
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        for(int i=1; i<rows; i++){
            for(int j=1; j<columns; j++){
                dp[i][j] = grid[i][j] + Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        for(int i=1; i<rows; i++){
            for(int j=1; j<columns; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[rows-1][columns-1];
    }

    public static void main(String[] args){
        int[][] grid = {{1,2,5},{3,2,1}};
        MaxValue maxValue = new MaxValue();
        System.out.println(maxValue.maxValue(grid));
    }
}
