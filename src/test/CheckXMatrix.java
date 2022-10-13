package test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/07/01/20:24
 * @Description:
 * 判断矩阵是否是一个 X 矩阵
 * https://leetcode.cn/problems/check-if-matrix-is-x-matrix/
 */
public class CheckXMatrix {

    public boolean checkXMatrix(int[][] grid) {
        boolean ans = true;
        int gridLength = grid.length;
        for (int i = 0; i < gridLength; i++) {
            for(int j=0; j<gridLength; j++){
                if(i==j || i+j== gridLength-1){
                    if(grid[i][j]==0) return false;
                }else {
                    if(grid[i][j]!=0) return false;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args){

    }
}
