import java.util.ArrayList;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * 116. Populating Next Right Pointers in Each Node
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulatingNextRightPointersInEachNode {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

//    [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31]

    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        if(root.left == null){
            return root;
        }
        connectTwoNode(root.left,root.right);
//        ArrayList<Node> list = new ArrayList<>();
//        list.add(root);
//        bfs(list);
        return root;
    }

    public void connectTwoNode(Node n1,Node n2){
        if(n1 == null || n2 == null){
            return;
        }

        /**** 前序遍历位置 ****/
        // 将传入的两个节点连接
        n1.next = n2;

        // 连接相同父节点的两个子节点
        connectTwoNode(n1.left,n1.right);
        connectTwoNode(n2.left,n2.right);
        // 连接跨越父节点的两个子节点
        connectTwoNode(n1.right,n2.left);
    }

    public void bfs(ArrayList<Node> list){
        ArrayList<Node> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Node t = list.get(i);
            if(i + 1 < list.size()){
                t.next = list.get(i+1);
            }
            if(t.left != null){
                newList.add(t.left);
                newList.add(t.right);
            }
        }
        list.clear();
        list.addAll(newList);

        if(newList.size()>0){
            bfs(list);
        }
    }

}
