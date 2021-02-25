import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 140. 单词拆分 II
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 *
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * 通过次数40,981提交次数92,242
 *
 * https://leetcode-cn.com/problems/word-break-ii/
 */
public class WordBreakII {

    public static void main(String[] args) {
        WordBreakII w = new WordBreakII();
        String s = "goalspecialq";
        ArrayList<String> wordDict = new ArrayList<>();
        List list = Arrays.asList("go","goal","goals","special");
        wordDict.addAll(list);
        ArrayList ret = (ArrayList) w.wordBreak(s,wordDict);
        System.out.println(ret);
    }

    ArrayList<Integer> lens = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
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
                return new ArrayList<>();
            }
        }

        ArrayList<String> list = getWorkBreak(s,wordDict);
        System.out.println("list now :" + list.toString());

        return list;
    }

    public ArrayList<String> getWorkBreak(String s,List<String> wordDict){
        ArrayList<String> list = new ArrayList<>();

        System.out.println("s = "+s);
        for (int i = 0; i < lens.size(); i++) {
            if(s.length() >= lens.get(i)){
                String str = s.substring(0,lens.get(i));
                System.out.println("str : "+str);
                if( wordDict.contains(str)){

                    System.out.println("contain str : "+str);
                    ArrayList<String> l = (ArrayList<String>) getWorkBreak( s.substring(lens.get(i)),wordDict);

                    if(l.isEmpty() && lens.get(i) == s.length() ){
                        list.add(str );
                    }else{
                        for (int j = 0; j < l.size(); j++) {
                            list.add(str + " " + l.get(j));
                        }
                    }
                }
            }
        }

        System.out.println("list: ======" + list.toString());
        return list;
    }
}



























