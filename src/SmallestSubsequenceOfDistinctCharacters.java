import java.util.LinkedList;

/**
 * 1081. 不同字符的最小子序列
 * 难度
 * 中等
 *
 *
 * 返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。
 *
 * 注意：该题与 316 https://leetcode.com/problems/remove-duplicate-letters/ 相同
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
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 *
 * https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters/
 */
public class SmallestSubsequenceOfDistinctCharacters {
    public String smallestSubsequence(String s) {
        LinkedList<Character> link = new LinkedList<>();
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // for (int i = 0; i < 26; i++) {
        //     System.out.println((char)('a'+i) + " : " + count[i]);
        // }

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
        // System.out.println(link.toString());
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < link.size(); i++) {
            str.append( link.get(i));
        }
        return str.toString();
    }
}