package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和 III
 * https://leetcode-cn.com/problems/combination-sum-iii/
 * 2022 05 01
 */
public class CombinationSum3 {

    /**
     * 回溯模板：
     * void backtracking(参数){
     *     if(终止条件){
     *         存放结果；
     *         return;
     *     }
     *     for(选择：本层集合中元素（树中结点孩子的数量就是集合的大小）){
     *         处理结点；
     *         backtracking(路径，选择列表)； //递归
     *         回溯，撤销处理
     *     }
     * }
     * @param k
     * @param n
     * @return
     */

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        result.clear();
        path.clear();
//        backtrackingSimple(k,n,1);
        backtrackingSimpleByPruningOptimization(k,n,1,0);
        return result;
    }


    void backtrackingSimple(int k, int n, int startIndex){
        if(path.size()==k){
            int sum = 0;
            for(Integer num: path){
                sum += num;
            }
            if(sum==n) result.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex; i<=9; i++){
            path.add(i);
            backtrackingSimple(k,n,i+1);
            path.removeLast();
        }
    }


    void backtrackingSimpleByPruningOptimization(int combinedSize, int targertSum, int startIndex,int sum){
        if(path.size()==combinedSize){
            if(sum==targertSum) result.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex; i<=9-(combinedSize-path.size())+1; i++){
            path.add(i);
            sum +=i;
            backtrackingSimpleByPruningOptimization(combinedSize,targertSum,i+1,sum);
            path.removeLast();
            sum -=i;
        }
    }

}
