import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 241. 为运算表达式设计优先级
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 *
 * 示例 1:
 *
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 示例 2:
 *
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 * 通过次数20,399提交次数27,843
 *
 * https://leetcode-cn.com/problems/different-ways-to-add-parentheses/
 */
public class DifferentWaysToAddParentheses {
    HashMap<String,ArrayList<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        String str = "1+1+1+1+1+1";
        DifferentWaysToAddParentheses d = new DifferentWaysToAddParentheses();
        ArrayList<Integer> list = (ArrayList<Integer>) d.diffWaysToCompute(str);
        System.out.println(list.toString());
        System.out.println(d.map.toString());

    }



    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input)){
            return map.get(input);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '*' || c == '+' || c == '-'){
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        if(c == '*'){
                            list.add(left.get(j) * right.get(k));
                        }else if(c == '+'){
                            list.add(left.get(j) + right.get(k));
                        }else if(c == '-'){
                            list.add(left.get(j) - right.get(k));
                        }
                    }
                }
            }
        }

        if(list.isEmpty()){
            list.add(Integer.parseInt(input));
        }
        map.put(input,list);
        return list;
    }
}































