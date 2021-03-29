import java.util.*;

/**
 * 1178. 猜字谜
 * 外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
 *
 * 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
 *
 * 单词 word 中包含谜面 puzzle 的第一个字母。
 * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
 * 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）都不能作为谜底。
 * 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。
 *
 * 示例：
 *
 * 输入：
 * words = ["aaaa","asas","able","ability","actt","actor","access"],
 * puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
 * 输出：[1,1,3,2,4,0]
 * 解释：
 * 1 个单词可以作为 "aboveyz" 的谜底 : "aaaa"
 * 1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
 * 3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
 * 2 个单词可以作为 "absoryz" 的谜底 : "aaaa", "asas"
 * 4 个单词可以作为 "actresz" 的谜底 : "aaaa", "asas", "actt", "access"
 * 没有单词可以作为 "gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
 *
 * 提示：
 *
 * 1 <= words.length <= 10^5
 * 4 <= words[i].length <= 50
 * 1 <= puzzles.length <= 10^4
 * puzzles[i].length == 7
 * words[i][j], puzzles[i][j] 都是小写英文字母。
 * 每个 puzzles[i] 所包含的字符都不重复。
 * 通过次数17,898提交次数38,749
 *
 * https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle/
 */
public class NumberOfValidWordsForEachPuzzle {

    public static void main(String[] args) {
//        int m = 0;
//        m |= 1 << 4;
//        System.out.println(m);


        NumberOfValidWordsForEachPuzzle n = new NumberOfValidWordsForEachPuzzle();
        String[] words = {"aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        ArrayList l = (ArrayList) n.findNumOfValidWords(words,puzzles);
        System.out.println(l);
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> wordMaps = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int mask = 0;
            //状态压缩
            for (int j = 0; j < words[i].length(); j++) {
                mask |= 1 << words[i].charAt(j);
            }
            wordMaps.put(mask,wordMaps.getOrDefault(mask,0)+1);
        }

        HashMap<Integer,Integer> puzzleMaps = new HashMap<>();
        for (String puzzle : puzzles){
            int count = 0;
            ArrayList l = (ArrayList) subsets(puzzle.substring(1).toCharArray());
            for (int i = 0; i < l.size(); i++) {
                int mask = 0;
                mask |= 1 << puzzle.charAt(0);
                ArrayList<Character> word = (ArrayList<Character>) l.get(i);
                for (int j = 0; j < word.size(); j++) {
                    mask |= 1 << word.get(j);
                }

                if(wordMaps.containsKey(mask)){
                    count += wordMaps.get(mask);
                }
            }
            list.add(count);

        }
        return list;
    }

    public List<List<Character>> subsets(char[] nums) {
        List<Character> l = new ArrayList<Character>();
        List<List<Character>> list = new ArrayList<>();
        list.add(l);
        if(nums.length == 0) {
            return list;
        }
        for (int i = 0; i < nums.length; i++) {
            int len = list.size();
            for (int j = 0; j < len  ; j++) {
                List<Character> temp = new ArrayList<Character>();
                temp.addAll(list.get(j));
                temp.add(nums[i]);
                list.add(temp);
            }
        }

        return list;
    }
}