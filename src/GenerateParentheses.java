import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 *
 * 提示：
 *
 * 1 <= n <= 8
 * 通过次数229,085提交次数298,060
 *
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    HashMap<Integer,ArrayList<String>> map = new HashMap<>();

    public List<String> generateParenthesis(int n) {
        if(map.containsKey(n)){
            return map.get(n);
        }
        ArrayList<String> list = new ArrayList<>();
        if(n == 1){
            list.add("()");
        }else {
            for (int i =1;i<n ;i++){
                ArrayList<String> s1 = (ArrayList<String>) generateParenthesis(i);
                ArrayList<String> s2 = (ArrayList<String>) generateParenthesis(n-i);
                for (int j = 0; j < s1.size(); j++) {
                    for (int k = 0; k < s2.size(); k++) {
                        String str = s1.get(j)+s2.get(k);
                        if(!list.contains(str)){
                            list.add(str);
                        }
                    }
                }
            }

            ArrayList<String> subList = (ArrayList<String>) generateParenthesis(n-1);
            for (int i = 0; i < subList.size(); i++) {
                list.add("("+subList.get(i)+")");
            }


        }

        map.put(n,list);
        return list;
    }
}


