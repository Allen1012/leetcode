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
 *
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
            if(left == right){
                return head;
            }
            ListNode prev = null;
            ListNode cure = head;
            ListNode l = null;
            int ind = 1;
            while (cure != null && ind != left){
                l = cure ;
                cure = cure.next;
                ind++;
            }
            if(cure == null){
                return head;
            }

            ListNode sl = cure ;
            while (cure != null && ind != right){
                ListNode next = cure.next ;
                cure.next = prev;
                prev = cure;
                cure = next;
                ind++;
            }
            // ListNode next = cure.next ;
            sl.next = cure.next;
            if(1 == left){
                cure.next = prev;
                return cure;
            }
            l.next = cure;
            cure.next = prev;

            return head;
        }
}
