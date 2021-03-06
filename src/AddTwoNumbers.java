/**
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list = new ListNode();
        ListNode temp = list;
        int t = 0;
        int n1;
        int n2;
        while (l1 != null || l2 != null){
            if(l1 == null){
                n1 = 0;
            }else {
                n1 = l1.val;
                l1 = l1.next;
            }
            if(l2 == null){
                n2 = 0;
            }else {
                n2 = l2.val;
                l2 = l2.next;
            }
            t = t + n1 + n2;

            temp.val = t % 10 ;
            System.out.println(" "+temp.val);
            if(t>=10){
                t = 1;
            }else {
                t = 0;
            }

            if(!(l1 == null && l2 == null)){
                temp.next = new ListNode();
                temp = temp.next;
            }
            if(l1 == null && l2 == null && t == 1){
                temp.next = new ListNode(1);
                temp = temp.next;
            }


        }
//        System.out.println(list.toString());

        return list;
    }

}
