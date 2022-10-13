package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 * 2022 05 02
 */
public class CombinationSum {
    /**
     * void backtracking(参数){
     *     if(递归终止条件)  return;
     *
     *     if（回溯的终止条件）{
     *         存放结果
     *         return;
     *     }
     *     for(遍历当前递归层子集元素){
     *         处理节点；
     *         递归；
     *         回溯；
     *     }
     * }
     * @param candidates
     * @param target
     * @return
     */
    // "无重复元素"的整数数组 candidates
    // 数字和为目标数 target 的 所有 不统组合
    // "同一个数字"可以"无限制重复"被选取
    List<List<Integer>> combinationSumResult = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSumResult.clear();
        backtracking(candidates, target,0,0);
        return combinationSumResult;
    }

    List<Integer> subList = new ArrayList<>();
    void backtracking(int[] candidates, int target,int sumListSum,int startIndex){
        if(sumListSum>target){
            return;
        }

        if(sumListSum== target){
            combinationSumResult.add(subList);
            return;
        }

        for(int i= startIndex; i<candidates.length; i++){
            subList.add(candidates[i]);
            sumListSum += candidates[i];
            backtracking(candidates,target,sumListSum,i); // 不用i+1了，表示可以重复读取当前的数
            subList.remove(subList.size()-1);
            sumListSum -= candidates[i];
        }
    }

}


class CombinationSumByPruningOptimization{
    /**
     *  关键的一步，Arrays.sort(candidates); // 先进行排序  !!!!
     *  然后将递归终止条件放在for循环中，提前判断， 就不用递归。 否则原来递归再判断终止递归， 那么原来就多了递归的花费。
     *  而此时（递归终止条件放在for循环中）， 先排序，这很重要！！！！！！！
     */
    List<List<Integer>> combinationSumResult = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSumResult.clear();
        subList.clear();
        Arrays.sort(candidates); // 先进行排序  !!!!
        backtracking(candidates, target,0,0);
        return combinationSumResult;
    }

    List<Integer> subList = new ArrayList<>();
    void backtracking(int[] candidates, int target,int subListSum, int startIndex){

        if(subListSum== target){
            combinationSumResult.add(new ArrayList(subList));
            return;
        }

        for(int i= startIndex; i<candidates.length; i++){
            if (subListSum + candidates[i] > target) break;
            subList.add(candidates[i]);
            backtracking(candidates,target,subListSum + candidates[i],i);
            subList.remove(subList.size()-1);
        }
    }
}
