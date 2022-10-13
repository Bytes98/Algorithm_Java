package Tree.BST;

import Tree.TreeNode;

import java.util.*;

/**
 * 二叉搜索树中的众数
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * 2022 04 28
 */
public class FindMode {
    /**
     * map.put(node.val, ++temp);
     * // !!! 小细节， ++temp:  temp要先加加 再put进去， 否则temp++的结果是put没加1的temp结果
     *
     */
    Map<Integer,Integer> map = new TreeMap<>();
    int maxCount = -1;
    void inorderTraversalRecursion(TreeNode node){
        if(node==null) return;
        inorderTraversalRecursion(node.left);
        // 统计 key-value  元素-元素频数
        if(map.containsKey(node.val)){
            int temp = map.get(node.val);
            map.put(node.val, ++temp); // !!! 小细节， temp要先加加 再put进去， 否则temp++的结果是put没加1的temp结果
        }else{
            map.put(node.val, 1);
        }
        // 获得频数的最大值
        if(map.get(node.val)>maxCount) maxCount = map.get(node.val);
        inorderTraversalRecursion(node.right);
    }


    List<Integer> list = new LinkedList<>();
    //    Map<Integer,Integer> map = new TreeMap<>();
//    int maxCount = -1;
    void inorderTraversalRecursion2(TreeNode node){
        if(node==null) return;
        inorderTraversalRecursion(node.left);
        if(map.containsKey(node.val)){
            int temp = map.get(node.val);
            map.put(node.val, ++temp);
        }else{
            map.put(node.val, 1);
        }
        if (map.get(node.val) == maxCount) { // 如果和最大频率相同，放进list中
            list.add(node.val);
        }

        if(map.get(node.val)>maxCount){
            maxCount = map.get(node.val); // 更新最大频率
            list.clear();// 很关键的一步，不要忘记清空list，之前list里的元素都失效了
            list.add(node.val);
        }
        inorderTraversalRecursion(node.right);
    }


    public int[] findMode(TreeNode root) {
        map.clear();
        String ways= "2";

        if(ways.equals("1")){
            inorderTraversalRecursion(root);
            for(Integer key: map.keySet()) {
                if(map.get(key)==maxCount){
                    list.add(key);
                }
            }
        }else{
            inorderTraversalRecursion2(root);
        }

//
//        int i =0;
//        int[] result = new int[list.size()];
//        for(Integer value: list){
//            result[i++] = value;
//        }
//        return result;
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
