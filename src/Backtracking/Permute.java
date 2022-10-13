package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 全排列
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permute {
    /**
     * 思路1 restNums.add(i,tempN); // 关键，回溯的时候，是查回对应位置， 不指定index默认时插入到末尾，
     *      但是涉及到数组的插入， 时间 up up
     *
     * 思路2  int[] used
     * for(){
     *   if (used[i]){
     *      continue;
     *   }
     *   used[i] = true;
     * }
     *
     * 思路3 通过判断path中是否存在数字，排除已经选择的数字,跟思路二有点类似
     * // 如果path中已有，则跳过
     *             if (path.contains(nums[i])) {
     *                 continue;
     *             }
     */
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        result.clear();
        subArr.clear();
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
//        System.out.println(collect);
        backtracking(numsList, numsList.size());
//        backtracking2(nums,0);
        return result;
    }

    List<Integer> subArr = new ArrayList<>();
    void backtracking(List<Integer> restNums, int maxSetSize){
        if(subArr.size()==maxSetSize){
            result.add(new ArrayList<>(subArr));
            return;
        }

        for(int i=0; i<restNums.size(); i++){
            int tempN = restNums.get(i);
//            System.out.println(restNums+"-"+i+"-"+tempN);
            subArr.add(tempN);
            restNums.remove(i);
            backtracking(restNums, maxSetSize);
            restNums.add(i,tempN); // 关键，回溯的时候，是查回对应位置， 默认时插入到末尾
            subArr.remove(subArr.size()-1);
        }
    }

    List<Integer> subList = new ArrayList<>();
    void backtracking2(int[] nums, int startIndex){
        if(subList.size()==nums.length){
            result.add(new ArrayList<>(subList));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(subList.contains(nums[i])){
                continue;
            }
            subList.add(nums[i]);
            backtracking2(nums,i+1);
            subList.remove(subList.size()-1);
        }
    }

    public static void main(String[] args){
//        System.out.println(args);
        Permute permute = new Permute();
        int [] nums = {1,2,3};
        System.out.println(permute.permute(nums).toString());
    }
}
