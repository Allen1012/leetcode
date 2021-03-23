/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 * 通过次数515,698提交次数1,536,942
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        l.longestPalindrome("ab");
    }

    String str;

    public String longestPalindrome(String s) {
        System.out.println(s);
        if(isPalindrome(s,0,s.length()-1)){
            return s;
        }

        int len = s.length();
        while (!isPalindromeByLen(s,len)){
            len--;
        }
        System.out.println(len);
        System.out.println(str);

        return ""+s.charAt(0);
    }

    public boolean isPalindromeByLen(String s,int len){
        for (int i = 0; i <= s.length() - len; i++) {
//            System.out.println("str :" + i + " end :"+(i+len-1));
            if(isPalindrome(s,i,i+len-1)){
                str = s.substring(i,i+len);
//                System.out.println("true!!!!");
                return true;
            }
        }
        return false;
    }

    public boolean isPalindrome(String s,int str,int end){
        while (str < end){
            if (str == end){
                return true;
            }
            if(s.charAt(str) == s.charAt(end)){
                str++;
                end--;
            }else {
                return false;
            }
        }

        return true;
    }
}
