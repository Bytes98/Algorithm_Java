package Backtracking;

import java.util.*;

/**
 * 递增子序列
 * https://leetcode-cn.com/problems/increasing-subsequences/
 * 2022 05 04
 */
public class FindSubsequences {
    /**
     * 题意： 可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
     * 去重当前层的思路有两个：
     *      一个是类似 combinationSum2.java
     *      另一个：
     */
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        result.clear();
        backtracking(nums,0);
        return result;
    }

    LinkedList<Integer> tempSub = new LinkedList<>();
    void backtracking(int[] nums, int startIndex){
        if(tempSub.size()>1 ){
            result.add( new ArrayList<>(tempSub) );
            // 注意这里不要加return，要取树上的节点
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=startIndex; i<nums.length; i++){
            /*  */
            if(!tempSub.isEmpty() && nums[i]< tempSub.getLast()){
                continue;
            }
            // 使用过了当前数字
            if ( map.getOrDefault( nums[i],0 ) >=1 ){
                continue;
            }
            map.put(nums[i],map.getOrDefault( nums[i],0 )+1);
            /*      */
            
            tempSub.add(nums[i]);
//     my       if(tempSub.size()>1 && tempSub.get(i)<tempSub.get(i-1)){
//                continue;
//            }
//      my      if(tempSub.size()>1) result.add(new ArrayList(tempSub));
            backtracking(nums, i+1);
            tempSub.remove(tempSub.size()-1);
        }
    }
}
