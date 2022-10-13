package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * 2022 05 03
 */
public class Partition {
    /**
     * 1、判断回文： 一是常规， 而是双指针
     *
     * 2、对于同一层，如何分割子串tempSub？
     *  startIndex表示某一层开始的位置。
     *  tempSub = 原字符串[startIndex,i] = String.substring(startIndex,i+1)
     *
     * 第一层 = 原字符串 =“aab”  index=[0,1,2]  原字符串为左区分，aa -> aA ,A视为a
     * 第2层 = startIndex=0 i=0,1,2    截取 “a”     | 截取  "aA"  |  截取 "aAb"
     * 第3层 = startIndex=1 i=1,2  截取“A”  截取"Ab" | 截取 "b"
     * 第4层 = startIndex=2 i=2    截取“b”
     */
    /**
     * void backtracking(参数){
     *     if(终止条件){
     *         save（sub）;
     *         return;
     *     }
     *     for(遍历当前递归层的集合){
     *         （提前判断，减枝）
     *         处理节点
     *         backtracking;
     *         回溯
     *     }
     * }
     * @param s
     * @return
     */

    static List<List<String>> partitionResult = new ArrayList<>();
    static public List<List<String>> partition(String s) {
        partitionResult.clear();
        backtracking(s,0);
        return partitionResult;
    }

    static List<String> subStrList = new ArrayList<>();
    static void backtracking(String string, int startIndex){
        if(startIndex>=string.length()){
            partitionResult.add(new ArrayList<>(subStrList));
            return;
        }
        for(int i=startIndex; i<string.length();i++){
            // tempSub = [startIndex,i] = String.substring(startIndex,i+1)
            String tempSub = string.substring(startIndex,i+1); // substring(闭，开)
            if(!isPalindrome(tempSub)) continue;
            subStrList.add(tempSub);
            backtracking(string,i+1);
            subStrList.remove(subStrList.size()-1);
        }
    }

    //常规方法判断回文
    static boolean isPalindrome(String str){
        int strLength = str.length();
        for(int i=0;i<strLength/2;i++){
            if(str.charAt(i)!=str.charAt(strLength-1-i)) return false;
        }
        return true;
    }

    // 通过双指针
    boolean isPalindrome2(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
//        String[] strings = {"a","ab","aa","aba","abc","abbc","abba"};
//        for(String str:strings){
//            System.out.println(str + " "+ isPalindrome(str));
//        }
        System.out.println(partition("aab"));

    }
}
