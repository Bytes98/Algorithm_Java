package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/06/9:28
 * @Description:
 * 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 *
 *  给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *
 */
public class PermuteUnique {
    /**
     * 跟Permute.java类似， 多个在result上去重，去除重复的subList
     * 注意，因为所给数组包含重复元素，所以不能用Permute.java的思路3
     *
     * way1 Permute.java思路二标记法作为基础， 用一个数组标记是否使用过，
     * 注意标记也要回溯
     * 然后就是在保存结果时，对result去重，去除重复的subList
     *
     * way2 ， 更优 ，优化剪枝，
     * 与way1不同， wag1是在保存结果时判断的。way2则不需要保存结果时判断，而是直接处理节点出进行剪枝。
     * if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
     *     continue;
     * }
     * 也就是 类似combinationSum2.java 对同一层中元素去重，if (i > startIndex && candidates[i] == candidates[i - 1])
     * 但是不同的是多了一个判断，&& used[i - 1] == false
     *
     * 需要注意， 需要先排序！！！！
     *
     */
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        result.clear();
        subList.clear();
        used = new boolean[nums.length];
        backtracking(nums,0);
        return result;
    }

    List<Integer> subList = new ArrayList<>();
    boolean [] used;
    void backtracking(int[] nums, int startIndex){
        if(subList.size()==nums.length){
            if(!result.contains(subList))
                result.add(new ArrayList<>(subList));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if (used[i]) continue; // path里已经收录的元素，直接跳过
            used[i] = true;
            subList.add(nums[i]);
            backtracking(nums,i+1);
            subList.remove(subList.size()-1);
            used[i] = false;
        }
    }
}

class PermuteUnique2 {
    //存放结果
    List<List<Integer>> result = new ArrayList<>();
    //暂存结果
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backTrack(nums, used);
        return result;
    }

    private void backTrack(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            //如果同⼀树⽀nums[i]没使⽤过开始处理
            if (!used[i]) {
                used[i] = true;//标记同⼀树⽀nums[i]使⽤过，防止同一树枝重复使用
                path.add(nums[i]);
                backTrack(nums, used);
                path.remove(path.size() - 1);//回溯，说明同⼀树层nums[i]使⽤过，防止下一树层重复
                used[i] = false;//回溯
            }
        }
    }
}
