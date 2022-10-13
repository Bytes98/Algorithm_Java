package Backtracking;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/08/9:21
 * @Description:
 * 解数独
 * https://leetcode-cn.com/problems/sudoku-solver/
 */
public class SolveSudoku {
    /**
     * 1、不能用一维数组遍历
     * N皇后问题 是因为每一行每一列只放一个皇后，只需要一层for循环遍历一行，递归来来遍历列，然后一行一列确定皇后的唯一位置。
     * 本题就不一样了，本题中棋盘的每一个位置都要放一个数字，并检查数字是否合法，解数独的树形结构要比N皇后更宽更深。
     * 2、boolean backtracking（）{
     *      for(遍历行，index，currentRow)
     *       for(遍历列，index，currentColumn)
     *         if(遇到非‘。’) continue; // 跳过原始数字
     *         for(遍历数字一到九) if(backtracking（）) return true;
     *         return false; 所有数字都遍历完了，说明9个数都试完了，都不行，false;
     *
     *     return true
     * }
     * @param board
     */
    public void solveSudoku(char[][] board) {
//        int blankNums = 0;
//        int column = board.length;
//        for (char[] chars : board) {
//            for (int j = 0; j < column; j++) {
//                if (chars[j] == '.') blankNums++;
//            }
//        }
        backtracking(board);
    }

    /**
     *        System.out.println((char)9);  //  什么都没有， 并没有返回9
     *         System.out.println((char)97);// a
     *         System.out.println((char)48);// 0
     *         System.out.println((char)(9 + 48));// 9
     * @param board
     */
    boolean backtracking(char[][] board){
        //「一个for循环遍历棋盘的行，一个for循环遍历棋盘的列，
        // 一行一列确定下来之后，递归遍历这个位置放9个数字的可能性！」
        for (int i = 0; i < 9; i++){ // 遍历行
            for (int j = 0; j < 9; j++){ // 遍历列
                if (board[i][j] != '.'){ // 跳过原始数字
                    continue;
                }
                for (char k = '1'; k <= '9'; k++){ // (i, j) 这个位置放k是否合适
                    if (isValid(board, i, j, k)){
                        board[i][j] = k;
                        if (backtracking(board)){ // 如果找到合适一组立刻返回
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                // 9个数都试完了，都不行，那么就返回false
                return false;
                // 因为如果一行一列确定下来了，这里尝试了9个数都不行，说明这个棋盘找不到解决数独问题的解！
                // 那么会直接返回， 「这也就是为什么没有终止条件也不会永远填不满棋盘而无限递归下去！」
            }
        }
        // 遍历完没有返回false，说明找到了合适棋盘位置了
        return true;
    }

    //数字 1-9 在每一行只能出现一次。
    //数字 1-9 在每一列只能出现一次。
    //数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
    boolean isValid(char[][] board, int currentRow, int currentColumn, char currentNumberChar){

        //数字 1-9 在每一行只能出现一次。
        for(int i=0; i<board.length; i++){
            if(board[currentRow][i]==currentNumberChar) return false;
        }

        //数字 1-9 在每一列只能出现一次。
        for(int i=0; i<board.length; i++){
            if(board[i][currentColumn]==currentNumberChar) return false;
        }

        //数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
        // (0,0) (0,1) (0,2)     (0,3) (0,4) (0,5)     (0,6) (0,7) (0,8)
        // (1,0) (1,1) (1,2)     (1,3) (1,4) (1,5)     (1,6) (1,7) (1,8)
        // (2,0) (2,1) (2,2)     (2,3) (2,4) (2,5)     (2,6) (2,7) (2,8)
        //
        // (3,0) (3,1) (3,2)     (3,3) (3,4) (3,5)     (3,6) (3,7) (3,8)
        // (4,0) (4,1) (4,2)     (4,3) (4,4) (4,5)     (4,6) (4,7) (4,8)
        // (5,0) (5,1) (5,2)     (5,3) (5,4) (5,5)     (5,6) (5,7) (5,8)
        int startRow = (currentRow / 3) * 3;
        int startColumn = (currentColumn / 3) * 3;
        for(int i=startRow; i<startRow+3; i++){
            for (int j=startColumn; j<startColumn+3;j++){
                if(board[i][j]==currentNumberChar) return false;
            }
        }

        return true;
    }
}
