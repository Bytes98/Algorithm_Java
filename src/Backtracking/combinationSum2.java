package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和 II
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * 2022 05 02
 */

public class combinationSum2 {
    /**
     * CombinationSum。java不同在于
     * 去重的是“同一树层上的使用过”， 要对同一树层使用过的元素进行跳过
     */
    List<List<Integer>> combinationSum2Result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        combinationSum2Result.clear();
        // 首先把给candidates排序，让其相同的元素都挨在一起。
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0);
        return combinationSum2Result;
    }

    List<Integer> subList = new ArrayList<>();
    void backtracking(int[] candidates, int target, int subListSum, int startIndex){
        if(subListSum==target){
            combinationSum2Result.add(new ArrayList<>(subList));
            return;
        }

        for(int i = startIndex; i<candidates.length && subListSum+candidates[i]<=target; i++){
            // 要对同一树层使用过的元素进行跳过
            // i > startIndex 同一层中的其他元素，candidates[i] == candidates[i - 1] 元素相同
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            subList.add(candidates[i]);
            backtracking(candidates, target, subListSum+candidates[i], i+1); // i+1，去重重复的
            subList.remove(subList.size()-1);
        }
        /**
         *  去重1， backtracking(candidates, target, subListSum+candidates[i], i+1); 中的i+1，去重重复的
         *      （a,b,c） 意味着（a,b） (a,c) (b,c)
         *      如果backtracking(。。。，i) 的话，意味着， （a,a）, (a,b),(a,c), (b,b),(b,c),(c,c)
         *  去重2，if (i > startIndex && candidates[i] == candidates[i - 1])    同一树层使用过的元素进行跳过
         *      （a,a,c）,意味着(a,c)
         *      如果不这样判断， 意味着(a,c) (a,c)
         */
    }
}
