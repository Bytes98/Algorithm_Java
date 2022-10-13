package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {

    /**
     * Maximum Depth of N-ary Tree
     */
    //
    public int maxDepthOfNaryTreeRecursion(Node root) {
        if(root==null) return 0;
        int result = 0;
        for(Node item: root.children){
            result = Math.max(result, maxDepthOfNaryTreeRecursion(item));
        }
        return result+1;
    }

    //
    public int maxDepthOfNaryTreeIteration(Node root) {
        int result = 0;
        Queue<Node> queue = new LinkedList();
        if(root!=null) queue.offer(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            result++;
            for(int i=0;i<queueSize;i++){
                Node tempNode = queue.poll();
                for(Node item: tempNode.children){
                    if(item!=null) queue.offer(item);
                }
            }
        }
        return result;
    }


    /**
     * Maximum Depth of Binary Tree
     */
    public int maxDepthOfBinaryTreeIteration(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList();
        if(root!=null) queue.offer(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            result++;
            for(int i=0;i<queueSize;i++){
                TreeNode tempNode = queue.poll();
                if(tempNode.left!=null) queue.offer(tempNode.left);
                if(tempNode.right!=null) queue.offer(tempNode.right);
            }
        }
        return result;
    }



    /**
     *     public int maxDepth(TreeNode root) {
     *         if(root==null) return 0;
     *         return Math.max(maxDepth(root.left),maxDepth(root.right)) +1;
     *     }
     *
     * */

}
