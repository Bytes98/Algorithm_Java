package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最大二叉树
 *https://leetcode-cn.com/problems/maximum-binary-tree/
 * 2022 04 27
 */
public class ConstructMaximumBinaryTree {

    /**
     * 注意保持左闭右开
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length==0) return null;
        List<Integer> list = findMax(nums);
        int maxValueIndex = list.get(0);
        TreeNode root = new TreeNode(list.get(1));

        //左闭右开
        int leftTree[] = Arrays.copyOfRange(nums, 0, maxValueIndex);
        int rightTree[] = Arrays.copyOfRange(nums, maxValueIndex+1, nums.length);

        root.left = constructMaximumBinaryTree(leftTree);
        root.right = constructMaximumBinaryTree(rightTree);

        return root;
    }

    List<Integer> findMax(int[] nums){
        List<Integer> list = new ArrayList<>();
        int maxValue = Integer.MIN_VALUE;
        int maxValueIndex =-1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>maxValue){
                maxValue = nums[i];
                maxValueIndex = i;
            }
        }
        list.add(maxValueIndex);
        list.add(maxValue);
        return list;
    }
}
