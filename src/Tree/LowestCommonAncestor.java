package Tree;

/**
 * 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 2022 04 28
 */
public class LowestCommonAncestor {
    /**
     * 求最小公共祖先 ---->需要从底向上遍历
     * 需要从底向上遍历，那么二叉树，只能通过后序遍历（即：回溯）实现从低向上的遍历方式
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestorHelper(root, p, q);
    }


    // node节点是什么就返回什么，
    // node==null -> 没有 -> 返回null
    // node==p -> 找到p -> 返回p
    // node==q -> 找到q -> 返回q
    //题目隐含的信息，在测试用例也是这样要求的： 注意p,q必然存在树内, 且所有节点的值唯一!!!
    public TreeNode lowestCommonAncestorHelper(TreeNode node, TreeNode p, TreeNode q){
            // 在这里限定了，整个递归过程返回值3种情况
            // lowestCommonAncestorHelper返回值要么是 null 要么p 要么 q
            if(node==null || node==p || node==q) return node;

            // 后去遍历
            TreeNode left = lowestCommonAncestorHelper(node.left, p, q);// 看看左子树的返回值
            TreeNode right = lowestCommonAncestorHelper(node.right, p, q);// 看看右子树的返回值

            if(left==null && right==null) return null;  // 左右子树返回值均为null, p和q均不在左右子树中, 没有p或q

                // 注意p,q必然存在树内, 且所有节点的值唯一!!!
                // 那么要要判断是不是null,就可以了, 不必纠结p q 左子树还是右子树
            else if(left!=null && right==null) return left;  //返回非空的，必然是p或者q不必纠结，本题不需要只知道非空left到底是p 还是q。
            else if(left==null && right!=null) return right; //返回非空的
            else return node; // 左右子树非空，左右子树都有返回值，那就是p、q 在左右子树当中， 此时的node就是我们想要的值
        }


}
