package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原 IP 地址
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 * 2022 05 03
 */
public class RestoreIpAddresses {

    /**
     * 1、易错点： subString.substring(startIndex,end);  必须要赋值给某个变量，
     *  String tempSub = subString.substring(startIndex,end);
     *
     *  2、 因为是插点操作， 直接在字符串上插
     *  string = string.substring(0, i + 1) + "." + string.substring(i + 1);
     *
     *  3、 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
     * //    主要考虑到如下三点：
     * //
     * //    段位以0为开头的数字不合法。 单独一个0是可以的， 如0.0.0.0
     * //    段位里有非正整数字符不合法
     * //    段位如果大于255了不合法
     *
     */
    static List<String> result = new ArrayList<>();
    public static List<String> restoreIpAddresses(String s) {
        if (s.length() > 12 || s.length()<4) return result;
        result.clear();
        backtracking(s,0,0);
        return result;
    }

    // startIndex: 搜索的起始位置， pointNum:添加逗点的数量
    static void backtracking(String string, int startIndex, int pointNum){
        if (pointNum == 3) {// 逗点数量为3时，分隔结束
            // 判断第四段⼦字符串是否合法，如果合法就放进result中
            if (isValid(string,startIndex,string.length()-1)) {
                result.add(string);
            }
            return;
        }

        for (int i = startIndex; i < string.length(); i++) {
            if (isValid(string, startIndex, i)) {
                // string = "1234"
                // i=0, string = "1" + "." + "234" = "1.234"
                string = string.substring(0, i + 1) + "." + string.substring(i + 1); //在index=i的后⾯位置上插⼊⼀个逗点
                pointNum++;
                // string = "1.234"
                // startIndex 应该从"2" 开始， 也就是 i+2
                backtracking(string, i + 2, pointNum);// 插⼊逗点之后下⼀个⼦串的起始位置为i+2
                pointNum--;// 回溯
                // string = "1.234"
                // i=0, string = "1" + "234" = "1234"
                string = string.substring(0, i + 1) + string.substring(i + 2); // 回溯删掉逗点
            } else {
                break;
            }
        }
    }

    // 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
//    主要考虑到如下三点：
//
//    段位以0为开头的数字不合法
//    段位里有非正整数字符不合法
//    段位如果大于255了不合法
    private static Boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        System.out.println(restoreIpAddresses("1234"));

    }
}
