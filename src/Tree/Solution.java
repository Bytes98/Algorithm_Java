package Tree;

import Tree.Traversal.IterationTraversal;
import Tree.Traversal.RecursionTraversal;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        // 使用递归的方式实现
        RecursionTraversal recursionTraversal = new RecursionTraversal();
        // 使用迭代的方式实现
        IterationTraversal iterationTraversal = new IterationTraversal();

        int[] rootArray = {5,4,6,1,2};
//        int[] rootArray = {1,2,2,3,4,4,3};
//        int[] rootArray ={};
//        for(Integer item: rootArray) {
//            System.out.println(item);
//        }

        TreeNode root = binaryTree.createTreeNode(rootArray,1);

        System.out.println("Recursion：");
        String[] whichTraversalRecur = {"PreorderTraversal","InorderTraversal","PostorderTraversal"};
        for(String item: whichTraversalRecur)
        {
            System.out.println(item+"：");
            List<Integer> result = recursionTraversal.Traversal(root,item);
            binaryTree.showList(result);
            System.out.println();
        }

        System.out.println("Iteration：");
        // as for binary tree, PreorderTraversal == DepthFirstSearch
        String[] whichTraversalIter = {"PreorderTraversal","InorderTraversal","PostorderTraversal","BreadthFirstSearch","DepthFirstSearch"};
        for(String item: whichTraversalIter)
        {
            System.out.println(item+"：");
            List<Integer> result = iterationTraversal.Traversal(root,item);
            binaryTree.showList(result);
            System.out.println();
        }

    }

}
