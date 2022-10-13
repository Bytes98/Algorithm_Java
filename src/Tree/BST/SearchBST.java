package Tree.BST;

import Tree.BinaryTree;
import Tree.Traversal.LevelTraversal;
import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉搜索树中的搜索
 * 2022 04 28
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 */
public class SearchBST {


    /**
     * 递归 + 利用搜索树的性质， 节点的左子树的所有元素 < 节点 < 节点的右子树的所有元素，
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBSTByRecursion(TreeNode root, int val){
        if(root==null || root.val==val) return root;
        if (val < root.val) return searchBSTByRecursion(root.left, val);
        if (val >root.val) return searchBSTByRecursion(root.right, val);
        return null;
    }

    /**
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBSTByIteration(TreeNode root, int val){
//        if(root==null) return null;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while(!queue.isEmpty()){
//            TreeNode node = queue.poll();
//            if(node.val == val){
//                return node;
//            } else if(node.left!=null && node.val>val) {
//                queue.offer(node.left);
//            } else if(node.right!=null && node.val<val){
//                queue.offer(node.right);
//            }
//        }

//        再精简
        TreeNode node = root;
        while(node!=null){
            // System.out.println(node.val);
            if(node.val == val) return node;
            else if(val<node.val) node = node.left; // 结合while(node!=null) 这里不能多判断node.left!=null
            else if(val>node.val) node = node.right;
        }
        return null;
    }

    /**
     * 仅仅遍历节点遍历节点， 层次遍历节点
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBSTByLevel(TreeNode root, int val) {
        if(root==null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(node.val==val) return node;

            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);
        }
        return null;
    }

    public static void main(String[] args){

        BinaryTree binaryTree = new BinaryTree();
        LevelTraversal levelTraversal = new LevelTraversal();
        SearchBST searchBST = new SearchBST();

        String string = "[4,2,7,1,3]";
        List<Integer> rootArray = new ArrayList<>();
        binaryTree.createArrayList(string, rootArray);
        System.out.println(rootArray);
        TreeNode root = binaryTree.createTreeNode(rootArray, 1);
        binaryTree.showList2(levelTraversal.Traversal(root));

        TreeNode reusltRoot =searchBST.searchBSTByIteration(root,2);
        binaryTree.showList2(levelTraversal.Traversal(reusltRoot));

    }
}
