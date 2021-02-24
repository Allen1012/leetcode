import java.util.HashMap;

/**
 * 279. 完全平方数
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 *
 * 提示：
 *
 * 1 <= n <= 104
 * 通过次数112,233提交次数189,389
 *
 * https://leetcode-cn.com/problems/perfect-squares/
 */
public class PerfectSquares {
    public static void main(String[] args) {
        PerfectSquares p = new PerfectSquares();
        int ret = p.numSquares(13);
        System.out.println("ret: " + ret);
    }

    public int numSquares(int n) {
        int len = (int)Math.sqrt(n) + 1;
        int[] squares = new int[len];
        for (int i = 0; i < len; i++) {
            squares[i] = i*i;
        }
        return getQ(squares,n);
    }

    HashMap<Integer,Integer> map = new HashMap<>();

    public int getQ(int[] squares, int n){
        if(map.containsKey(n)){
            return  map.get(n);
        }
        int len = (int)Math.sqrt(n) ;
        if(n == squares[len]){
            return 1;
        }
        if(n == squares[len] + 1 ){
            return 2;
        }
        int num = n;

        for (int i = 1; i <= len; i++) {
            int count = n / squares[i];
            if(count == 0){
                continue;
            }
            int temp = n % squares[i];
            if(temp == 0){
                num = Math.min(num,count);
                continue;
            }
            num = Math.min(num,  count + getQ(squares,temp));
        }
        map.put(n,num);
        return num;
    }
}
