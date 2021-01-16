import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 752. 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *提示：
 *
 * 死亡列表 deadends 的长度范围为 [1, 500]。
 * 目标数字 target 不会在 deadends 之中。
 * 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OpenLock {

    public static void main(String[] args) {
        String[] deadends = {"0000"};
        String target = "8888";
        int num = openLock(deadends,target);
        System.out.println("num ==="+num);
    }

    public static int openLock(String[] deadends, String target) {
        if(target.equals( "0000")){
            return 0;
        }
        int num = 1;
        String init = "0000";
        Set<String> visited = new HashSet<>();
        visited.add(init);
        for (int ii = 0; ii < deadends.length ; ii++) {
            if(init.equals(deadends[ii])){
                return -1;
            }
            visited.add(deadends[ii]);
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(init);
        while (!queue.isEmpty()){
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                String str = queue.poll();
                for (int i = 0; i < 4; i++) {
                    char[] arr = str.toCharArray();
                    char c = arr[i];
                    arr[i] =  add(c);
                    String temp = String.valueOf(arr);

                    if(temp.equals(target)){
                        return num;
                    }
                    if(!visited.contains(temp)){
                        visited.add(temp);
                        queue.add( temp );
                    }

                    arr[i] =  reduce(c);
                    temp = String.valueOf(arr);
                    if(temp.equals(target)){
                        return num;
                    }
                    if(!visited.contains(temp)){
                        visited.add(temp);
                        queue.add( temp );
                    }
                }
            }
            num++;
        }
        return  -1;
    }

    public static char add(char c){
        if(c == '9'){
            return '0';
        }
        int n = (int)c;
        return (char)(n+1);
    }

    public static char reduce(char c){
        if(c == '0'){
            return '9';
        }
        int n = (int)c;

        return (char) (n-1);
    }
}
