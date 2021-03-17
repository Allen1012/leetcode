/**
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * 通过次数113,131提交次数215,544
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedListII {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode node = head;
        ListNode nLeft;
        while (node.val != left){
            node = node.next;
        }
        nLeft = node;

        node = node.next;
        while (node.val != right){
            ListNode t = node.next.next ;
            node.next = node;
            node = t;
        }


        while (node != null){
            if(node.val == left){
                ListNode t = node.next ;
                node.next = node;
                node = t;
            }else if(node.val == right){

            }else {
                node = node.next;
            }
        }
        nLeft = node;





        while (node.next.val != right){
            node = node.next;
        }
        return head;
    }
}
