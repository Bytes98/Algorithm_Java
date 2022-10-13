package lists;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 98Bytes
 * @Date: 2022/05/10/8:56
 * @Description:
 */
//class ListNode{
//    int val;
//    ListNode next;
//    ListNode(){};
//    ListNode(int val) {
//        this.val=val;
//    }
//    ListNode(int val, ListNode next){
//        this.val = val;
//        this.next = next;
//    }
//}


public class MyLinkedListImpl implements MyLinkedList {
    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
    //size存储链表元素的个数
    int size;
    //虚拟头结点
    ListNode head;
    public MyLinkedListImpl() {
        size = 0;
        head = new ListNode();
    }

    @Override
    // 获取链表中第 index 个节点的值。如果索引无效，则返回-1。
    public int get(int index) {
        if(index<0 || index >= size) return -1;
        int result = 0;
        ListNode cur = head;
        while(index>0){
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    @Override
    //在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
    public void addAtHead(int val) {
        if(size==0){
            head.val = val;
        }else{
            ListNode tempNode = new ListNode(val);
            tempNode.next = head;
            head = tempNode;
        }
        size ++;
    }

    @Override
    // 将值为 val 的节点追加到链表的最后一个元素。
    public void addAtTail(int val) {
        if(size==0){
            head.val = val;
        }else{
            ListNode cur = head;
            while(cur.next!=null){
                cur = cur.next;
            }
            cur.next = new ListNode(val);
        }
        size++;
    }

    @Override
    // 在链表中的第index个节点之前添加值为val 的节点。
    // 如果index == 链表的长度，则该节点将附加到链表的末尾。
    // 如果index > 链表长度，则不会插入节点。
    // 如果index < 0，则在头部插入节点。
    public void addAtIndex(int index, int val) {
        if(index>size) return;

//      dummy->0->1->2->3
        if(index<0){
            addAtHead(val);
        }else if(index==size){
            addAtTail(val);
        }else{
            ListNode dummyHead = new ListNode();
            dummyHead.next = head;
            ListNode cur = dummyHead;
            while(index>0){
                cur = cur.next;
                index--;
            }
            ListNode newNode = new ListNode(val);
            ListNode tempNode = cur; // 1
            newNode.next = tempNode.next;
            cur.next = newNode;

            head = dummyHead.next;
            size++;
        }

    }

    @Override
    // 如果索引 index 有效，则删除链表中的第 index 个节点。
    public void deleteAtIndex(int index) {
        if(index>size || index<0 ||index==size ){
            return;
        }else{
            // dummyHead->0->1->2->3
            ListNode dummyHead = new ListNode();
            dummyHead.next = head;
            ListNode cur = dummyHead;
            while(index>0){
                cur = cur.next;
                index--;
            }
            cur.next =cur.next.next;

            head = dummyHead.next;
            size--;
        }


    }

    public void show(){
        System.out.print("size:"+size+" list:");
        ListNode cur = head;
        while(cur.next!=null){
            System.out.print(cur.val+"->");
            cur = cur.next;
        }
        System.out.println(cur.val);
    }



    public static void  main(String[] args){
        MyLinkedListImpl linkedList =new MyLinkedListImpl();

        linkedList.addAtHead(2); linkedList.show();
        linkedList.deleteAtIndex(1); linkedList.show();
        linkedList.addAtHead(2); linkedList.show();
        linkedList.addAtHead(7); linkedList.show();
        linkedList.addAtHead(3); linkedList.show();
        linkedList.addAtHead(2); linkedList.show();
        linkedList.addAtHead(5); linkedList.show();
        linkedList.addAtTail(5); linkedList.show();
        System.out.print(linkedList.get(5)+" "); linkedList.show();
        linkedList.deleteAtIndex(6); linkedList.show();
        linkedList.deleteAtIndex(4); linkedList.show();


    }
}
