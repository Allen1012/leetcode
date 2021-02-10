import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 难度
 * 中等
 *
 * 461
 *
 *
 *
 *
 *
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "aa";
        String p = "bb";
        FindAllAnagramsInAString f = new FindAllAnagramsInAString();
        ArrayList<Integer> list = (ArrayList<Integer>) f.findAnagrams(s,p);
        System.out.println(list.toString());
    }

    public List<Integer> findAnagrams(String s, String p) {

        //ret
        List<Integer> list = new ArrayList<>();

        if(s.isEmpty()){
            return list;
        }
        if(p.isEmpty()){
            return list;
        }
        if(p.length() > s.length()){
            return list;
        }

        HashMap<Character,Integer> pMap = new HashMap<Character, Integer>();
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();

        char c ;
        for (int i = 0; i < p.length(); i++) {
            c = p.charAt(i);
            if(pMap.containsKey(c)){
                pMap.put(c,pMap.get(c) + 1);
            }else {
                pMap.put(c,1);
            }

            if(i<p.length() - 1){
                c = s.charAt(i);
                if(map.containsKey(c)){
                    map.put(c,map.get(c) + 1);
                }else {
                    map.put(c,1);
                }
            }
        }

        char temp ;
        for (int i = 0; i < s.length() - p.length() + 1; i++) {

            temp = s.charAt( p.length() + i - 1 );
//            System.out.println("temp " + temp);
            if(map.containsKey(temp)){
                map.put(temp,map.get(temp) + 1);
            }else {
                map.put(temp,1);
            }

            if(isEqual(map,pMap)){
                list.add(i);
            }

            c = s.charAt(i);
//            System.out.println("c "+c);
            map.put(c,map.get(c) - 1);
        }



        return list;
    }

    public boolean isEqual(HashMap<Character,Integer> map1,HashMap<Character,Integer> map2){
        for(char key:map2.keySet())
        {
            if(!map1.containsKey(key)){
                return false;
            }
            if(map1.get(key) != map2.get(key)){
                return false;
            }
        }

        System.out.println("true----------------------");
        return true;

    }
}
