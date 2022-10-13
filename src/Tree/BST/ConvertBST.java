package Tree.BST;

import Tree.BinaryTree;
import Tree.Traversal.LevelTraversal;
import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 把二叉搜索树转换为累加树
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * 2022 04 29
 */
public class ConvertBST {
    //二叉 搜索 树, 节点值各不相同
    // 每个节点 node 的新值等于原树中大于或等于 node.val 的值之和
    // OldRoot = 7, 原树中比7大的node.val有8， 更新后 root = OldRoot +8;
    // OldRoot = 6, 原树中比6大的node.val有7,8 更新后 root = OldRoot +7+8;
    // OldRoot = 5, 原树中比5大的node.val有6,7,8 更新后 root = OldRoot + 6+7+8;
//    [5, 6, 7, 8] = [5, 6 ,7+8, 8] = [5, 6+7+8, 7+8, 8] = [5+6+7+8, 6+7+8, 7+8, 8]

    // 右中左来遍历二叉树
    int preValue;
    void travesal(TreeNode node){
        if(node==null) return;
        travesal(node.right);
        node.val += preValue;
        preValue = node.val;
        travesal(node.left);
    }

    public TreeNode convertBST(TreeNode root) {
        if(root==null) return root;
        preValue = 0;
        travesal(root);
        return root;
    }



    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        LevelTraversal levelTraversal = new LevelTraversal();
        ConvertBST convertBST = new ConvertBST();

//        String string = "[1,2,3,4,null,5,6,null,null,null,null,7]";
        String string = "[7,null,8]";
        List<Integer> rootArray = new ArrayList<>();
        binaryTree.createArrayList(string, rootArray);
        System.out.println(rootArray);
        TreeNode root = binaryTree.createTreeNode(rootArray, 1);
        binaryTree.showList2(levelTraversal.Traversal(root));

//        System.out.println();
        binaryTree.showList2(levelTraversal.Traversal(convertBST.convertBST(root)));
    }
}
