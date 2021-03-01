/**
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 * 通过次数594,555提交次数1,699,503
 *
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger r = new ReverseInteger();
        int ret = r.reverse(153423646);
        System.out.println(ret);
    }

    public int reverse(int x) {
//        2147483647
//          1534236469
//        1234567890

        System.out.println(Integer.MAX_VALUE);
        int ret = 0;
        while (x != 0){
            if(ret > Integer.MAX_VALUE / 10 || ret < -Integer.MAX_VALUE / 10){
                return 0;
            }
            ret = 10*ret + x %10;
            System.out.println(ret);
            x = x/10;
        }
        return ret;
    }
}
