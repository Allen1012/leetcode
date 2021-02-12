import java.util.LinkedList;

/**
 * 316. 去除重复字母
 * 难度
 * 中等
 *
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 *
 * https://leetcode-cn.com/problems/remove-duplicate-letters/
 */
public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        RemoveDuplicateLetters r = new RemoveDuplicateLetters();
        r.removeDuplicateLetters("bbbcaac");
    }
    public String removeDuplicateLetters(String s) {
        LinkedList<Character> link = new LinkedList<>();
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            System.out.println((char)('a'+i) + " : " + count[i]);
        }

        char c ;
        char lastC;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(link.isEmpty()){
                link.add(c);

            }else if(!link.contains(c)){
                lastC = link.getLast();
                while (lastC > c && count[(int)(lastC - 'a')] > 0){
                    link.removeLast();
                    if(link.isEmpty()){
                        break;
                    }
                    lastC = link.getLast();
                }
                link.add(c);

            }
            count[(int)(c - 'a')]--;
        }
        System.out.println(link.toString());
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < link.size(); i++) {
            str.append( link.get(i));
        }
        return str.toString();
    }
}
