package lists;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/07/8:53
 * @Description:
 */
public class ListNode {
    // 结点的值
    int val;
    // 下一个结点
    ListNode next;

    // 节点的构造函数(无参)
    ListNode() {}
    // 节点的构造函数(有一个参数)
    ListNode(int val) { this.val = val; }
    // 节点的构造函数(有两个参数)
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
