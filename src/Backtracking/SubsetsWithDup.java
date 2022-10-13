package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集 II
 * https://leetcode-cn.com/problems/subsets-ii/
 * 2022 05 04
 */
public class SubsetsWithDup {
//    nums = [1,2,2]
//    输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
    /**
     *  nums = [1,2,2]
     *  1     2      2  [1] | [2] | [2]
     * 2 2   2         [1 2] [1 2] | [2 2]
     * 2              [1 2 2]
     * Subsets。java 的基础上，
     * 去重方法一： 保存所有子集前，先判断是否contains
     *
     * 这里就有个小细节：
     * 1、需要一开始就排序，Arrays.sort(nums);
     * 2、在判断是否contains前，也需要new ArrayList(tempSub)；
     *
     * 去重方法二：在处理节点前，先判断去重，  细节也是，需要一开始就排序，Arrays.sort(nums);
     * if (i > startIndex && nums[i] == nums[i - 1] ) {
     * 	continue;
     * }
     */
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result.clear();
        tempSub.clear();
        backtracking(nums,0);
        return result;
    }

    List<Integer> tempSub = new ArrayList<>();
    void backtracking(int[] nums, int startIndex){
        if(!result.contains(new ArrayList(tempSub)))
            result.add(new ArrayList(tempSub));
        if(startIndex == nums.length){
            return;
        }
        for(int i=startIndex; i<nums.length; i++){
            tempSub.add(nums[i]);
            backtracking(nums,i+1);
            tempSub.remove(tempSub.size()-1);
        }
    }



    void backtracking2(int[] nums, int startIndex){
         result.add(new ArrayList(tempSub));
         if(startIndex == nums.length){
             return;
         }
        for(int i=startIndex; i<nums.length; i++){
            // 跳过当前树层使用过的、相同的元素
            if ( i > startIndex && nums[i - 1] == nums[i] ) {
                continue;
            }
            tempSub.add(nums[i]);
            backtracking2(nums,i+1);
            tempSub.remove(tempSub.size()-1);
        }
    }

}
