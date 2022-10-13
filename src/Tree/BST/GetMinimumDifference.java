package Tree.BST;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *二叉搜索树的最小绝对差
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * 2022 04 28
 */
public class GetMinimumDifference {
    List<Integer> rootList = new ArrayList<>();
    public void inorderTraversalByRecursion(TreeNode node){
        if(node==null) return;
        inorderTraversalByRecursion(node.left);
        rootList.add(node.val);
        inorderTraversalByRecursion(node.right);
    }

    public int getMinimumDifference(TreeNode root) {
        rootList.clear();
        inorderTraversalByRecursion(root);
        int minValue = Integer.MAX_VALUE;
        for(int i=0; i<rootList.size()-1; i++){
            minValue = Math.min(minValue, Math.abs(rootList.get(i)-rootList.get(i+1)));
        }
        return minValue;
    }
}
