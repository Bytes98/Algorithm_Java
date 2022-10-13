package Tree;

import Tree.Traversal.LevelTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InvertTree {

    void showStack(Stack<TreeNode> stack){
        for(TreeNode item: stack){
            if(item!=null)
                System.out.print(item.val+" ");
            else
                System.out.print("null ");
        }
        System.out.println();
    }

    public void swapNodes(TreeNode root){
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
    }

    // 递归方法实现
    // 前后序遍历都可以
    // 中序不行，因为先左孩子交换孩子，
    // 再根交换孩子（做完后，右孩子已经变成了原来的左孩子），
    // 再右孩子交换孩子（此时其实是对原来的左孩子做交换）
    public TreeNode invertTreeRecursionHelper(TreeNode root) {
        if (root==null) return root;
        swapNodes(root);
        invertTreeRecursionHelper(root.right);
        invertTreeRecursionHelper(root.left);
        return root;
    }

    // 迭代的方法实现（中序也可以）
    public TreeNode invertTreeIterationHelper(TreeNode root){
        BinaryTree binaryTree = new BinaryTree();
        LevelTraversal levelTraversal = new LevelTraversal();

        Stack<TreeNode> stack = new Stack<>();
        if (root!=null) stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tempNode = stack.pop();
            if(tempNode!=null){
                if(tempNode.right!=null) stack.push(tempNode.right);
                stack.push(tempNode);
                stack.push(null);
                if(tempNode.left!=null) stack.push(tempNode.left);
                System.out.print("tempNode "+tempNode.val+" not null: \t");
            } else {
                tempNode = stack.pop();
                swapNodes(tempNode);
                System.out.print("tempNode "+tempNode.val+" null: \t");
                binaryTree.showList2(levelTraversal.Traversal(root));
            }
            showStack(stack);
//            binaryTree.showList2(levelTraversal.Traversal(root));
        }
        return root;
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        LevelTraversal levelTraversal = new LevelTraversal();
        InvertTree invertTree =new InvertTree();

        String string = "[4,2,7,1,3,6,9]";
        List<Integer> rootArray= new ArrayList<>();
        binaryTree.createArrayList(string,rootArray);
        binaryTree.showList(rootArray);


        TreeNode root1 = binaryTree.createTreeNode(rootArray,1);
        // 按层次遍历输出
        binaryTree.showList2(levelTraversal.Traversal(root1));
        // 进行左右子节点翻转(递归)
        TreeNode resultRootRec = invertTree.invertTreeRecursionHelper(root1);
        // 按层次遍历输出
        binaryTree.showList2(levelTraversal.Traversal(resultRootRec));


        TreeNode root2 = binaryTree.createTreeNode(rootArray,1);
        // 按层次遍历输出
        binaryTree.showList2(levelTraversal.Traversal(root2));
        // 进行左右子节点翻转（利用堆栈迭代）
        TreeNode resultRootIter = invertTree.invertTreeIterationHelper(root2);
        // 按层次遍历输出
        binaryTree.showList2(levelTraversal.Traversal(resultRootIter));


    }
}
