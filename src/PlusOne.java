import java.util.LinkedList;

/**
 * 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * 通过次数253,659提交次数556,343
 *
 * https://leetcode-cn.com/problems/plus-one/
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length - 1;
        LinkedList<Integer> list = new LinkedList<>();
        int t = 1;
        while (len >= 0){
            if(t + digits[len] == 10){
                list.add(0);
                t = 1;

            }else {
                list.add(digits[len] + t);
                t = 0;

            }
            len--;

        }
        if(t == 1){
            list.add(1);
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(list.size()-1- i);
        }
        return ret;
    }
}
