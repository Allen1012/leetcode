import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串
 * 难度
 * 中等
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */

class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        String str = " a bc1423a45a4";
        l.lengthOfLongestSubstring(str);
    }



    public int lengthOfLongestSubstring(String s) {
        char c;
        int head = 0;
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        if(s.isEmpty()){
            return max;
        }
        max = 1;
        while (head < s.length()){
            c = s.charAt(head);
            if(map.containsKey(c) ){
                max = Math.max(max,map.size());
                head = map.get(c);
                System.out.println(" head" + head);
                map.clear();
            }else {
                map.put(c,head);
            }
            System.out.println(map.toString());
            head++;
        }
        max = Math.max(max,map.size());

        System.out.println(" "+max);
        return max;
    }
}

















