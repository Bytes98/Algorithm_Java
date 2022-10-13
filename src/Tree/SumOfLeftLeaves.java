package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 左叶子之和
 * 2022 04 25
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        int result = 0;
        if(root==null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i=0; i<queueSize; i++){
                TreeNode node = queue.poll();
                //assert node != null;// ??
                if(node.left!=null && node.left.left==null && node.left.right==null){
                    result += node.left.val;
                }
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }

        }
        return result;
    }
}
