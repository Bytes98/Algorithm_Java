package Tree;

import Tree.Traversal.LevelTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/**
 * 另一棵树的子树 (找子树)
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 */
public class IsSubTree {

    // 遍历 + 判断树相等
    public boolean isSubTree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new LinkedList();
        if(root!=null) queue.offer(root); // 其实这题输入默认不为空了
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(isSameTreeHelper(node,subRoot)) return true;
            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);
        }
        return false;
    }

    //  计算树高 -> 减少（按层次）遍历次数->  遍历 + 判断树相等
    public boolean isSubTreePlus(TreeNode root, TreeNode subRoot) {
        int rootDepth = 0, subRootDepth = 0;
        if(root!=null) rootDepth = getDepth(root);
        if(subRoot!=null) subRootDepth = getDepth(subRoot);
        int iterationsOfDepth = rootDepth - subRootDepth + 1;
//        System.out.println(rootDepth+"-"+subRootDepth+"="+iterationsOfDepth);

        Queue<TreeNode> queue = new LinkedList();
        if(root!=null) queue.offer(root); // 其实这题输入默认不为空了
        while(!queue.isEmpty() && iterationsOfDepth-->0){
//            System.out.println(iterationsOfDepth);
            int queueSize = queue.size();
            for(int i=0;i<queueSize;i++){
                TreeNode node = queue.poll();
                if(isSameTreeHelper(node,subRoot)) return true;
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return false;
    }

    int getDepth(TreeNode root){
        int depth=0;
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            depth++;
            for(int i=0; i<queueSize; i++){
                TreeNode node = queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return depth;
    }

    Boolean isSameTreeHelper(TreeNode tree1, TreeNode tree2){
        Queue<TreeNode> queue = new LinkedList();
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
        IsSubTree isSubTree = new IsSubTree();
        LevelTraversal levelTraversal = new LevelTraversal();

//        String string1 = "[3,4,5,1,2,null,null,null,null,0]";
        String string1 = "[3,4,5,1,2]";
        List<Integer> rootArray1= new ArrayList<>();
        binaryTree.createArrayList(string1,rootArray1);
//        System.out.println(rootArray1);
        TreeNode root1 = binaryTree.createTreeNode(rootArray1,1);
        binaryTree.showList2(levelTraversal.Traversal(root1));

        String string2 = "[4,1,2]";
        List<Integer> rootArray2= new ArrayList<>();
        binaryTree.createArrayList(string2,rootArray2);
//        System.out.println(rootArray2);
        TreeNode root2 = binaryTree.createTreeNode(rootArray2,1);
        binaryTree.showList2(levelTraversal.Traversal(root2));

        System.out.println(isSubTree.getDepth(root1));
        System.out.println(isSubTree.getDepth(root2));

        System.out.println(isSubTree.isSubTreePlus(root1,root2));
    }
}
