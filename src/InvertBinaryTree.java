/**
 * 226. 翻转二叉树
 *
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InvertBinaryTree {
    public static void main(String[] args) {

        InvertBinaryTree c = new InvertBinaryTree();

        int[] treeArr = {4,2,7,1,3,6,9};

        TreeNode n = null;

        TreeNode tree = c.buildTree(treeArr);

        System.out.println(tree.toString());

        c.printTree(tree);

        TreeNode t = c.invertTree(tree);

    }

    public void printTree(TreeNode root){

        System.out.printf(" " + root.val);

        if(root.right != null){
            printTree(root.right);
        }

        if(root.left != null){
            printTree(root.left);
        }
    }

    public void setTree(TreeNode root,TreeNode val){
        if(root.left == null){
            root.left = val;
            return;
        }else if(root.right == null){
            root.right = val;
            return;
        }else {
            if(root.left.right == null){
                setTree(root.left,val);
                return;
            }
            if(root.right.right == null){
                setTree(root.right,val);
                return;
            }
            setTree(root.left,val);

        }
    }

    public TreeNode  buildTree(int[] treeArr){
        if(treeArr.length < 1){
            return null;
        }
        TreeNode root = new TreeNode(treeArr[0]);

        for (int i = 1; i < treeArr.length; i++) {
            TreeNode t = new TreeNode(treeArr[i]);
            setTree(root,t);
        }
        return root;
    }


    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left != null){
            invertTree(root.left);
        }
        if(root.right != null){
            invertTree(root.right);
        }
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}


