package Tree.BST;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 删除二叉搜索树中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 * 2022 04 29
 */
public class deleteNodeBST {
    /**
     * 第一步，找节点
     *    if(root==null) return root;
     *    if(root.val==key){
     *        处理找了，也就是删除节点
     *    }else if(root.val<key){
     *        deleteNode(root.right, key);
     *    }else{
     *        deleteNode(root.left, key);
     *    }
     *    return root;
     * 第二步，找节点，如何删除节点node。
     * node.left==null && node.right==null -——> 左右孩子都为空（叶子节点），直接删除节点， 返回NULL为node
     * node.left==null && node.right!=null -——> 删除节点，right补位，返回right为node
     * node.left!=null && node.right==null -——> 删除节点，left补位，返回left为node
     * node.left!=null && node.right!=null -——> node.left 放在 node.right的最左面节点的left，返回node.right为新的node。
     * 二叉搜索树满足  node.left所有元素 < node < node.right所有元素
     * 现在删除node, 将node.left所有元素继续作为左子树， 去右子树中找新节点， 来满足node.left所有元素 < new node < new node.right所有元素
     * 比较好的方式是，node右子树的叶子节点直接插入， 而找哪个叶子节点？
     * 为了让新找得叶子点new node 满足node.left所有元素 < new node < new node.right所有元素。
     * 那么这个叶子节点应该是node.left所有元素里最小的， 也就是node.right的最左面节点
     * 而且为了保证node.left所有元素 < new node， 左子树应该插在new node的left上，
     * 最后删除节点node, 让node.right为新的根节点。
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
//        遇到空返回，其实这也说明没找到删除的节点，遍历到空节点直接返回了
        if(root==null) return root;
//        找到删除的节点:
        if(root.val==key){
            // 第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
            if(root.left==null && root.right==null) return null;
            // 第三种情况：删除节点的左孩子为空，右孩子不为空，删除节点，右孩子补位，返回右孩子为根节点
            else if(root.left==null) return root.right; // (root.left==null && root.right!=null)
            // 第四种情况：删除节点的右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
            else if(root.right==null) return root.left; // (root.left!=null && root.right==null)
            // 第五种情况：左右孩子节点都不为空，则将删除节点node的left放到node的right的最左面节点的左孩子上，
            // 返回删除节点右孩子为新的根节点。
            else{ // (root.left!=null && root.right!=null)
                TreeNode cur = root.right; // 删除节点的right
                while (cur.left != null) { //找删除节点的right的最左面节点
                    cur = cur.left;
                }
                cur.left = root.left; // 删除节点的左子树 ->  找右子树的最左面节点.left上
                root = root.right; // 删除节点node, 让node.right为新的根节点。
                return root;
            }
        }

        if (root.val > key) root.left = deleteNode(root.left, key);
        if (root.val < key) root.right = deleteNode(root.right, key);
        return root;

    }


}
