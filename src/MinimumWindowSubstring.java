import java.util.HashMap;

/**
 * 76. 最小覆盖子串
 * 难度
 * 困难
 *
 * 946
 *
 *
 *
 *
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 *
 *
 * 提示：
 *
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 *
 *
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 *
 * https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ghkomrbfbkoowqwgaurizliesjnveoxmvjdjaepdqftmvsuyoogobrutahogxnvuxyezevfuaaiyufwjtezuxtpycfgasburzytdvazwakuxpsiiyhewctwgycgsgdkhdfnzfmvhwrellmvjvzfzsdgqgolorxvxciwjxtqvmxhxlcijeqiytqrzfcpyzlvbvrksmcoybxxpbgyfwgepzvrezgcytabptnjgpxgtweiykgfiolxniqthzwfswihpvtxlseepkopwuueiidyquratphnnqxflqcyiiezssoomlsxtyxlsolngtctjzywrbvajbzeuqsiblhwlehfvtubmwuxyvvpwsrhutlojgwktegekpjfidgwzdvxyrpwjgfdzttizquswcwgshockuzlzulznavzgdegwyovqlpmnluhsikeflpghagvcbujeapcyfxosmcizzpthbzompvurbrwenflnwnmdncwbfebevwnzwclnzhgcycglhtbfjnjwrfxwlacixqhvuvivcoxdrfqazrgigrgywdwjgztfrbanwiiayhdrmuunlcxstdsrjoapntugwutuedvemyyzusogumanpueyigpybjeyfasjfpqsqotkgjqaxspnmvnxbfvcobcudxflmvfcjanrjfthaiwofllgqglhkndpmiazgfdrfsjracyanwqsjcbakmjubmmowmpeuuwznfspjsryohtyjuawglsjxezvroallymafhpozgpqpiqzcsxkdptcutxnjzawxmwctltvtiljsbkuthgwwbyswxfgzfewubbpowkigvtywdupmankbndyligkqkiknjzchkmnfflekfvyhlijynjlwrxodgyrrxvzjhoroavahsapdiacwjpucnifviyohtprceksefunzucdfchbnwxplhxgpvxwrmpvqzowg";
        String t = "jhdcgr";
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        String ret = m.minWindow(s,t);
        System.out.println(ret);
    }

    public String minWindow(String s, String t) {

        if(s.isEmpty()){
            return "";
        }
        if(t.isEmpty()){
            return s;
        }
        if(t.length() > s.length()){
            return "";
        }

        if(t.equals(s)){
            return t;
        }

        HashMap<Character,Integer> tMap = new HashMap<Character, Integer>();

        char c ;
        for (int i = 0; i < t.length(); i++) {
            c = t.charAt(i);
            if(tMap.containsKey(c)){
                tMap.put(c,tMap.get(c) + 1);
            }else {
                tMap.put(c,1);
            }
        }

        int len = (s.length() - t.length()) / 2 + t.length();


        findStr(t.length(),len,s.length(),s,tMap);


        return ret;
    }


    String ret = "";

    public void findStr(int start ,int len,int end,String s,HashMap<Character,Integer> tMap){
        int mid;
        System.out.println(start + " : " + len + " : "+end);
        if(len > end || len < start){
            return;
        }
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        char temp;
        char c;
        for (int i = 0; i < len -1; i++) {
            c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c) + 1);
            }else {
                map.put(c,1);
            }
        }
        for (int i = 0; i < s.length() - len + 1; i++) {
            temp = s.charAt( len + i - 1 );
            if(map.containsKey(temp)){
                map.put(temp,map.get(temp) + 1);
            }else {
                map.put(temp,1);
            }

            if(isEqual(map,tMap)){
                String tem = s.substring(i,i+len);
                mid = (len - start) / 2 + start;
                if(mid == len){
                    len--;
                    mid--;
                }
                findStr(start,mid,len,s,tMap);

                System.out.println("tem :" + tem);
                if(ret.isEmpty() || tem.length() < ret.length()){
                    ret = tem;
                }
                return ;
            }
            c = s.charAt(i);
            map.put(c,map.get(c) - 1);
        }
        mid = (end - len) / 2 + len;
        if(mid == len){
            len++;
            mid++;
        }
        findStr(len,mid,end,s,tMap);
        return ;
    }

    public boolean isEqual(HashMap<Character,Integer> map1, HashMap<Character,Integer> map2){
        for(char key:map2.keySet())
        {
            if(!map1.containsKey(key)){
                return false;
            }
            if((int)map1.get(key) < (int)map2.get(key)){
                return false;
            }
        }
        return true;

    }
}
