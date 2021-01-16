import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *
 *
 * 提示：
 *
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthBinaryTree {
    public static int i = 0;

    public static void main(String[] args) {

        Integer[] root = {3,9,20,null,null,15,7};

        //构建测试 二叉树
        //队列
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode tree = new TreeNode();

        q.add(tree);
        int r = 0;
        while (!q.isEmpty()){
            if(r >= root.length ){
                break;
            }
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode node = q.poll();
                if(root[r] != null){
                    node.val = root[r];
                    node.left = new TreeNode();
                    q.offer(node.left);

                    node.right = new TreeNode();
                    q.offer(node.right);
                }else {
//                    node = null;
                }
                r++;
            }
        }

        MinimumDepthBinaryTree test = new MinimumDepthBinaryTree();
        int deep = test.minDepth(tree);
        System.out.println(deep);

    }

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int deep = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int sz = queue.size();
            for(int i = 0; i<sz;i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null){
                    return deep;
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            deep++;
        }
        return deep;
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}



