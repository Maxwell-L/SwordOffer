/*
 * 两个链表的第一个公共结点
 * 题目描述:
 *     输入两个链表，找出它们的第一个公共结点。
 * 
 * 思路:
 *     遍历两个链表获取长度，使得第一个链表不长于第二个链表，让第二个链表（长链表）先移动到与第一个链表相同长，然后依次比较两个
 * 两个链表的指针是否相等，返回相等时的指针。
 */
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class FindFirstCommonNodeSolution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0, len2 = 0;
        ListNode p1 = pHead1, p2 = pHead2;
        while(p1 != null || p2 != null){
            if(p1 != null){
                len1++;
                p1 = p1.next;
            }
            if(p2 != null) {
                len2++;
                p2 = p2.next;
            }
        }
        if(len1 > len2){
            return FindFirstCommonNode(pHead2, pHead1);
        }
        int sub = len2 - len1;
        p1 = pHead1;
        p2 = pHead2;
        while(sub > 0){
            p2 = p2.next;
            sub--;
        }
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}

