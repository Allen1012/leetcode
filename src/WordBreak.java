import java.util.ArrayList;
import java.util.Arrays;
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

    public static void main(String[] args) {
        WordBreak w = new WordBreak();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        ArrayList<String> wordDict = new ArrayList<>();
        List list = Arrays.asList("aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba");
        wordDict.addAll(list);
        boolean ret =  w.wordBreak(s,wordDict);
        if(ret ){
            System.out.println("true");
        }

    }

    HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
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
        System.out.println(map.toString());
        if(canFind == true){
            return;
        }
        if(s.isEmpty()){
            canFind = true;
            return;
        }
        if(map.containsKey(s.length())){
            if(map.get(s.length()) == -1){
                return;
            }
        }

        boolean flg = false;
        System.out.println("s = "+s);
        for (int i = 0; i < lens.size(); i++) {
            if(s.length() >= lens.get(i)){
                String str = s.substring(0,lens.get(i));
                System.out.println("str : "+str);
                String sub = s.substring(lens.get(i));
                if( wordDict.contains(str) && (!map.containsKey(sub.length()) )){
                    flg = true;
                    System.out.println("contain str : "+str);
                    map.put(s.substring(lens.get(i)).length(),1);
                    getWorkBreak( sub,wordDict);

                }
            }
        }
        if(flg == false){
            map.put(s.length(),-1);
        }
    }
}
