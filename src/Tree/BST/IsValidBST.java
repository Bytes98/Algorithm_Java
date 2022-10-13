package Tree.BST;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 2022 04 28
 */
public class IsValidBST {
    /**
     *  利用的性质：二叉搜索树的中序遍历是(完全)递增序列
     *  rootList.get(i) < rootList.get(i+1) true;
     *  rootList.get(i) >= rootList.get(i+1) false;
     *  notes: >=  递增序列
     * @param root
     * @return
     */
    // 递归中序遍历
    List<Integer> rootList = new ArrayList<>();
    public void inorderTraversal(TreeNode root){
        if(root==null) return;
        inorderTraversal(root.left);
        rootList.add(root.val);
        inorderTraversal(root.right);
    }

    // 迭代中序遍历
    public void inorderTraversalIteration(TreeNode root){
        Stack<TreeNode> stack= new Stack<>();
        if(root!=null) stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node!=null){
                if(node.right!=null) stack.push(node.right);
                stack.push(node);
                stack.push(null);
                if(node.left!=null) stack.push(node.left);
            }else{
                node = stack.pop();
                rootList.add(node.val);
            }
        }

    }

    public boolean isValidBST(TreeNode root) {
        rootList.clear();
        inorderTraversal(root);
        for(int i=0; i<rootList.size()-1; i++){
            if(rootList.get(i)>=rootList.get(i+1)) return false;
        }
        return true;
    }
}
