package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/15/8:40
 * @Description:
 * 用最少数量的箭引爆气球
 * https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if(points.length ==0) return 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[0])); // [[x1,x2][x1,x2]] x1从小到大排序

//        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        Arrays.sort(points, ((o1, o2) -> {
            if(o1[0]==o2[0]) return o1[1]-o2[1];
            return o2[0] - o1[0];
        }));



        int count = 1;
        for(int i=1; i< points.length; i++){
            if(points[i][0]>points[i-1][1]) count++;
            else points[i][1] = Math.min(points[i][1],points[i-1][1]);
        }
        return count;
    }
}
