package Tree.BST;

import Tree.BinaryTree;
import Tree.Traversal.LevelTraversal;
import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *  修剪二叉搜索树
 *  https://leetcode-cn.com/problems/trim-a-binary-search-tree/
 *  2022 04 29
 */
public class TrimBST {
    /**
     * 修减后，使得所有节点的值在 [low, high]
     * 步骤 1、if(root==null) return  root;
     * 步骤 2、不符合条件 -> 处理 (root.val < low) (root.val > high)
     * 步骤 3、符合条件 -> 递归左右子树，让左右满足条件
     * 步骤 4、此时返回的 满足条件的root
     * @param root
     * @param low
     * @param high
     * @return
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null) return  root;
        // low<= root<= high 不做删除处理
        // root < low
        // root > high
        if(root.val < low){
            // 删除0节点的操作
            // 0节点的左子树都小，return 0节点的右子树 就可以了
            // 但是右子树可能还要修减，所以还要继续递归（trimBST(root.right, low, high) 而不是直接root.right
            // 相当于删除了0和2的关联
            return trimBST(root.right, low, high);
        }else if(root.val > high){
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high); // root（3）时， 递归修剪后的trimBST ， 相当于删除3和0的关联， 新建了3和2的关联
        root.right = trimBST(root.right, low, high);

        return root; // 返回修剪后的节点
    }


    /**
     * root= 3
     *  跳过 (root==null)  (root.val < low)  (root.val > high)
     *  root.left = trimBST(root.left, low, high);  修剪左子树，递归 root.left ，
     *  root.right = trimBST(root.right, low, high); 修剪右子树，递归 root.right
     *  最后 返回root 返回修剪后的节点
     */

    /**
     * root = 0
     * 跳过 (root==null)
     * 处理 (root.val < low) {
     *     root.val < low， 隐含着左子树都小于root， 也就是root.left也是小于low,也是要删的
     *     留下 root.right， 但是需要继续修剪右子树，因为右子树可能存在不符条件的节点。
     *     root = 递归修剪（root.right） 或者 return 递归修剪（root.right）
     *     区别在于：前者递归（root.right）后,返回值可能为空，也就是后面修剪root没有left right,
     *     也就是需要多判断一步root!=null，而且好像存在重复操作
     *     后者， 不妨 root = 递归后， 直接return root； 后面处理符合条件等操作，直接截断。
     *     【return 递归】 是 【root = 递归； return root；】 的精简版
     *
     * }
     * 跳过没有意义的操作 (root.val > high)
     * 修剪左子树，递归 root.left、 修剪右子树，递归 root.right
     * 最后 返回root 返回修剪后的节点
     *
     */




    public static void main (String[] args){
        BinaryTree binaryTree = new BinaryTree();
        LevelTraversal levelTraversal = new LevelTraversal();
        TrimBST trimBST = new TrimBST();

//        String string = "[9,-42,-42,null,76,76,null,null,13,null,13]";
        String string = "[1,0,2]";
        List<Integer> rootArray= new ArrayList<>();
        binaryTree.createArrayList(string,rootArray);
        binaryTree.showList(rootArray);

        TreeNode root = binaryTree.createTreeNode(rootArray,1);
        // 按层次遍历输出
        binaryTree.showList2(levelTraversal.Traversal(root));

        TreeNode delRoot = trimBST.trimBST(root,1,2);
        // 按层次遍历输出
        binaryTree.showList2(levelTraversal.Traversal(delRoot));

    }

}
