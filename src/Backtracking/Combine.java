package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 组合
 * https://leetcode-cn.com/problems/combinations/submissions/
 * 2022 04 20
 */
public class Combine {
    //给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。你可以按 任何顺序 返回答案

    /**
     *
     * notes 存放结果的时候， 需要放入new ArrayList<>(path)， 直接放入path没用。
     * 完成回溯法后，可以进行剪枝优化
     * 如果for循环选择的起始位置之后的元素个数 已经不足 我们需要的元素个数了，那么就没有必要搜索了。
     * @param n
     * @param k
     * @return
     */
    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>(); // 用来存放符合条件单一结果
    public List<List<Integer>> combine(int n, int k) {
        result.clear();
        path.clear();
        backtrackingOfCombine(n, k, 1);
        return result;
    }

    void backtrackingOfCombine(int n, int k,int startIndex){
        if(path.size()==k){ // if(终止条件)
            result.add(new ArrayList<>(path)); // 存放结果;
            // result.add(path); // 存放不了结果;
            return; // return;
        }

        // for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）)
        for(int i=startIndex; i<=n; i++){
            path.add(i); //处理节点;
            backtrackingOfCombine(n, k, i+1);// backtracking(路径，选择列表); // 递归
            //    path.remove(path.size()-1);
            path.removeLast();  // 回溯，撤销处理结果;
        }
    }
    //进行剪枝优化
    //如果for循环选择的起始位置之后的元素个数 已经不足 我们需要的元素个数了，那么就没有必要搜索了。
    void backtrackingOfCombineByPruningOptimization(int n, int k, int startIndex){
        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        // k - path.size() 需要的元素个数
        // 元素的最大边界n，  题目要求[1,n]的数组，大小为k子集有多少
        // [startIndex, n - (k - path.size()) + 1] 可以保证不必要的搜索
        // 例如n=4,k=3
        // 对于第一个元素startIndex=1时，显然，在递归到第二个层（第二个元素）时，只有2 、3是符合的。
        // 如果是1,4，就没有别的元素可以够大小为k的子集了
        // n - (k - path.size()) + 1 = 4 - (3-1) + 1 = 3;
        for(int i = startIndex; i <= n - (k - path.size()) + 1; i++){
            path.add(i);
            backtrackingOfCombineByPruningOptimization(n,k,i+1);
            path.removeLast();
        }
    }

    public static void main(String[] args){
        Combine combine = new Combine();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        combine.combine(n,k);
    }
}
