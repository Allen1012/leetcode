/**
 * 147. 对链表进行插入排序
 * 对链表进行插入排序。
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * 通过次数76,140提交次数113,375
 *
 * https://leetcode-cn.com/problems/insertion-sort-list/
 */
public class InsertionSortList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode ret = new ListNode(head.val);
        head = head.next;
        System.out.println( ret.val);
//        ListNode temp = ret;
        while (head!=null){
            System.out.println("head: " + head.val);
            if(ret.val >= head.val){
                ListNode temp = new ListNode(0,ret);
                temp.val = head.val;
//                ListNode n = new ListNode(head.val);
                ret = temp;
//                ret.next = n;
            }else {
                if(ret.next == null){
                    ret.next = new ListNode(head.val);
                }else{
                    ListNode t = ret;
                    // boolean isAdd = false;
                    while (t.next!=null){
                        if(t.next.val >= head.val){
                            ListNode tt = new ListNode(head.val,t.next);
                            t.next = tt;
                            // isAdd = true;
                            break;
                        }
                        t = t.next;
                    }
                    if(t.next == null){
                        t.next = new ListNode(head.val);

                    }
                }

            }
            head = head.next;
        }


        return ret;
    }
}
