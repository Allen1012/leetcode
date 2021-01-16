/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        TreeNode root = subTree(preorder,0,preorder.length -1,inorder,0,inorder.length -1);
        return root;
    }

    public TreeNode subTree(int[] preorder,int pStart,int pEnd, int[] inorder,int iStart,int iEnd){
        if(pStart > pEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStart]);
        if(pStart == pEnd){
            return root;
        }
        int head = preorder[pStart];
        int index = 0;
        for (int i = iStart; i <= iEnd; i++) {
            if(inorder[i] == head){
                index = i;
                break;
            }
        }
        root.left = subTree(preorder,pStart + 1,pStart + index - iStart,inorder,iStart,index - 1);
        root.right = subTree(preorder,pStart + index - iStart + 1,pEnd,inorder,index + 1,iEnd);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

