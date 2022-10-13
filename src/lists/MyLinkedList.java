package lists;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/10/8:52
 * @Description:
 */
public interface MyLinkedList {

    // 获取链表中第 index 个节点的值。如果索引无效，则返回-1。
    int get(int index);

    //在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
    void addAtHead(int val);

    // 将值为 val 的节点追加到链表的最后一个元素。
    void addAtTail(int val);

    // 在链表中的第index个节点之前添加值为val 的节点。
    // 如果index == 链表的长度，则该节点将附加到链表的末尾。
    // 如果index > 链表长度，则不会插入节点。
    // 如果index < 0，则在头部插入节点。
    void addAtIndex(int index, int val);

    // 如果索引 index 有效，则删除链表中的第 index 个节点。
    void deleteAtIndex(int index);
}
