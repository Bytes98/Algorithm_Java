package lists;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/09/9:23
 * @Description:
 * 链表相交
 * https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/
 */
public class GetIntersectionNode {
    /**
     *  1、从尾部开始对齐， 如何从尾部开始对齐？  求差值，让长的先走这个差值， 就对齐了
     *      12345
     *      345
     *      差值为2，让长的先走两步，就从尾部开始对齐了
     *  2、同时走，比较，直到遇到相同的node。 注意这里用该是判断节点相同，而不单单只是取值相同而已。
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int ALength = 0, BLength = 0;
        ListNode curA = headA;
        while(curA!=null){
            curA = curA.next;
            ALength ++;
        }
        ListNode curB = headB;
        while(curB!=null){
            curB = curB.next;
            BLength ++;
        }
        // System.out.println(ALength+" "+BLength);
        curA = headA;
        curB = headB;
        while(BLength>ALength){ // 让curA为最长链表
            // 交换头结点
            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;
            // 交换长度
            int tempLen = ALength;
            ALength = BLength;
            BLength = tempLen;
        }
        // System.out.println(ALength+" "+BLength);
        // System.out.println(curA.val);
        // System.out.println(curB.val);
        // 对齐
        int diffAB = ALength - BLength;
        while(diffAB>0){
            curA = curA.next;
            diffAB--;
        }
        // System.out.println(curA.val);
        // System.out.println(curB.val);
        // 同时走，比较，直到遇到相同的node
        while(curA!=null){
            if(curA==curB) return curA;
            else{
                curA = curA.next;
                curB = curB.next;
            }
        }
        return null;
    }
}
