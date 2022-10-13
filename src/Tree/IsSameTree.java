package Tree;

import Tree.Traversal.LevelTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 */
public class IsSameTree {
    public Boolean IsSameTreeHelper(TreeNode tree1, TreeNode tree2){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree1);
        queue.offer(tree2);
        while(!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if(node1 == null && node2 == null) continue;
            if(node1 == null || node2 == null || node1.val != node2.val) return false;
            queue.offer(node1.left);
            queue.offer(node2.left);
            queue.offer(node1.right);
            queue.offer(node2.right);
        }
        return true;
    }
    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        IsSameTree IsSameTree = new IsSameTree();
        LevelTraversal levelTraversal = new LevelTraversal();

        String string1 = "[1,2,1]";
        List<Integer> rootArray1= new ArrayList<>();
        binaryTree.createArrayList(string1,rootArray1);
//        System.out.println(rootArray1);
        TreeNode root1 = binaryTree.createTreeNode(rootArray1,1);
        binaryTree.showList2(levelTraversal.Traversal(root1));

        String string2 = "[1,1,2]";
        List<Integer> rootArray2= new ArrayList<>();
        binaryTree.createArrayList(string2,rootArray2);
//        System.out.println(rootArray2);
        TreeNode root2 = binaryTree.createTreeNode(rootArray2,1);
        binaryTree.showList2(levelTraversal.Traversal(root2));

        System.out.println(IsSameTree.IsSameTreeHelper(root1,root2));



    }
}
