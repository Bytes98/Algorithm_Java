package Tree.Traversal;

import Tree.TreeNode;

import java.util.*;

public class RecursionTraversal {
    //    Preorder Traversal
    public void PreorderTraversalHelp(TreeNode root, List<Integer> result){
        if (root==null) return;
        result.add(root.val);
        PreorderTraversalHelp(root.left,result);
        PreorderTraversalHelp(root.right,result);
    }

    // Inorder Traversal
    public void InorderTraversalHelp(TreeNode root, List<Integer> result){
        if(root==null) return;
        InorderTraversalHelp(root.left, result);
        result.add(root.val);
        InorderTraversalHelp(root.right, result);
    }

    // Postorder Traversal
    public void PostorderTraversalHelp(TreeNode root, List<Integer> result){
        if(root==null) return;
        InorderTraversalHelp(root.left, result);
        InorderTraversalHelp(root.right, result);
        result.add(root.val);
    }

    public List<Integer> Traversal(TreeNode root, String whichTraversal){
        List<Integer> result = new ArrayList<>();
        switch(whichTraversal){
            case "PreorderTraversal":
                PreorderTraversalHelp(root,result);
                break;
            case "InorderTraversal":
                InorderTraversalHelp(root,result);
                break;
            case "PostorderTraversal":
                PostorderTraversalHelp(root,result);
                break;
            default :
                break;
        }
        return result;
    }

}
