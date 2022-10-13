package Else.Tencent;

import java.util.*;

/**
 * 每轮删除一个下标为非质数的元素， 重复删除，返回唯一的值
 */
public class ZhiShu {
    private static boolean isNum(int n) {
        for(int i=2; i<=n/2;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(getNum(arr));
    }

    static int getNum(int[] arr){
        int arrLen = arr.length;
        List<Integer> list= new ArrayList<>();
        for(int i=0; i<arrLen; i++){
            list.add(arr[i]);
        }
        Map<Integer,Boolean> map = new HashMap<>();
        for(int i=0; i<arrLen; i++) {
            int index = i + 1;
            if (!map.containsKey(list.get(i))) {
                if (isNum(list.get(i))) map.put(list.get(i), true);
                else map.put(list.get(i), false);
            }
            if (!map.containsKey(index)) {
                if (isNum(index)) map.put(index, true);
                else map.put(index, false);
            }
        }

        map.put(1,false);
        while(arrLen>1){
//            System.out.println(arrLen);
            int tempArrLen = 0;
            List<Integer> rmList= new ArrayList<>();
            for(int i=0; i<arrLen; i++) {
                int index = i+1;
//                System.out.print(index+"-"+ list.get(i)+" ");
                int tempNum = list.get(i);
                if(!map.get(index)){
//                    System.out.print(index+" ");
                    rmList.add(list.get(i));
                    tempArrLen += 1;
                }
            }
//            System.out.println(rmList);
            list.removeAll(rmList);

            arrLen -= tempArrLen;
//            System.out.println();

        }
        return list.get(0);
    }
}
