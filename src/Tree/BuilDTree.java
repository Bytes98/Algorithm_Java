package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 从中序与后序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *  and
 *  从中序与先序遍历序列构造二叉树
 * 2022 04 27
 *
 *
 */
public class BuilDTree {
    /**
     * 注意区间的范围，保持统一，  这里保持左闭右开
     * Inorder  {{左子树}，root，{右子树}}
     * Postorder{{左子树}，{右子树}，root}
     * 易得出，中序遍历和后序遍历中，左子树的index范围是一致的，中序遍历的root Index就是后序遍历的右子树的start Index
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTreeByInorderAndPostOrder(int[] inorder, int[] postorder) {
        if(postorder.length==0) return null;
        int rootValue = postorder[0];
        TreeNode root = new TreeNode(rootValue);

        if(inorder.length==1) return root;

        int InorderRootIndex;
        for (InorderRootIndex = 0; InorderRootIndex < inorder.length; InorderRootIndex++) {
            if (inorder[InorderRootIndex] == rootValue) break;
        }

//     * Inorder  {{左子树}，root，{右子树}}
//     * Postorder{{左子树}，{右子树}，root}

        // 第四步：切割中序数组，得到 中序左数组和中序右数组
        // 坚持左闭右开
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, InorderRootIndex);
        int[] inorderRight = Arrays.copyOfRange(inorder, InorderRootIndex+1, inorder.length);

        // 第五步：切割后序数组，得到 后序左数组和后序右数组
        // 坚持左闭右开
        int[] postorderLeft= Arrays.copyOfRange(postorder,0,InorderRootIndex);
        int[] postorderRight= Arrays.copyOfRange(postorder,InorderRootIndex,postorder.length-1);


//        root.left = buildTree(中序左数组, 后序左数组);
        root.left = buildTreeByInorderAndPostOrder(inorderLeft, postorderLeft);
//        root.right = buildTree(中序右数组, 后序右数组);
        root.right = buildTreeByInorderAndPostOrder(inorderRight, postorderRight);

        return root;

    }

    /**
     * 注意区间的范围，保持统一，  这里保持左闭右开
     * Preorder{root,{左子树}，{右子树}}
     * Inorder {{左子树}，root，{右子树}}
     * 先序遍历中序遍历的右子树index范围一致。  Preorder左子树end Index 就是root Index +1 (保持右开)
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTreeByPreorderAndInorder(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);

        if(inorder.length==1) return root;

        int inorderRootIndex ;
        for(inorderRootIndex = 0;  inorderRootIndex < inorder.length; inorderRootIndex++){
            if(rootValue==inorder[inorderRootIndex]){
                break;
            }
        }

//     * Inorder {{左子树}，root，{右子树}}
//     * Preorder{root,{左子树}，{右子树}}

        // 第四步：切割中序数组，得到 中序左数组和中序右数组
        // 坚持左闭右开
        int[] inorderLeft = Arrays.copyOfRange(inorder,0,inorderRootIndex);
        int[] inorderRight = Arrays.copyOfRange(inorder,inorderRootIndex+1,inorder.length);

        // 第五步：切割先序数组，得到 先序左数组和先序右数组
        // 坚持左闭右开
        int[] preorderLeft = Arrays.copyOfRange(preorder,1,inorderRootIndex+1);
        int[] preorderRight = Arrays.copyOfRange(preorder,inorderRootIndex+1,inorder.length);

        root.left = buildTreeByPreorderAndInorder(preorderLeft,inorderLeft);
        root.right = buildTreeByPreorderAndInorder(preorderRight,inorderRight);

        return root;
    }


}
