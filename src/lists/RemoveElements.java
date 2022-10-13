package lists;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/07/9:05
 * @Description:
 * 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next!=null){
            if(cur.next.val == val) {
//                ListNode delNode = cur.next;
                cur.next = cur.next.next;
            }else{
                cur= cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args){
        String string = "[1,2,3,4,5]";
        int target = 3;
        ListNode head = new ListNode();
        RemoveElements removeElements = new RemoveElements();
        // 构建list
        removeElements.creatList(head,string);
//        while(head!=null){
//            System.out.println(head.val);
//            head = head.next;
//        }
        ListNode result = removeElements.removeElements(head,2);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    void creatList(ListNode head, String string){
        for(String str : string.split(",")){
//            System.out.println(str);
            if(str.contains("[")){
                head.val = Integer.parseInt(str.substring(1));
            }else if (str.contains("]")) {
                head.val = Integer.parseInt(str.substring(0,str.length()-1));
            }else{
                head.val = Integer.parseInt(str);
            }
            head.next = new ListNode();
            head = head.next;
        }
    }


}
