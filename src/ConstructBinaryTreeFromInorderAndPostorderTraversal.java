/**
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal c = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode t = c.buildTree(inorder,postorder);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0){
            return null;
        }
        TreeNode root = subTree(inorder,0,inorder.length -1,postorder,0,postorder.length -1);
        return root;
    }
    public TreeNode subTree( int[] inorder, int iStart, int iEnd,int[] postorder, int pStart, int pEnd){
        if(pStart > pEnd || pEnd < 0){
            return null;
        }
        TreeNode root = new TreeNode(postorder[pEnd]);
        if(pStart == pEnd){
            return root;
        }
        int head = postorder[pEnd];
        int index = iStart;
        for (int i = iStart; i <= iEnd; i++) {
            if(inorder[i] == head){
                index = i;
                break;
            }
        }
        root.left = subTree(inorder,iStart,index - 1,postorder,pStart ,pStart + index - iStart - 1);
        root.right = subTree(inorder,index + 1,iEnd,postorder,pStart + index - iStart,pEnd - 1);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
