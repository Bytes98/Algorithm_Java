package Backtracking;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/06/10:27
 * @Description:
 * 重新安排行程
 * https://leetcode-cn.com/problems/reconstruct-itinerary/
 */
public class FindItinerary {
    /**
     * 注意：
     *  1、 unordered_map<string, map<string, int>> targets：
     *      unordered_map<出发机场, map<到达机场, 航班次数>> targets
     *  2、一旦删除元素，迭代器可能就失效了  -》 我不删，我就做一个标记！
     *  2.1 再说一下为什么一定要增删元素呢，出发机场和到达机场是会重复的，搜索的过程没及时删除目的机场就会死循环。
     *  2.2 在遍历 unordered_map<出发机场, map<到达机场, 航班次数>> targets的过程中，可以使用"航班次数"这个字段的数字做相应的增减，来标记到达机场是否使用过了。
     *  2.3 如果“航班次数”大于零，说明目的地还可以飞，如果如果“航班次数”等于零说明目的地不能飞了，而不用对集合做删除元素或者增加元素的操作。
     *
     * @param tickets
     * @return
     */
    private Deque<String> result; // 保证是加入的顺序，所以用队列， List也可以？
    private Map<String, Map<String, Integer>> map; // HashMap<起点, TreeMap<终点, 航班次数>>
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        result = new LinkedList<>();
        for(List<String> t: tickets){
            Map<String, Integer> temp; // 统计，Map<终点, 航班次数>
            String departure = t.get(0); // t.get(0) 始点，
            String destination = t.get(1);  // t.get(1) 终点
            if(map.containsKey(departure)){
                temp = map.get(departure);
                temp.put(destination, temp.getOrDefault(destination,0)+1);
            }else{
                temp = new TreeMap<>(); //升序Map
                temp.put(destination,1);
            }
            map.put(departure, temp); // 统计， HashMap.put(起点,TreeMap<终点, 航班次数>)
        }
        result.add("JFK");
        backTracking(tickets.size());
        return new ArrayList<>(result);
    }

    private boolean backTracking(int ticketNum){
        if(result.size() == ticketNum+1){
            return true;
        }
        String nextPoint = result.getLast();
        if(map.containsKey(nextPoint)){ //防止出现null
            for(Map.Entry<String, Integer> target : map.get(nextPoint).entrySet()) {
                int count = target.getValue(); // 航班次数
                if(count > 0){
                    result.add(target.getKey());
                    target.setValue(count-1);
                    if(backTracking(ticketNum)) return true;
                    result.removeLast();
                    target.setValue(count);
                }
            }
        }
        return false;
    }
}
