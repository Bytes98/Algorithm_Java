package lists;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/08/8:49
 * @Description:
 *  删除链表的倒数第 N 个结点
 *  https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *  并没有很顺利， 不知道双指针具体怎么用
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        // 为了删除， 让fast走n步，
        // slow指向删除节点的pre(上一个节点)时，删除更方便, 再多走一步
        // 总共做了 n+1；
        while(n>0 && fast!=null){
            n--;
            fast = fast.next;
        }
        fast = fast.next;// 为了方便删除， fast再提前走一步，因为需要让slow指向删除节点的pre(上一个节点)
        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
