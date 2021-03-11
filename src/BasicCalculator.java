import java.util.LinkedList;

/**
 * 224. 基本计算器
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 *
 * 示例 1：
 *
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 *
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * 通过次数42,382提交次数103,825
 *
 * https://leetcode-cn.com/problems/basic-calculator/
 */
public class BasicCalculator {

    public static void main(String[] args) {
        BasicCalculator b = new  BasicCalculator();
        int ret = b.calculate("-(1-(4+5+2)-3)  -(6+8)");
//        int ret = b.calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(ret);
    }
    //输入：s = "(1+(4+5+2)-3)+(6+8)"
    public int calculate(String str) {
        String s = str.replace(" ","");
        LinkedList<Boolean> l = new LinkedList<Boolean>();
        int count = 0 ;
        int sum = 0;
        int num = 0;
        int flg = 1;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '('){
                num = 0;
                flg = 1;
                if(i == 0){
                    l.add(false);
                }
                continue;
            }else if(c == ')'){
                System.out.println("count" + count);
                boolean t = l.removeLast();
                if(t){
                    count--;
                }
            }else if(c == '-'){
                if(s.charAt(i+1) == '('){
                    l.add(true);
                    count++;
                }

                num = 0;
                flg = -1;
            }else if(c == '+'){
                if(s.charAt(i+1) == '('){
                    l.add(false);
                }
                num = 0;
                flg = 1;
            }else {
                //如果stack中
                num *= 10;
                num += (int)(c-'0');
                if(i == len - 1 || s.charAt(i+1) > '9' || s.charAt(i+1) < '0'){
                    if(count % 2 == 0){
                        sum += flg * num;

                    }else {
                        sum -= flg * num;
                    }
                    System.out.println("sum :"+sum + " num:"+num);
                }
            }
        }

        return sum;
    }
}









































