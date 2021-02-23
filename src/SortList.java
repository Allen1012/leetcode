import java.util.ArrayList;
import java.util.Comparator;

/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 * 通过次数140,008提交次数207,299
 *
 * https://leetcode-cn.com/problems/sort-list/
 */
public class SortList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {

        if(head == null){
            return head;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        if(list.size() == 1){
            return head;
        }
        list.sort(new Comparator<Integer>(){
            public int compare(Integer arg0 , Integer arg1 ) {
                return arg0 .compareTo( arg1); //这是顺序
            }
        });

        System.out.println(list);

        ListNode n = new ListNode(list.get(0));
        ListNode temp = new ListNode();
        n.next = temp;
        for (int i = 1; i < list.size(); i++) {
            temp.val = list.get(i);
            if(i < list.size() -1){
                temp.next = new ListNode();
                temp = temp.next;
            }
        }
        return n;
    }
}
