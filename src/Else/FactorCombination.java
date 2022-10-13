package Else;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/10/02/17:14
 * @Description:
 *  得物校招
 * 给出一个数n, 因子为25，10，5，1的不同组合
 * 如: 11 10 1 或者 5 5 1 所以结果有两种
 */
public class FactorCombination {

    List<List<Integer>> combinationResult = new ArrayList<>();
    public void combinationFunction() {
        combinationResult.clear();
        backtracking(25,0,0);
        System.out.println(combinationResult);
    }

    List<Integer> subList = new ArrayList<>();
    int[] tempNum = {1,5,10,25};
    void backtracking(int target, int sum, int index){
        if(target == sum){
            System.out.println(subList);
            combinationResult.add(new ArrayList<>(subList));
            return;
        }
        for (int i= index; i<tempNum.length; i++) {
            if(sum + tempNum[i] > target) break;
            subList.add(tempNum[i]);
            backtracking(target,sum + tempNum[i], i); // last param is i instead of index
            subList.remove(subList.size()-1);
        }
    }


//    void backtracking(int target, int product){
//        if(target == product){
//            System.out.println(subList);
//            combinationResult.add(new ArrayList<>(subList));
//            return;
//        }
//        for(int i= 0; i<temp.length; i++){
//            if(product * temp[i] > target) break;
//            subList.add(temp[i]);
//            backtracking(target,product * temp[i]);
//            subList.remove(subList.size()-1);
//        }
//    }
    public static void main(String[] args) {
        FactorCombination functionalInterface = new FactorCombination();
        functionalInterface.combinationFunction();

    }
}
