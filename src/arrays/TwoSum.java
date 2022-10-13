package arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/16/10:13
 * @Description:
 */
public class TwoSum {
    /**
     * 小细节 xIndex=-1 找不到， xIndex>-1或者xIndex>=0时找到了 if(xIndex>=0){ }
     *          误判为if(xIndex>0) 漏掉了等于0
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        // 2 <= numbers.length <= 3 * 104
        // -1000 <= numbers[i] <= 1000
        // numbers 按 递增顺序 排列
        // -1000 <= target <= 1000
        // 仅存在一个有效答案

        int[] result = new int[2];
        for(int yIndex=numbers.length-1; yIndex>0; yIndex--){
            int targetY = numbers[yIndex];
            int targetX = target - targetY;
            int xIndex = findtargetX(numbers, targetX, yIndex-1);
            if(xIndex>=0){
                result[0] = xIndex;
                result[1] = yIndex;
                break;
            }
        }
        return result;
    }

    // return  index;
    private int findtargetX(int[] numbers, int targetX, int rightIndex){
        int leftIndex = 0;

        while(leftIndex<=rightIndex){
            int middleIndex = (leftIndex+rightIndex)/2;
            int middleData = numbers[middleIndex];
            if(middleData==targetX) return middleIndex;
            else if(middleData>targetX){
                rightIndex = middleIndex - 1;
            }else{
                leftIndex = middleIndex + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] numbers = {-1,0,1};
        int target = -1;
        TwoSum twoSum = new TwoSum();
        for (int i : twoSum.twoSum(numbers, target)) {
            System.out.println(i);
        }
    }
}
