package Tree.twoTree;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *合并二叉树
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 * 2022 04 28
 */
public class MergeTrees {
    /**
     * root1 root2只有一个空时， root1 null. 返回root2; root2 null. 返回root1
     *
     * 两个节点入队
     *
     * 不需要额外定义树，root1为基础，返回求和后的root1；
     * 循环判断{
     *     // 取出节点
     *     node1，node2分别出队
     *
     *     // 相加
     *     node1，node2两个节点相加，赋值给node1
     *
     *     // node1.left 与 node2.left 的情况下的操作
     *     // node1.right 与 node2.right 的情况下的操作
     *     // 进行分类讨论：
     *         情况一：压队，后面循环再进行求和
     *         情况二：赋值节点（整棵子树）
     *         情况三：不做操作
     *     具体如下：
     *         如果两个node的left都不为空，加入队列
     *         如果两个node的right都不为空，加入队列
     *         当node1.left为空, node2.left不为空， 就把node2.left赋值给node1.left；
     *         当node1.right为空, node2.right不为空， 就把node2.right赋值给node1.right；
     *         而其他情况,没必要操作了 ，没意义：
     *            node1.left node2.left 都为空,
     *            node1.right node2.right 都为空,
     *            node1.left非空， node2.left为空
     *            node1.right非空， node2.right为空
     * }
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null) return root2;
        if(root2==null) return root1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while(!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            // 此时两个节点一定不为空，val相加
            node1.val += node2.val;

            // 如果两棵树左节点都不为空，加入队列
            if(node1.left!=null && node2.left!=null) {
                queue.offer(node1.left);
                queue.offer(node2.left);
            }

            // 如果两棵树右节点都不为空，加入队列
            if(node1.right!=null && node2.right!=null){
                queue.offer(node1.right);
                queue.offer(node2.right);
            }

            // 当t1的左节点 为空 t2左节点不为空，就赋值过去
            if(node1.left==null && node2.left!=null){
                node1.left = node2.left;
            }
//            else if ((node1.left==null && node2.left==null) || (node1.left!=null && node2.left==null))
//            {
//
////                node1 node2 的左节点都为空， 没必要需操作了
////                node1 左节点非空， node2的左节点为空， 没必要操作了
//            }

            // 当t1的右节点 为空 t2右节点不为空，就赋值过去
            if(node1.right==null && node2.right!=null){
                node1.right = node2.right;
            }
        }
        return root1;
    }

    public static void main(String[] args){

    }
}
