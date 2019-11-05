/*
 * 反转链表
 * 题目描述:
 *     输入一个链表，反转链表后，输出新链表的表头。
 *
 * 思路:
 *     1、如果链表为空或者只有一个元素，反转后是它自身，直接返回其原来的链表头。
 *     2、链表长度大于1，定义前一个结点pre, 当前结点cur指向head，下一个结点指向cur.next; while循环当当前结点为空时跳出，循环内依次完成结点指向的
 *     翻转和向后移动。跳出循环时cur为空，故pre为原链表的表尾，也即反转后的表头，返回pre。
 */
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class ReverseListSolution {
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head, next = head.next;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
