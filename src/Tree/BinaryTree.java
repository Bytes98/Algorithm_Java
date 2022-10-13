package Tree;

import java.util.List;

public class BinaryTree {

    public TreeNode createTreeNode(int[] rootArray, int index){
        if(index > rootArray.length){
            return null;
        }
        Integer value = rootArray[index - 1];
//        if(value == null){
//            return null;
//        }
        TreeNode node = new TreeNode(value);
        node.left = createTreeNode(rootArray, index * 2);
        node.right = createTreeNode(rootArray, index * 2 + 1);
        return node;
    }

    // array to binary tree
    public TreeNode createTreeNode(List<Integer> rootArray, int index){
        if(index > rootArray.size()){
            return null;
        }
        Integer value = rootArray.get(index - 1);
        if(value == null){
            return null;
        }
        TreeNode node = new TreeNode(value);
        node.left = createTreeNode(rootArray, index * 2);
        node.right = createTreeNode(rootArray, index * 2 + 1);
        return node;
    }

    public void createArrayList(String string, List<Integer> rootArray){
        if(string.length()<=2) {
            rootArray.add(null);
            return;
        }
        for (String str: string.split(","))
        {
            if(str.contains("["))
            {
//                System.out.println(Integer.valueOf(str.substring(1)));
                rootArray.add(Integer.valueOf(str.substring(1)));
            }else if(str.contains("]")) {
                rootArray.add(Integer.valueOf(str.substring(0,str.length()-1)));
            }else if (str.equals("null")){
                rootArray.add(null);
            } else{
                rootArray.add(Integer.valueOf(str));
            }
        }
    }


    public void showList(List<Integer> result){
        System.out.print("[");
        for (Integer item: result){
            System.out.print(item + ",");
        }
        System.out.println("\b]");
    }

    public void showList2(List<List<Integer>> result){
//        for (List<Integer> item: result){
//            for (Integer jItem: item){
//                System.out.print(jItem + " ");
//            }
//            System.out.println();
//        }
        System.out.print("[");
        for (List<Integer> item: result){
            System.out.print("[");
            for (Integer jItem: item){
                System.out.print(jItem + ",");
            }
            System.out.print("\b],");
        }
        System.out.println("\b]");
    }

}
