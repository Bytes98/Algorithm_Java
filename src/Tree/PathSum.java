package Tree;

import Tree.Traversal.LevelTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 * 2022 04 27
 */
public class PathSum {

    public List<List<Integer>> pathSumHelper(TreeNode root, int targetSum) {
        List<List<Integer>> pathList = new ArrayList<>();
        if (root == null) return pathList;

        Stack<Object> stack = new Stack<>();

        stack.push(root); // node
        stack.push(Integer.toString(root.val)); // path
        stack.push(root.val); // sum
        List<String> pathListTemp = new ArrayList<>();
        while(!stack.isEmpty()){
            int pathSum = (int) stack.pop();
            String path = (String) stack.pop();
            TreeNode node = (TreeNode) stack.pop();

            if(node.left==null && node.right==null && pathSum==targetSum)  pathListTemp.add(path);

            if(node.right!=null){
                stack.push(node.right);
                stack.push(path+"->"+node.right.val);
                stack.push(pathSum+node.right.val);
            }
            if(node.left!=null){
                stack.push(node.left);
                stack.push(path+"->"+node.left.val);
                stack.push(pathSum+node.left.val);
            }
        }

//        System.out.println(pathListTemp);

        for(String pathI: pathListTemp){
            List<Integer> templist = new ArrayList<>();
            for(String num:pathI.split("->")){
                templist.add(Integer.valueOf(num));
            }
            pathList.add(templist);
        }

        return pathList;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        LevelTraversal levelTraversal = new LevelTraversal();
        PathSum pathSum = new PathSum();

//        String string1= "[5,4,8,11,null,13,4,7,2,null,null,null,null,null,1]";
        String string = "[5,4,8,11,null,13,4,7,2,null,null,null,null,5,1]";
//        String string = "[1,2,2]";
        List<Integer> rootArray = new ArrayList<>();
//        System.out.println(string.length());
        binaryTree.createArrayList(string, rootArray);
//        System.out.println(rootArray);
        TreeNode root = binaryTree.createTreeNode(rootArray, 1);
        binaryTree.showList2(levelTraversal.Traversal(root));


        System.out.println(pathSum.pathSumHelper(root, 22));
    }
}
