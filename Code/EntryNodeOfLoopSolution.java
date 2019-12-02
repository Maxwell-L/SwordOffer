/*
 * 链表中环的入口结点
 * 题目描述:
 *     给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * 思路:
 *     设置快慢指针遍历链表，若链表不存在环，则存在null结点，可以直接返回null。若存在环，则快慢指针在遍历过程中会指向同一个结点，
 * 假设链表头距离环入口结点为x，入口结点距离快慢指针指向同一个结点的距离为k，入口结点距离链表尾的距离为n，则慢指针此时走过的路程
 * 为 x + k，快指针走过的路程为 x + n + k，故有 n = x + k，所以链表以入口结点和快慢指针指向的结点为分割点，三段的长度分别为 x, k,
 * x，此时快慢指针在第二个点也即是第三段的起点，令其中一个结点指向链表头，同时往后遍历，当两个指针指向同一个结点时，该结点即为环
 * 的入口结点。
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
public class EntryNodeOfLoopSolution {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = pHead, fast = pHead;
        while(fast != null && fast.next != null) {
            fast = fast.next == null ? null : fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                fast = pHead;
                while(fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}

