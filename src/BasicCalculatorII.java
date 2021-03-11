import java.util.ArrayList;

/**
 * 227. 基本计算器 II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 * 示例 1：
 *
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 *
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 *
 * 输入：s = " 35+53/2*7-90+34 "
 * 输出：5
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 * 通过次数56,712提交次数132,772
 *
 * https://leetcode-cn.com/problems/basic-calculator-ii/
 */
public class BasicCalculatorII {

    public static void main(String[] args) {
        BasicCalculatorII b = new BasicCalculatorII();
        int ret =  b.calculate("3+ 2*2*7*8/9  -34*45/33*36  -3*7  +99 +34 -  2*54");
        System.out.println(ret);
    }

    public int calculate(String str) {
        String s = str.replace(" ","");
        int sum = 0;
        int num = 0;
        char lastFlg = '+';
        int flg = 1;
        int x = 1;
        ArrayList<Integer> l = new ArrayList<>();

        int len = s.length();
        //第一次循环计算乘除法
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(c == '*' || c == '/'){
                lastFlg = s.charAt(i);
            }else if(c == '-'){
                num = 0;
                flg = -1;
            }else if(c == '+'){
                num = 0;
                flg = 1;
            }else {
                //计算数字大小
                num *= 10;
                num += (int)(c-'0');
                if(i == len - 1 || s.charAt(i+1) == '+' || s.charAt(i+1) == '-'){
                    System.out.println(" num:"+num);
                    if(lastFlg == '*'){
                        num *= x;
                    }else if(lastFlg == '/'){
                        num = x / num;
                    }
                    l.add(num*flg);
                    x = 1;
                    num = 0;
                    lastFlg = '+';
                }else if( s.charAt(i+1) > '9' || s.charAt(i+1) < '0'){
                    System.out.println("*/ num:"+num);
                    System.out.println("lastFlg "+lastFlg);
                    System.out.println("x "+x);

                    if(lastFlg == '*'){
                        num *= x;
                    }else if(lastFlg == '/'){
                        num = x / num;
                    }
                    x = num;
                    num = 0;
                }
            }
        }
        System.out.println(l.toString());
        for (int i = 0; i < l.size(); i++) {
            sum += l.get(i);
        }
        return sum;
    }
}
