import java.util.ArrayList;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 难度
 * 中等
 *
 * 1202
 *
 *
 *
 *
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {


        ArrayList<ListNode> list = new ArrayList<>();

        ListNode node = head;
        list.add(node);
        while (node.next != null){
            node = node.next;
            list.add(node);
        }
        int i = list.size() - n;
        if(i == 0){
            return head.next;
        }
        ListNode temp = list.get(i-1);
        if(n == 1){
            temp.next = null;
            return head;
        }
        temp.next = list.get(i+1);

        return head;
    }
}
