import java.util.LinkedList;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 * 通过次数567,688提交次数1,294,602
 *
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        String s = "()";
        boolean ret = v.isValid(s);
        System.out.println(ret);
    }
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println(stack.toString());
            if(stack.isEmpty() || stack.getLast() == ')' || stack.getLast() == ']' || stack.getLast() == '}'){
                stack.add(c);
            }else {
                if(c == ')' && stack.getLast() == '(' || c == ']' && stack.getLast() == '[' || c == '}' && stack.getLast() == '{'){
                    stack.pollLast();
                }else {
                    stack.add(c);
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
