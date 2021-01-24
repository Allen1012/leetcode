import java.util.ArrayList;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestorOfABinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    boolean findP = false;
    boolean findQ = false;
    ArrayList<TreeNode> fPList = new ArrayList<>();
    ArrayList<TreeNode> fQList = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        ArrayList<TreeNode> pList = new ArrayList<>();
        ArrayList<TreeNode> qList = new ArrayList<>();

        getList(list,root,p,q,pList,qList);

        System.out.println("pList:");
        for (int i = 0; i < pList.size(); i++) {
            System.out.printf(" " + pList.get(i).val);
        }
        System.out.println("--------------------");

        System.out.println("qList:");
        for (int i = 0; i < qList.size(); i++) {
            System.out.printf(" " + qList.get(i).val);
        }
        System.out.println("--------------------");

        if(qList.isEmpty() && !pList.isEmpty()){
            return root;
        }
        if(pList.isEmpty() && !qList.isEmpty()){
            return root;
        }
        TreeNode temp = null;
        while(!qList.isEmpty()) {
            if(pList.isEmpty()){
                return temp;
            }
            TreeNode pp = pList.remove(0);
            TreeNode qq = qList.remove(0);
            System.out.println("qq " + qq.val + "==  pp "+pp.val);
            System.out.println("qq.lenght " + qList.size());
            System.out.println("pp.lenght " + pList.size());
            if(pp.val == qq.val){
                temp = pp;
                System.out.println("== " + qq.val);
            }else {
                System.out.println("!= " + qq.val);
                return  temp;
            }
        }

        return temp;
    }



    //    public ArrayList<TreeNode> list = new ArrayList<>();
    public void getList(ArrayList<TreeNode> list,TreeNode root,TreeNode p,TreeNode q ,ArrayList<TreeNode> pList,ArrayList<TreeNode> qList){
//        ArrayList<TreeNode> newList = new ArrayList<>(list);
        if(!findQ){
            qList.add(root);
        }
        if(!findP){
            pList.add(root);
        }
        if(root == p){
            findP = true;
            fPList.addAll(pList);
        }
        if(root == q){
            findQ = true;
            fQList.addAll( qList);
        }
        if(findP && findQ){
            return ;
        }
        if(root.left != null){
            getList(list,root.left,p,q,pList,qList);
        }
        if(root.right != null){
            getList(list,root.right,p,q,pList,qList);
        }
        if(!findQ){
            qList.remove(qList.size() -1);
        }
        if(!findP){
            pList.remove(pList.size() -1);
        }
        return;
    }


}
