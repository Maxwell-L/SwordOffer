/*
 * 复杂链表的复制
 * 题目描述:
 *     输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 思路:
 *     1、遍历链表，先按next的顺序将链表复制一遍，并将每个结点连接在原结点后。
 *     2、第一步后链表奇数位为原链表结点，偶数位为复制链表结点，奇数位的random结点的后一位既是奇数位后一位结点的random结点。
 *     3、将偶数位结点取出组成链表。
 */
/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class CloneSolution {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) {
            return null;
        }
        RandomListNode pointer = pHead;
        while(pointer != null) {
            RandomListNode temp = new RandomListNode(pointer.label);
            temp.next = pointer.next;
            pointer.next = temp;
            pointer = temp.next;
        }
        pointer = pHead;
        while(pointer != null){
            if(pointer.random != null){
                pointer.next.random = pointer.random.next;
            }
            pointer = pointer.next.next;
        }
        pointer = pHead;
        RandomListNode myHead = pHead.next, p = pHead.next;
        pointer.next = p.next;
        pointer = pointer.next;
        while(pointer != null){
            p.next = pointer.next;
            p = p.next;
            pointer.next = p.next;
            pointer = pointer.next;
        }
        return myHead;
    }
}
