/*
 * 链表中倒数第k个结点
 * 题目描述:
 *     输入一个链表，输出该链表中倒数第k个结点。
 *
 * 思路:
 *     1、如果k小于等于0，则直接返回null;
 *     2、k不为0，先遍历一遍链表获取链表长度(可用快慢指针提升效率)，定义result结点，若k大于length，则循环不执行，result.next为null；若k合法，则
 *     依次将结点赋给result.next，直到第k个。
 */
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class FindKthToTailSolution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(k <= 0) {
            return null;
        }
        int length = 0;
        ListNode p = head;
        while(p != null) {
            length++;
            p = p.next;
        }
        ListNode result = new ListNode(0);
        for(int i = 0; i <= length - k; i++){
            result.next = head;
            head = head.next;
        }
        return result.next;
    }
}
