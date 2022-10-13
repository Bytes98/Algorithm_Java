package greedy;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/14/10:07
 * @Description:
 * https://leetcode.cn/problems/queue-reconstruction-by-height/
 * 根据身高重建队列
 */
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            System.out.println(a[0]+" "+b[0]);
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });




        return people;
    }
}
