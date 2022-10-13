package Tree.BST;

import Tree.TreeNode;

/**
 * 二叉搜索树中的插入操作
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 * 2022 04 29
 */
public class InsertIntoBST {
    /**
     * BST 性质：all node in node.left < node < all node in node.right
     *      // 如果当前节点为空，也就意味着val找到了合适的位置，此时创建节点直接返回。
     *      // insertIntoBST()的返回值是新节点；node.right或者node.left = 返回值是新节点就是了
     *      if (node == null) return new TreeNode(target); 
     *      node < target   node应该插在右边， node.right  = insertIntoBST(root.right, target);
     *      node > target   node应该插在左边， node.left  = insertIntoBST(root.left, target);
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 如果当前节点为空，也就意味着val找到了合适的位置，此时创建节点直接返回。
        if (root == null)
            return new TreeNode(val);

        if (root.val < val){
            root.right = insertIntoBST(root.right, val); // 递归创建右子树
        }else if (root.val > val){
            root.left = insertIntoBST(root.left, val); // 递归创建左子树
        }

        return root;
    }
}
