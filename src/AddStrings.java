/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 *
 *
 * 提示：
 *
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 * 通过次数94,787提交次数182,512
 *
 * https://leetcode-cn.com/problems/add-strings/
 */
public class AddStrings {
    public static void main(String[] args) {
        AddStrings a = new AddStrings();
        String num1 = "0";
        String num2 = "0";
        String ret = a.addStrings(num1,num2);
        System.out.println(" kk="+ret);
    }
    public String addStrings(String num1, String num2) {
        StringBuffer sum = new StringBuffer();
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int next = 0;
        while (len1 >= 0 || len2 >= 0){
            int a1 = 0;
            int a2 = 0;
            if(len1 >= 0){
                a1 = (int)(num1.charAt(len1) - '0');
            }
            if(len2 >= 0){
                a2 = (int)(num2.charAt(len2) - '0');
            }
            int su = next + a1+a2;
            System.out.println( a1 + " : " + a2 + " : " + next + " = " + su);
            next = (int) su / 10;
            sum.append(su%10);
            len1--;
            len2--;
        }
        if(next > 0){
            sum.append(next);
        }
        System.out.println(sum);
        StringBuffer ret = new StringBuffer();
        for (int i = sum.length()-1; i >= 0; i--) {
            ret.append(sum.charAt(i));
        }
        System.out.println(ret.toString());
        return ret.toString();
    }
}
