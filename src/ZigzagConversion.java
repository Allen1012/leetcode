import java.util.ArrayList;

/**
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 * 通过次数219,060提交次数441,249
 *
 * https://leetcode-cn.com/problems/zigzag-conversion/
 */
public class ZigzagConversion {

    public static void main(String[] args) {
        ZigzagConversion z = new ZigzagConversion();
        String s = "0123456789abcdefghijklmnopqrstuvwxyz";
        int numRows = 5;
        z.convert(s,numRows);
    }

    public String convert(String s, int numRows) {
        int len = s.length();
        if(numRows == 1){
            return s;
        }
        ArrayList<int[]> list = new ArrayList<>();
        int ind = (numRows -1)*2;
        int[] index = {-1,0};
        list.add(index);
        while (ind < len + (numRows -1)*2){
            int[] inde = {ind,ind};
            list.add(inde);
            ind += (numRows -1)*2;
        }
        StringBuffer str = new StringBuffer();
        int length = numRows;
        while (length >0){
//            System.out.println("num" + numRows);
            for (int i = 0; i < list.size(); i++) {
                System.out.printf(" " +list.get(i)[0] + "_"+list.get(i)[1]);
            }
            for (int i = 0; i < list.size(); i++) {
                int[] ret = list.get(i);

                if( ret[0] > 0){
                    if(ret[0]+(numRows -1)*2 != ret[1] &&  ret[0] < len){
                        str.append(s.charAt(ret[0]));
                    }
                    ret[0]--;
                }
                if(ret[0]+1 != ret[1] && ret[1] < len){
                    str.append(s.charAt(ret[1]));
                }
                ret[1]++;
            }

            System.out.println(" ");
            length--;
        }


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)[0] + " = "+list.get(i)[1]);
        }
        System.out.println(str.toString());
//        System.out.println(list.toString());
        return s;
    }
}








































