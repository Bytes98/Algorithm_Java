package Tree.BST;

import Tree.TreeNode;

/**
 * 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 2022 04 28
 *
 */
public class lowestCommonAncestorInBST {
    /**
     * 思路一 ： 跟 LowestCommonAncestor。java 一样
     * 利用回溯从底向上搜索，
     * 遇到一个节点的左子树里有p(或者q)，右子树里有p(或者q)，那么当前节点就是最近公共祖先。
     */

    /**
     * 思路二： 利用二搜索树的性质做
     * node左子树的所有元素 < node < node右子树的所有元素
     * 那么  node比 p q 都大， 我们要的结果就在递归左子树中。 递归左子树
     * node比 p q 都小， 我们要的结果就在递归右子树中。 递归右子树
     * 当假设p<q时， 出现 p < node < q， 那么node就是我们要的结果, 反之p>q时,p > node > q 也成立
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>p.val && root.val>q.val) return lowestCommonAncestor(root.left, p, q);
        if(root.val<p.val && root.val<q.val) return lowestCommonAncestor(root.right, p, q);

        return root;
    }

    /**
     * 思路三： 在思路二的基础上， 不用遍历，用递归实现
     */
    public TreeNode lowestCommonAncestorByIteration(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(root.val > q.val && root.val > p.val) {
                root = root.left;
            }else if(root.val < q.val && root.val < p.val){
                root = root.right;
            }else {
                return root;
            }
        }
        return null;
    }
}
