package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/14/9:13
 * @Description:
 * 分发糖果
 * https://leetcode.cn/problems/candy/
 */
public class Candy {

    public int candy(int[] ratings) {
        int[] candyArrays = new int[ratings.length];
        Arrays.fill(candyArrays, 1);
        // for(int item : candyArrays){
        //     System.out.print(item+" ");
        // }
        // System.out.println();


        for(int i=1; i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]) candyArrays[i] = candyArrays[i-1]+1;
        }
        // for(int item : candyArrays){
        //     System.out.print(item+" ");
        // }
        // System.out.println();


        for(int i=ratings.length-2; i>=0;i--){
            if(ratings[i]>ratings[i+1]) candyArrays[i]=Math.max(candyArrays[i], candyArrays[i + 1] + 1);
        }
        // for(int item : candyArrays){
        //     System.out.print(item+" ");
        // }
        // System.out.println();


        int result = 0;
        for(int item : candyArrays){
            result += item;
        }
        return result;
    }
}
