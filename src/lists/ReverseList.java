package lists;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/08/8:46
 * @Description:
 * 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode temp = null; // 保存cur的下一个节点
        while(cur!=null){
            temp = cur.next; // 保存一下 cur的下一个节点，因为接下来要改变cur->next
            cur.next = pre; // 翻转操作
            // 更新pre 和 cur指针
            pre = cur;
            cur = temp;
        }
        return pre; //
    }
}
