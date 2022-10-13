package dynamicProgramming;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/16/9:00
 * @Description:
 * 斐波那契数
 * https://leetcode.cn/problems/fibonacci-number/
 */
public class Fib {
    /**
     *         // 1. 确定dp数组（dp table）以及下标的含义   dp 前面两项数字的和
     *         // 2. 确定递推公式      F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     *         // 3. dp数组如何初始化  F(0) = 0，F(1) = 1
     *         // 4. 确定遍历顺序    for 2 to n
     *         // 5. 举例推导dp数组
     *         // F(0) = 0
     *         // F[1] = 1
     *         // F[2] = 1
     *         // F[3] = 2
     * @param n
     * @return
     */
    public int fib(int n) {
        // 提示： 0 <= n <= 30
//         int[] pd = new int[n+1]; if(n==0) return;  if(n==1) return ;
        int[] pd = new int[31];
         pd[0]=0;
         pd[1]=1;
         for(int i=2; i<=n;i++){
             pd[i] = pd[i-1] + pd[i-2];
         }
         return pd[n];
    }

    //
    public int fibWay2(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        int a = 0, b=1, c=0;
        for(int i=2; i<=n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
