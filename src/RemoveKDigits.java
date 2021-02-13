import java.util.LinkedList;

/**
 * 402. 移掉K位数字
 * 难度
 * 中等
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 * https://leetcode-cn.com/problems/remove-k-digits/
 */
public class RemoveKDigits {
    public static void main(String[] args) {
        RemoveKDigits r = new RemoveKDigits();
        r.removeKdigits("4276785461579082029294483184071494",12);
    }

    public String removeKdigits(String num, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        if(num.length() == k){
            return "0";
        }

        for (int i = 0; i < num.length(); i++) {
            list.add((int)(num.charAt(i) - '0'));
        }

//        while (k>0 && list.size() > 0){
//            boolean hasRemove = false;
            int size = list.size();

            for (int i = 0; i < size - 1; i++) {
                System.out.println("size:"+size + "  k:"+k + "  i: "+i);

                if(k>0 && list.get(i) > list.get(i+1)){
                    System.out.println("remove:"+list.get(i) + " i+1 = "+list.get(i+1));
                    System.out.println(list.toString());
                    list.remove(i);
                    k--;
                    i--;
                    if(i>-1){
                        i--;
                    }

                    size--;

                }
            }
            while (k>0){
                list.removeLast();
                k--;
            }

//        }

        System.out.println(list.toString());

        StringBuffer str = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            if(!(str.length() == 0 && list.get(i) == 0)){
                str.append(""+list.get(i));
            }

        }
        if(str.toString().isEmpty()){
            return "0";
        }
        return str.toString();
    }
}
