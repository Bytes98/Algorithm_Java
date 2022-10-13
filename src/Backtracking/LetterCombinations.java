package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 */
public class LetterCombinations {
    /**
     * void backtracking(参数){
     *     if(终止条件){
     *         存放结果；
     *         return;
     *     }
     *     for(本层集合中元素（树中结点孩子的数量就是集合的大小）){
     *         处理结点；
     *         backtracking(路径，选择列表)；递归
     *         回溯，撤销处理
     *     }
     * }
     * @param digits
     * @return
     */
    //设置全局列表存储最后的结果
    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return list;
        }
        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        String[] digitsToLetter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //迭代处理
        backTracking(digits, digitsToLetter, 0);
        return list;

    }

    //每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuild
    StringBuilder temp = new StringBuilder();
    //比如digits如果为"23",digitsIndex 为0，则str表示2对应的 abc
    public void backTracking(String digits, String[] digitsToLetter, int digitsIndex) {
        //遍历全部一次记录一次得到的字符串
        if (digitsIndex == digits.length()) {
            list.add(temp.toString());
            return;
        }
        //str 表示当前num对应的字符串
        String str = digitsToLetter[digits.charAt(digitsIndex) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            //c
            backTracking(digits, digitsToLetter, digitsIndex + 1);
            //剔除末尾的继续尝试
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
