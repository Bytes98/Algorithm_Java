package Tree;

import Tree.Traversal.LevelTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * 2022 04 26
 */
public class IsBalanced {
    /**
     * 判断树的高度的基础上， 多一步判断，就是左右子树高度的差的绝对值是否为0或1,
     * 为了方便判断，可自定义为： 非平衡时树的高度为-1， 其他为平衡
     * @param root
     * @return
     */
    public boolean isBalancedHelper(TreeNode root) {
        return getDepthRecursion(root) == -1 ? false : true;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    int getDepthRecursion(TreeNode root){
        if(root==null) return 0;
        int leftDepth = getDepthRecursion(root.left);
        if(leftDepth==-1) return -1; // 说明已经不平衡了，也就不用继续判断， 直接返回-1；
        int rightDepth = getDepthRecursion(root.right);
        if(rightDepth==-1) return -1;
        int absAbsValueDiffOfDepth = Math.abs(leftDepth - rightDepth);
        int depth = Math.max(leftDepth,rightDepth) + 1;
        return absAbsValueDiffOfDepth<2 ? depth : -1;
    }




    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        IsBalanced isBalanced = new IsBalanced();
        LevelTraversal levelTraversal = new LevelTraversal();

//        String string = "[1,2,3,4,null,5,6,null,null,null,null,7]";
//        String string = "[1,2,2,3,3,null,null,4,4]";
        String string= "[3,9,20,null,null,15,7]";
//        String string = "[]";
        List<Integer> rootArray = new ArrayList<>();
        binaryTree.createArrayList(string, rootArray);
        System.out.println(rootArray);
        TreeNode root = binaryTree.createTreeNode(rootArray, 1);
        binaryTree.showList2(levelTraversal.Traversal(root));

        System.out.println(isBalanced.isBalancedHelper(root));

    }
}
