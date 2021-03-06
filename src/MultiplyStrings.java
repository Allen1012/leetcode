/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * 通过次数126,884提交次数283,521
 *
 *https://leetcode-cn.com/problems/multiply-strings/
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        MultiplyStrings m = new MultiplyStrings();
        String num1 = "1";
        String num2 = "2";
        String ret = m.multiply(num1,num2);
    }
    int[] s ;
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        s = new int[num1.length()+num2.length()];

        int sum = 0;
        int ten = 0;

        for (int i = num1.length()-1; i >= 0; i--) {
            System.out.println(num1.charAt(i));
            int ten2 = 0;
            for (int j = num2.length()-1; j >= 0 ; j--) {
                int a1 = num1.charAt(i) - '0';
                int a2 = num2.charAt(j) - '0';

//                sum += a1*a2* ten*ten2;
                addToArr(a1*a2,ten+ten2);

                System.out.println(a1*a2);
                ten2 += 1;
            }
            ten += 1;
        }

        StringBuffer str = new StringBuffer();
        if(s[s.length-1] >0){
            str.append(""+s[s.length-1]);
            System.out.printf(""+s[s.length-1]);
        }
        for (int i = s.length-2; i >=0; i--) {
            str.append(""+s[i]);
            System.out.printf(""+s[i]);
        }
        System.out.println("ret =" + str.toString());
        return "";
    }

    public void addToArr(int n,int ind){
        s[ind] += n;
        while (s[ind]/10 >0){
            int ten = s[ind]/10;
            s[ind] = s[ind]%10;
            ind++;
            s[ind] += ten;
        }
    }
}






















