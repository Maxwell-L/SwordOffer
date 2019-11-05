/*
 * 合并两个排序的链表
 * 题目描述:
 *     输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * 思路:
 *     先生成结点result，再用一个p指向result用于移动，遍历两个链表，循环每执行一次比较两个链表目前最小值，将最小值结点添加到p，对应的链表指针向后移动；
 * 当某一个链表先遍历完成后，将另一个链表接到p后面，结果返回result.next。
 */
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class MergeSolution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode result = new ListNode(0), p = result;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        p.next = list1 == null ? list2 : list1;
        return result.next;
    }
}
