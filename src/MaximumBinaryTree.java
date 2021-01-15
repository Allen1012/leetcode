/**
 * 654. Maximum Binary Tree
 * 654. 最大二叉树
 *
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 *
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumBinaryTree {

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


    public TreeNode constructMaximumBinaryTree(int[] nums) {

        TreeNode root = getNode(nums,0,nums.length-1);

        return root;
    }

    public TreeNode getNode(int[] nums,int start,int end){
        TreeNode root = new TreeNode();
        if(nums.length == 0 || start > end){
            return null;
        }
        if(nums.length == 1 || start == end){
            root.val = nums[start];
            return root;
        }

        //获取最大元素
        int index = start;
        int max = nums[start];
        for (int i = start; i <= end; i++) {
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        root.val = max;
        root.left = getNode(nums,start,index-1);
        root.right = getNode(nums,index+1,end);
        return root;

    }
}
