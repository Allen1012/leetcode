/**
 * 1373. 二叉搜索子树的最大键值和
 * 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
 *
 * 二叉搜索树的定义如下：
 *
 * 任意节点的左子树中的键值都 小于 此节点的键值。
 * 任意节点的右子树中的键值都 大于 此节点的键值。
 * 任意节点的左子树和右子树都是二叉搜索树。
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
 * 输出：20
 * 解释：键值为 3 的子树是和最大的二叉搜索树。
 * 示例 2：
 *
 *
 *
 * 输入：root = [4,3,null,1,2]
 * 输出：2
 * 解释：键值为 2 的单节点子树是和最大的二叉搜索树。
 * 示例 3：
 *
 * 输入：root = [-4,-2,-5]
 * 输出：0
 * 解释：所有节点键值都为负数，和最大的二叉搜索树为空。
 * 示例 4：
 *
 * 输入：root = [2,1,3]
 * 输出：6
 * 示例 5：
 *
 * 输入：root = [5,4,8,3,null,6,3]
 * 输出：7
 *
 *
 * 提示：
 *
 * 每棵树最多有 40000 个节点。
 * 每个节点的键值在 [-4 * 10^4 , 4 * 10^4] 之间。
 *
 * https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree/
 */
public class MaximumSumBSTInBinaryTree {
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

    int maxNum = 0;
    public int maxSumBST(TreeNode root) {
        if(root == null){
            return 0;
        }
        isBST(root);
        return maxNum;
    }

    public int[] isBST(TreeNode root){
        int[] ret = new int[4];
        ret[0] = 0;
        ret[1] = 0;
        if(root == null){
            ret[0] = 1;
            ret[1] = 0;
            return  ret;
        }

        if(root.left == null && root.right == null){
            maxNum = Math.max(maxNum,root.val);
            ret[0] = 1;
            ret[1] = root.val;
            ret[2] = root.val;
            ret[3] = root.val;
            return  ret;
        }

        int[] left = isBST(root.left);
        int[] right = isBST(root.right) ;

        if(root.left != null){
            if(root.val <= root.left.val || root.val < left[3]){
                return ret;
            }
            ret[2] = Math.min(root.val,left[2]);
        }else{
            ret[2] = root.val;
        }

        if(root.right != null){
            if(root.val >= root.right.val || root.val>right[2]){
                return ret;
            }
            ret[3] = Math.max(root.val,right[3]);
        } else{
            ret[3] = root.val;
        }

        if(left[0] > 0 && right[0] > 0 ){
            ret[0] = 1;
            ret[1] = root.val + left[1] + right[1];
            maxNum = Math.max(maxNum,ret[1]);
            return ret;
        }

        return ret;
    }
}
