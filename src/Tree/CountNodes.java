package Tree;

import java.util.Stack;

/**
 * 完全二叉树的节点个数
 *
 * 2022 04 21
 */
public class CountNodes {

    /**
     * 通过遍历的方式，遍历所节点，从而统计所有节点
     * 这里是用到了《中序 迭代 遍历》
     * @param root
     * @return
     */
    public int countNodesByTraversal(TreeNode root) {
        int result = 0;
        Stack<TreeNode> stack = new Stack<>();
        if(root!=null) stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tempNode = stack.pop();
            if(tempNode!=null){
                if(tempNode.right!=null) stack.push(tempNode.right);
                stack.push(tempNode);
                stack.push(null);
                if(tempNode.left!=null) stack.push(tempNode.left);
            }else{
                tempNode=stack.pop();
                result++;
            }
        }
        return result;
    }

    /**
     * 根据完全二叉树的性质：
     * 完全二叉树只有两种情况，情况一：就是满二叉树，情况二：最后一层叶子节点没有满。
     * 对于情况一，可以直接用 2^树深度 - 1 来计算，注意这里根节点深度为1。
     *    2^树深度有两种方式计算:
     *    2^树深度 = Math.pow(2,depth) = 1 << depth
     * 对于情况二，分别递归左孩子，和右孩子，递归到某一深度一定会有左孩子或者右孩子为满二叉树，然后依然可以按照情况1来计算
     * @return
     */
    public int countNodes(TreeNode root){
        if(root==null) return 0;

        // 为判断是否满二叉树做准备
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftH = 0, rightH = 0; // 当rightH深度为1时， (1 << leftH) - 1 = (1 << 1) - 1 = 2-1 = 1；
        while(left!=null){
            left = left.left;
            leftH++;
        }
        while(right!=null){
            right = right.right;
            rightH++;
        }

        if(leftH == rightH){ // leftH == rightH 说明满二叉树, 满二叉树的节点数 ==2^depth -1
            int rootDepth = leftH +1;
            return (1 << rootDepth) - 1;
        }

        // 如果不满，继续递归，总会满的。因为二叉树。
        int nodeNumsLeft = countNodes(root.left);
        int nodeNumsRight = countNodes(root.right);

        return  nodeNumsLeft + nodeNumsRight +1;
    }


}

