import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 331. 验证二叉树的前序序列化
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 *
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 *
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 *
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 *
 * 示例 1:
 *
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * 示例 2:
 *
 * 输入: "1,#"
 * 输出: false
 * 示例 3:
 *
 * 输入: "9,#,#,1"
 * 输出: false
 * 通过次数18,448提交次数38,806
 *
 * https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/
 */

public class VerifyPreorderSerializationOfABinaryTree {

    public static void main(String[] args) {
        VerifyPreorderSerializationOfABinaryTree v = new VerifyPreorderSerializationOfABinaryTree();
        String p = "#";
        boolean t = v.isValidSerialization(p);
        if(t ){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }

    public boolean isValidSerialization(String preorder) {
        String[] strArr;
        strArr = preorder.split(","); // 分割字符串
        ArrayList<String> arr = new ArrayList<String>(Arrays.asList(strArr));
        System.out.println(arr.toString());

        return isTree(arr);
    }

    public boolean isTree(ArrayList<String> list){
        if(list.isEmpty()){
            return false;
        }else if(list.size() == 1){
            if(list.get(0).equals("#")){
                return true;
            }
            return false;
        }else if(list.size() < 3){
            return false;
        }else if(list.size() == 3){
            if(!list.get(0).equals("#") && list.get(1).equals("#") && list.get(2).equals("#")){
                return true;
            }
            return false;
        }
        int len = list.size();
        ArrayList<String> l = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if(i< len - 2 && !list.get(i).equals("#") && list.get(i+1).equals("#") && list.get(i+2).equals("#")){
                l.add("#");
                i+=2;
            }else{
                l.add(list.get(i));
            }
        }
        if(len == l.size()){
            return false;
        }
        System.out.println(l.toString());
        return isTree(l);
    }
}
