import java.util.LinkedList;

/**
 * 297. 二叉树的序列化与反序列化
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例:
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 *
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeAndDeserializeBinaryTree {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

         if(root == null){
             return "[]";
         }

         StringBuffer str = new StringBuffer();
         str.append("[");

         LinkedList<TreeNode> list = new LinkedList<>();
        str.append(root.val);
         if(root.left == null){
             str.append(",null");
         }else {
             str.append(","+root.left.val);
             list.offer(root.left);
         }
        if(root.right == null){
            str.append(",null");
        }else {
            str.append("," + root.right.val);
            list.offer(root.right);
        }
         while (!list.isEmpty()){
             TreeNode r =  list.pollFirst();

             if(r.left == null){
                 str.append(",null");
             }else {
                 str.append("," + r.left.val);
                 list.offer(r.left);
             }
             if(r.right == null){
                 str.append(",null");
             }else {
                 str.append("," + r.right.val);
                 list.offer(r.right);
             }
         }
        str.append("]");


        return new String(str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         if(data.equals("[]")){
             return null;
         }

        String str1 = data.substring(1,data.length()- 1);
        System.out.println(str1);
        String[] strArr = str1.split(",");

        TreeNode tree = new TreeNode(Integer.valueOf(strArr[0]));
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(tree);
        int j = 1;

        while (!list.isEmpty()){
            TreeNode root = list.pollFirst();
            if(j<strArr.length ){
                if( !strArr[j].equals("null")){
                    root.left = new TreeNode(Integer.valueOf(strArr[j]));
                    list.offer(root.left);
                }
                j++;
                if(!strArr[j].equals("null")){
                    root.right = new TreeNode(Integer.valueOf(strArr[j]));
                    list.add(root.right);
                }
                j++;
            }
        }

        System.out.println("-----------------");
        printTree(tree);
        System.out.println("-----------------");

        System.out.println(strArr.toString());

        return tree;
    }

    public void printTree(TreeNode root){
         if(root != null){
             System.out.printf(" "+root.val);
             printTree(root.left);
             printTree(root.right);
         }else {
             System.out.printf(" null");
         }

    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree c = new SerializeAndDeserializeBinaryTree();
        String str = "[1,2,3,6,7,4,5]";
        TreeNode root = c.deserialize(str);
        String str1 = c.serialize(root);
        System.out.println(str1);
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
