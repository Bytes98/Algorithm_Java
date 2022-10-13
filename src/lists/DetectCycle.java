package lists;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/09/9:51
 * @Description:
 * 环形链表 II
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 */
public class DetectCycle {
    /**
     *  不存在环的话，不会循环， 指针遍历完return null即可
     *  存在环的话， 头结点到入环口的个数为x, 入环口到第一次相遇的的个数为y，剩下与y构成环的节点个数为z， 根据题目所求为x。
     *      slow指针走过的节点数为: x + y， fast指针走过的节点数：x + y + n (y + z)， 其中n为fast指针在环内走了n圈才遇到slow指针
     *      fast指针是一步走两个节点，slow指针一步走一个节点
     *      (x + y) * 2 = x + y + n (y + z)
     *      所求头结点到入环口的长度 x = (n - 1) (y + z) + z 。 所以当n=1时，x=z
     *      快慢指针相遇后， 再slow继续1步1步走， fast从头节点1步1步走，相遇的地方为环入口
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){ // 有环
                fast = head;
                while(fast!=slow){ // 找入环口
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
