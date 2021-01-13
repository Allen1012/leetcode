/**
 * 114. Flatten Binary Tree to Linked List
 */
public class FlattenBinaryTreeToLinkedList {
    
    /**
     * Definition for a binary tree node.
     */
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

    public void flatten(TreeNode root) {
         // 空树直接返回
        if(root == null){
            return;
        }
        //左节点不为空 将左节点移植右节点 将右节点加入树中
        if(root.left != null){
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            addToTree(root.right,temp);
        }
        flatten(root.right);
    }

    //将结点加至root的第一个空最右节点
    public void addToTree(TreeNode root,TreeNode temp){

         if(root.right == null){
             root.right = temp;
         }else{
             addToTree(root.right,temp);
         }

    }

}
