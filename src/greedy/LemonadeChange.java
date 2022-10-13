package greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/14/9:33
 * @Description:
 * 柠檬水找零
 * https://leetcode.cn/problems/lemonade-change/
 */
public class LemonadeChange {
    /**
     * 情况一：账单是5，直接收下。
     * 情况二：账单是10，消耗一个5，增加一个10
     * 情况三：账单是20，优先消耗一个10和一个5，如果不够，再消耗三个5
     * 要细心：  还有给20找三个5的情况 ， 而且是找3个5 不是两个5
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> countMoney = new HashMap<>();
        countMoney.put(5,0);
        countMoney.put(10,0);
        countMoney.put(20,0);
        switch (bills[0]){
            case 5: countMoney.put(5,1); break;
            case 10: countMoney.put(10,1); break;
            case 20: countMoney.put(20,1); break;
        }
        System.out.print(bills[0]+" ");
        System.out.println(countMoney);

        for(int i=1; i<bills.length; i++){
            if(bills[i]==10){
                if(countMoney.get(5)>0){
                    countMoney.put(5,countMoney.get(5)-1);
                    countMoney.put(10,countMoney.get(10)+1);
                }else{
                    return false;
                }
            }else if(bills[i]==20){
                if(countMoney.get(5)>0 && countMoney.get(10)>0){
                    countMoney.put(5,countMoney.get(5)-1);
                    countMoney.put(10,countMoney.get(10)-1);
                    countMoney.put(20,countMoney.get(20)+1);
                }else if(countMoney.get(10)==0 && countMoney.get(5)>2) {
                    countMoney.put(5,countMoney.get(5)-3);
                    countMoney.put(20,countMoney.get(20)+1);
                } else {
                    return false;
                }
            }else{
                countMoney.put(5,countMoney.get(5)+1);
            }
            System.out.print(bills[i]+" ");
            System.out.println(countMoney);
        }
        // System.out.println(countMoney);

        return true;
    }
    public static void main(String[] args){
        int[] bills = {5,5,5,5,20,20,5,5,20,5};
        LemonadeChange lemonadeChange = new LemonadeChange();
        System.out.println(lemonadeChange.lemonadeChange(bills));
    }
}
