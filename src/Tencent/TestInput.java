package Tencent;

import java.util.*;

public class TestInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int i = 0; i < times; i++) {
            int nums = scanner.nextInt();
            int result = 1;

            HashSet<HashSet<Integer>> set = new HashSet<>();
            HashSet<Integer> tempSet = new HashSet<>();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            tempSet.add(a);
            tempSet.add(b);
            set.add(tempSet);
            HashSet<HashSet<Integer>> rmSet = new HashSet<>();
            for (int j = 1; j < nums; j++) {
                a = scanner.nextInt();
                b = scanner.nextInt();
                tempSet = new HashSet<>();
                for (HashSet<Integer> item : set) {
                    tempSet.add(a);
                    tempSet.add(b);
                    if(item.contains(a) || item.contains(b)){
                        tempSet.addAll(item);
                        rmSet.add(item);
                    }
                }
//                System.out.println(rmSet);
                set.removeAll(rmSet);
                set.add(tempSet);
            }
//            System.out.println(set);
            for (HashSet<Integer> item : set) {
                if (item.size() > result) result = item.size();
            }
            System.out.println(result);
        }
    }
}
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int times = scanner.nextInt();
//        for(int i=0; i<times; i++) {
//            int nums = scanner.nextInt();
//            List<HashSet<Integer>> list = new ArrayList<>();
//            int result = 0;
//            for(int j=0; j<nums; j++){
//                int a = scanner.nextInt();
//                int b = scanner.nextInt();
//                List<Integer> rmIndex = new ArrayList<>();
//                HashSet<Integer> tempSet = new HashSet<>();
//                if(!list.isEmpty()){
//                    for(int k=0; k<list.size(); k++){
//                        if(list.get(k).contains(a) || list.get(k).contains(b)){
//                            tempSet.addAll(list.get(k));
//                            tempSet.add(a);
//                            tempSet.add(b);
//                            rmIndex.add(k);
//                        }else{
//                            tempSet.add(a);
//                            tempSet.add(b);
//                        }
//                    }
//                    for(Integer index : rmIndex){
//                        list.remove(index);
//                    }
//                }else{
//                    tempSet.add(a);
//                    tempSet.add(b);
//                }
//                list.add(tempSet);
//            }
////            System.out.println(list);
//            for(HashSet<Integer> item : list) {
//                if(item.size()>result) result = item.size();
//            }
//            System.out.println(result);
//        }
//    }
//}

