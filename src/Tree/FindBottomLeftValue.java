package Tree;

import Tree.Traversal.LevelTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  找树左下角的值
 *  https://leetcode-cn.com/problems/find-bottom-left-tree-value/
 *  2022 4 26
 */
public class FindBottomLeftValue {
    /**
     * 在计算树的深度的基础上改， 找到底层最左边的叶子
     *
     * @param root
     * @return
     */
    public int findBottomLeftValueHelper(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int result = 0;
        if(root!=null) queue.offer(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++){ // 遍历第n层的所有结点
                TreeNode node = queue.poll();
                if(i==0) result = node.val; // i==0 ，说明是该层最左边的结点 ， 类似的同一层最右边结点， i=queueSize-1;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
//            System.out.println(result);
//            不断的迭代，更新result，  直到获得最底层，最左边的结点。
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        FindBottomLeftValue findBottomLeftValue = new FindBottomLeftValue();
        LevelTraversal levelTraversal = new LevelTraversal();

        String string = "[1,2,3,4,null,5,6,null,null,null,null,7]";
        List<Integer> rootArray = new ArrayList<>();
        binaryTree.createArrayList(string, rootArray);
        System.out.println(rootArray);
        TreeNode root = binaryTree.createTreeNode(rootArray, 1);
        binaryTree.showList2(levelTraversal.Traversal(root));

        System.out.println(findBottomLeftValue.findBottomLeftValueHelper(root));

    }
}
