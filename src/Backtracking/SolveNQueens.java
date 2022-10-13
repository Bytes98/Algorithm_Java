package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/07/9:50
 * @Description:
 */
public class SolveNQueens {
    /**
     *  List<List<String>> result = new ArrayList<>(); 不能加static
     *
     */
    // 首先来看一下皇后们的约束条件：
    // 不能同行
    // 不能同列
    // 不能同斜线
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backtracking(chessboard, n,0);
        return result;
    }


    void backtracking(char[][] chessboard, int n, int currentRow){
        if(currentRow == n){
            List<String> list = new ArrayList();
            for(int i=0; i<n; i++){ //  -> 还需要转成List<String>  like [".Q..","...Q","Q...","..Q."]
                String str = "";
                for(int j=0; j<n; j++){
                    str += chessboard[i][j];
                }
                list.add(str);
            }
            result.add(list);
            return;
        }
        for(int currentColumn=0; currentColumn<n; currentColumn++){
            if(currentRow<n && isValid(chessboard,currentRow,currentColumn,n)){
                chessboard[currentRow][currentColumn]='Q';
                backtracking(chessboard,n,currentRow+1);  //currentRow+1下一行，下一个皇后的位置
                chessboard[currentRow][currentColumn]='.';
            }
        }
    }


    boolean isValid(char[][] chessboard,int currentRow,int currentColumn,int n){
        // 检查列
        for(int i=0; i<currentRow; i++){  // 皇后是不同行的， 就判断，是否在同一列中。
            if(chessboard[i][currentColumn]=='Q'){ // 反过来，如果有皇后在同一列中,返回false
                return false;
            }
        }
        // 接下里需要判断 左上角的对角线， 右上角的对角线， 而左下和右下还没有存在皇后。
        // 判断左上的对角线有没有皇后
        // 从 i=currentRow-1, j=currentColumn-1 开始， chessboard[currentRow][currentColumn]代表本身这个皇后的位置
        // 没必要判断本身的位置，i=currentRow-1, j=currentColumn-1代表左上角的对角线上的第一个元素
        // i--,j--， 左上角的对角线上，下一个对角元素
        for(int i=currentRow-1, j=currentColumn-1; i>=0 && j>=0; i--,j--){
            if(chessboard[i][j]=='Q') return false; //排除
        }

        // 判断右上的对角线有没有皇后
        for(int i=currentRow-1,j=currentColumn+1; i>=0&&j<n; i--,j++){
            if(chessboard[i][j]=='Q') return false;
        }

        return true;
    }

    public static void main(String[] args){
        SolveNQueens solveNQueens = new SolveNQueens();
        int num = 4;
        List<List<String>> result = solveNQueens.solveNQueens(num);
        System.out.println(result);
    }

}
