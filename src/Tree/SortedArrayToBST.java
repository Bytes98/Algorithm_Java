package Tree;

import java.util.Arrays;

/**
 *  将有序数组转换为二叉搜索树
 *  https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 *  2022 04 29
 */

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        int rootIndex = nums.length/2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        // 左闭右开 [ )
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,rootIndex));
        // 左闭右开 [ )
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums,rootIndex+1,nums.length));
        return root;
    }
}
