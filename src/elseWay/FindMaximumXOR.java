package elseWay;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * @Author: 98Bytes
 * @Date: 2022/08/01/20:16
 * @Description: 剑指 Offer II 067. 最大的异或
 * https://leetcode.cn/problems/ms70jA/
 *
 */
public class FindMaximumXOR {

    public int findMaximumXOR(int[] nums){
        int result = Integer.MIN_VALUE;
        if(nums.length<2) return 0;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                result = calculatingXOR(nums[i],nums[j])>result?  calculatingXOR(nums[i],nums[j]):result;
            }
        }
        return result;
    }

    public int calculatingXOR_1(int x,int y){
//        5 XOR 25 = 28.
//     00101 ^ 11001 = 11100 = = 16+8+4 = 28
//        0000 0000 0000 0000 0000 0000 0001 1100
        int result = 0;
        for(int i=31; i>=0;i--){
            int bit_item1 = (x>>i) & 1;
            int bit_item2 = (y>>i) & 1;
            if ((bit_item1 ^ bit_item2)==1){
                result += Math.pow(2,i);
            }
        }
        return result;
    }

    public int calculatingXOR(int x,int y){
        int xor=0;
        for(int i=31; i>=0;i--){
            int bit_item1 = (x>>i) & 1;
            int bit_item2 = (y>>i) & 1;
            // 两数位不相等
            if (bit_item1 != bit_item2) {
                xor = xor * 2 + 1;
            }
            // 两数位相等
            else {
                xor = xor * 2;
            }
        }
        return xor;
    }

    public List<Integer> getBit(int num){
        List<Integer> result = new ArrayList<>();
        for(int i=31; i>=0;i--){
            int bit_item = (num>>i) & 1;
            result.add(bit_item);
        }
        result.forEach(System.out::print);
        System.out.println();

        Collections.reverse(result);
        result.forEach(System.out::print);
        return result;
    }

    public static void main(String[] args){
        int num[] = {3,10,5,25,2,8};
        FindMaximumXOR findMaximumXOR = new FindMaximumXOR();
//        findMaximumXOR.getBit(25);
        System.out.println(findMaximumXOR.findMaximumXOR(num));
    }
}