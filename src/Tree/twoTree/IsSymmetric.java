package Tree.twoTree;

import Tree.BinaryTree;
import Tree.Traversal.LevelTraversal;
import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 2022 04 21
 */
public class IsSymmetric {

    // Queue Iteration
    public boolean isSymmetricHelper(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();

            // 左节点为空、右节点为空，此时说明是对称的???  node1(node2)的左右节点入队就没意义了(没后续可以入队了)，所以continue;
            if(leftNode==null && rightNode==null) continue;

            //  左右有一个节点为空，或者都不为空但数值不相同，返回false
            if(leftNode==null || rightNode==null || (leftNode.val!=rightNode.val)) return false;

            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        return true;
    }

    public static void main(String[] agrs){
        BinaryTree binaryTree = new BinaryTree();
        LevelTraversal levelTraversal = new LevelTraversal();
        IsSymmetric isSymmetric = new IsSymmetric();

//        String string = "[1,2,2,null,3,null,3]";
//        String string = "[1,2,2,3,4,4,3]";
        String string = "[9,-42,-42,null,76,76,null,null,13,null,13]";
        List<Integer> rootArray= new ArrayList<>();
        binaryTree.createArrayList(string,rootArray);
        binaryTree.showList(rootArray);

        TreeNode root = binaryTree.createTreeNode(rootArray,1);
        // 按层次遍历输出
        binaryTree.showList2(levelTraversal.Traversal(root));
        // 进行左右子节点翻转(递归)
        System.out.println(isSymmetric.isSymmetricHelper(root));


    }
}
