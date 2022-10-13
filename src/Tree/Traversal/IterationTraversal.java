package Tree.Traversal;

import Tree.TreeNode;

import java.util.*;

public class IterationTraversal {

    void showStack(Stack<TreeNode> stack){
        for(TreeNode item: stack){
            if(item!=null)
                System.out.print(item.val+" ");
            else
                System.out.print("null ");
        }
        System.out.println();
    }

    public List<Integer> Traversal(TreeNode root,String whichTraversal){
        List<Integer> result = new ArrayList<>();
        switch(whichTraversal){
            case "PreorderTraversal":
                PreorderTraversalHelp(root, result);
                break;
            case "InorderTraversal":
                InorderTraversalHelp(root, result);
                break;
            case "PostorderTraversal":
                PostorderTraversalHelp(root, result);
                break;
            case "BreadthFirstSearch":
                BreadthFirstSearchHelp(root,result);
                break;
            case "DepthFirstSearch":
                DepthFirstSearchHelp(root,result);
                break;
            default :
                break;
        }
        return result;
    }

    // Preorder Traversal    right left mid
    public void PreorderTraversalHelp(TreeNode root, List<Integer> result){
        Stack<TreeNode> stack = new Stack<>();
        if (root!=null) stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tempNode = stack.pop();
            if(tempNode!=null){
                if(tempNode.right!=null) stack.push(tempNode.right);

                if (tempNode.left!=null) stack.push(tempNode.left);

                stack.push(tempNode);
                stack.push(null);
            }else{
                tempNode = stack.pop();
                result.add(tempNode.val);
            }
        }

    }
    // Inorder Traversal  right mid left
    public void InorderTraversalHelp(TreeNode root, List<Integer> result){
        Stack<TreeNode> stack = new Stack<>();
        if (root !=null) stack.push(root);
        while(!stack.empty()){
            TreeNode tempNode = stack.pop();
            if(tempNode!=null){
                if(tempNode.right!=null) stack.push(tempNode.right); // right

                stack.push(tempNode); // mid
                stack.push(null); //

                if(tempNode.left!=null) stack.push(tempNode.left); // left

//                System.out.print("tempNode "+tempNode.val+" not null: \t");
//                showStack(stack);
            }else{
                tempNode = stack.pop(); // 上一步取得为null ,紧接着才是我们要选的内容—— 【取出来】
                result.add(tempNode.val);

//                System.out.print("null: \t");
//                showStack(stack);
            }
        }
    }


    // Postorder Traversal    mid right left
    public void PostorderTraversalHelp(TreeNode root, List<Integer> result){
        Stack<TreeNode> stack = new Stack<>();
        if(root!=null) stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tempNode = stack.pop();
            if(tempNode!=null){
                stack.push(tempNode);
                stack.push(null);

                if(tempNode.right!=null) stack.push(tempNode.right);

                if(tempNode.left!=null) stack.push(tempNode.left);
            }else{
                tempNode = stack.pop();
                result.add(tempNode.val);
            }
        }
    }

    //  breadth first search (or Level Traversal (output one-dimension))
    public void BreadthFirstSearchHelp(TreeNode root, List<Integer> result){
        if(root==null) return;
        TreeNode tempNode = null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            tempNode = queue.poll();
            result.add(tempNode.val);
            if(tempNode.left!=null) queue.offer(tempNode.left);
            if(tempNode.right!=null) queue.offer(tempNode.right);
        }
    }

    // depth-first search (or Preorder Traversal)
    public void DepthFirstSearchHelp(TreeNode root, List<Integer> result){
        if (root==null) return;
        TreeNode tempNode = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            tempNode = stack.pop();
            result.add(tempNode.val);
            if(tempNode.right!=null) stack.push(tempNode.right);
            if(tempNode.left!=null) stack.push(tempNode.left);
        }
    }

}
