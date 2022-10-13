package Tree.Traversal;

import Tree.BinaryTree;
import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelTraversal extends IterationTraversal {

    // one-dimension (output):  breadth first search (or Level Traversal )
    // public void BreadthFirstSearchHelp(TreeNode root, List<Integer> result){}

    // two-dimension (output)
    void levelOrderHelper(TreeNode root, List<List<Integer>> result){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null) queue.offer(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i=0; i<queueSize; i++){
                TreeNode tempNode = queue.poll();
                tempList.add(tempNode.val);
                if(tempNode.left!=null) queue.offer(tempNode.left);
                if(tempNode.right!=null) queue.offer(tempNode.right);
            }
            result.add(tempList);
        }
    }

    public List<List<Integer>> Traversal(TreeNode root){
        List<List<Integer> >result = new ArrayList<>();
        levelOrderHelper(root, result);
        return result;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        LevelTraversal levelTraversal =new LevelTraversal();

//        int[] rootArray = {5,4,6,1,2};
        String string = "[3,9,20,null,null,15,7]";
        List<Integer> rootArray= new ArrayList<>();
        binaryTree.createArrayList(string,rootArray);
        binaryTree.showList(rootArray);

        TreeNode root = binaryTree.createTreeNode(rootArray,1);

        List<List<Integer>> result = levelTraversal.Traversal(root);
        binaryTree.showList2(result);

    }
}
