package greedy;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/15/9:08
 * @Description:
 * https://leetcode.cn/problems/non-overlapping-intervals/
 * 无重叠区间
 */
public class EraseOverlapIntervals {
    /**
     * 按照右边界排序，
     * 从左向右记录非交叉区间的个数。
     * 最后用区间总数减去非交叉区间的个数就是需要移除的区间个数了。
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        int count = 0;
        int edge = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (edge <= intervals[i][0]) {
                edge = intervals[i][1];
            } else {
                count++;
            }
        }

        return count;
    }
}
