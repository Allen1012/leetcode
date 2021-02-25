import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * 通过次数120,207提交次数244,232
 *
 * https://leetcode-cn.com/problems/word-break/
 */
public class WordBreak {
    HashMap<Integer,Boolean> map = new HashMap<Integer, Boolean>();
    ArrayList<Integer> lens = new ArrayList<>();
    boolean canFind = false;
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] chars = new boolean[26];
        for (int i = 0; i < wordDict.size(); i++) {
            if(!lens.contains( wordDict.get(i).length())){
                lens.add(wordDict.get(i).length());
            }
            for (int j = 0; j < wordDict.get(i).length(); j++) {
                chars[wordDict.get(i).charAt(j) - 'a'] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if(chars[s.charAt(i) - 'a'] == false){
                return false;
            }
        }

         getWorkBreak(s,wordDict);

        return canFind;
    }



    public void getWorkBreak(String s,List<String> wordDict){
        if(canFind == true){
            return;
        }
        if(s.isEmpty()){
            canFind = true;
            return;
        }
        if(map.containsKey(s.length())){
            return;
        }

        System.out.println("s = "+s);
        for (int i = 0; i < lens.size(); i++) {
            if(s.length() >= lens.get(i)){
                String str = s.substring(0,lens.get(i));
                System.out.println("str : "+str);
                if( wordDict.contains(str)){

                    System.out.println("contain str : "+str);
                    getWorkBreak( s.substring(lens.get(i)),wordDict);

                }
            }
        }
    }
}
