package Tree;

import Tree.Traversal.LevelTraversal;

import java.util.*;

/**
 * 二叉树的所有路径
 * 时间： 2022 04 25
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {
    /**
     *  Object  支持不同类型的元素入栈
     *  用到栈，需要注意入栈的顺序，  出栈的顺序
     *  if(node.left==null && node.right==null) result.add(path);  直到叶子节点，。。。
     * @param root
     * @return
     */
    public List<String> binaryTreePathsHelper(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root==null) return result;

        Stack<Object> stack = new Stack<>();
        stack.push(root);
        stack.push(Integer.toString(root.val));
        while(!stack.isEmpty()){
            String path = (String) stack.pop();
            TreeNode node = (TreeNode) stack.pop();
            // 若找到叶子节点
            if(node.left==null && node.right==null) result.add(path);

            if(node.right!=null){
                stack.push(node.right);
                stack.push(path+"->"+node.right.val);
            }
            if(node.left!=null){
                stack.push(node.left);
                stack.push(path+"->"+node.left.val);
            }
        }

        return result;
    }

    public List<String> binaryTreePathsHelperByQueue(TreeNode root) {
        List<String> result = new ArrayList<>();
        Queue<Object> queue =new LinkedList<>();
        if(root!=null) {
            queue.offer(root);
            queue.offer(String.valueOf(root.val));
        }
        while(!queue.isEmpty()){
            TreeNode node = (TreeNode) queue.poll();
            String path = (String) queue.poll();

            if(node.left==null && node.right==null) result.add(path);
            if(node.left!=null) {
                queue.offer(node.left);
                queue.offer(path+"->"+node.left.val);
            }
            if(node.right!=null) {
                queue.offer(node.right);
                queue.offer(path+"->"+node.right.val);
            }
        }
        return result;
    }


    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        LevelTraversal levelTraversal = new LevelTraversal();

//        String string1 = "[3,4,5,1,2]";
//        String string1= "[1,2,3,null,5]";
        String string = "[5,4,8,11,null,13,4,7,2,null,null,5,1]";
        List<Integer> rootArray= new ArrayList<>();
        binaryTree.createArrayList(string,rootArray);
//        System.out.println(rootArray1);
        TreeNode root = binaryTree.createTreeNode(rootArray,1);
        binaryTree.showList2(levelTraversal.Traversal(root));

        System.out.println(binaryTreePaths.binaryTreePathsHelper(root));

        System.out.println(binaryTreePaths.binaryTreePathsHelperByQueue(root));
//        Queue<Object> test = new LinkedList<>();
//        test.offer(root);
//        test.offer(String.valueOf(root.val));
//        System.out.println(test.poll());
//        System.out.println(test.poll());
    }
}
