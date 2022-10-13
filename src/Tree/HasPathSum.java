package Tree;

import Tree.Traversal.LevelTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 路径总和
 * 判断该树中是否存在 根节点到叶子节点的路径总和 与 targetSum 相等
 * https://leetcode-cn.com/problems/path-sum/
 * 2022 04 27
 */
public class HasPathSum {
    /**
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSumHelper(TreeNode root, int targetSum) {
        if(root==null) return false;
        Queue<Object> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root.val);
        while(!queue.isEmpty()){
            TreeNode node = (TreeNode) queue.poll();
            int pathSum = (int)queue.poll();

            if(node.left==null && node.right==null && pathSum==targetSum) return true;

            if(node.right!=null){
                queue.offer(node.right);
                queue.offer(pathSum + node.right.val);
            }
            if(node.left!=null){
                queue.offer(node.left);
                queue.offer(pathSum + node.left.val);
            }
        }

        return false;
    }

    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        LevelTraversal levelTraversal = new LevelTraversal();
        HasPathSum hasPathSum = new HasPathSum();

//        String string1= "[5,4,8,11,null,13,4,7,2,null,null,null,null,null,1]";
//        String string ="[]";
        String string = "[5,4,8,11,null,13,4,7,2,null,null,5,1]";
        List<Integer> rootArray= new ArrayList<>();
//        System.out.println(string.length());
        binaryTree.createArrayList(string,rootArray);
//        System.out.println(rootArray);
        TreeNode root = binaryTree.createTreeNode(rootArray,1);
        binaryTree.showList2(levelTraversal.Traversal(root));


        System.out.println(hasPathSum.hasPathSumHelper(root,22));
    }

}
