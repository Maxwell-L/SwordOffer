/*
 * 删除链表中重复的结点
 * 题目描述:
 *     在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5。
 *
 * 思路:
 *     设置三个结点分别指向当前结点、前一个结点、后一个节点，当当前结点与前后值都不同时，加入链表。
 */
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class DeleteDuplicationSolution {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode myHead = new ListNode(0);
        ListNode pre = null, cur = pHead, aft = null, p = myHead;
        while(cur != null) {
            aft = cur.next;
            if(((pre == null || cur.val != pre.val)) && (aft == null || cur.val != aft.val)) {
                p.next = cur;
                p = p.next;
            }
            pre = cur;
            cur = aft;
        }
        p.next = null;
        return myHead.next;
    }
}

