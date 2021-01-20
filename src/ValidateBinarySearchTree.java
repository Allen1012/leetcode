/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {
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
    public int status ; // -1:未开始 0:开始 1:失败
    public int temp ;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        status = -1;
        getNodeVal(root);
        if(status == 0){
            return true;
        }
        return false;
    }


    public void getNodeVal(TreeNode root){
        if(root == null){
            return ;
        }
        getNodeVal(root.left);
        if(status == -1){ //第一次
            temp = root.val;
            status = 0;
        }else if(status == 0){ //开始
            if(temp < root.val){
                temp = root.val;
            }else{
                status = 1; //失败
            }

        }
        getNodeVal(root.right);
    }
}

















