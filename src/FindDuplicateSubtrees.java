import java.util.ArrayList;
import java.util.List;

/**
 * 652. 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 */
public class FindDuplicateSubtrees {
    public class TreeNode {
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

    //要返回的list
    ArrayList<TreeNode> list = new ArrayList<>();

    //记录所有的结点
    ArrayList<TreeNode> allNodes = new ArrayList<>();
    //记录所有的子树
    ArrayList<ArrayList<Integer>> allSubTree = new ArrayList<>();

    //记录访问过的子树
    ArrayList<ArrayList<Integer>> maps = new ArrayList<>();
    //记录访问过的子树 控制仅访问一次
    ArrayList<ArrayList<Integer>> maps1 = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root == null){
            return list;
        }
        if(root.left == null && root.right == null){
            return list;
        }
        subTree(root);

        for (int i = 0; i < allNodes.size(); i++) {
            ArrayList<Integer> subTree = allSubTree.get(i);
            if(maps.contains(subTree)){
                if(!maps1.contains(subTree)){
                    maps1.add(subTree);
                    list.add(allNodes.get(i));
                }
            }else {
                maps.add(subTree);
            }
        }
        return list;
    }

    public ArrayList<Integer> subTree(TreeNode root){
        ArrayList<Integer> l = new ArrayList<>();
        if(root == null){
            l.add(null);
            return l;
        }

        if(root.left != null){
            l.addAll(subTree(root.left));
        }else {
            l.add(null);
        }
        if(root.right != null){
            l.addAll(subTree(root.right));
        }else {
            l.add(null);
        }
        allNodes.add(root);
        l.add(root.val );
        allSubTree.add(l);
        return l;
    }
}
