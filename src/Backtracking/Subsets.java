package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * https://leetcode-cn.com/problems/subsets/
 * 2022 05 04
 */
public class Subsets {

    /**
     * 两个细节
     * 1、List<List<Integer>> 。add (new ArrayList(tempSub);)
     * 2、子集问题，跟组合问题的不同之处在于：
     * 组合问题在叶子节点出save,  递归终止条件save
     * 子集问题, 所有节点都要：
     *      两种办法：
     *          1、 先单独存放result.add(new ArrayList<>()); // 单独将result放入 []
     *             然后，处理节点的时候，紧接加上
     *          2、先放在， 也就是在判断递归结束前
     *
     *
     */
//    输入：nums = [1,2]
//    输出：[[],[1],[2],[1,2]]
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        result.clear();
        result.add(new ArrayList<>()); // 单独将result放入 []
        backtracking(nums,0);
        return result;
    }

    List<Integer> tempSub = new ArrayList<>();
    void backtracking (int[] nums, int startIndex){
        if(startIndex==nums.length){
//            result.add(tempSub);
            return;
        }
        for(int i = startIndex; i<nums.length; i++){
            tempSub.add(nums[i]);
            result.add(new ArrayList(tempSub));
            backtracking(nums,i+1);
            tempSub.remove(tempSub.size()-1);
        }

    }




    /**
     * void backtracking (){
     *     if(stop condition){
     *         save
     *         return;
     *     }
     *     for(当前层集合){
     *         处理（判断剪枝）
     *         backtracking();
     *         回溯
     *     }
     * }
     */
}

class Subsets2{

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        result.clear();
        backtracking(nums,0);
        return result;
    }

    List<Integer> tempSub = new ArrayList<>();
    void backtracking (int[] nums, int startIndex){
        result.add(new ArrayList(tempSub));
        if(startIndex==nums.length){
            return;
        }
        for(int i = startIndex; i<nums.length; i++){
            tempSub.add(nums[i]);
            backtracking(nums,i+1);
            tempSub.remove(tempSub.size()-1);
        }
    }
}
