import java.util.HashMap;

/**
 * 322. 零钱兑换
 * 难度
 * 中等
 *
 * 1062
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 *
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 *
 * 输入：coins = [1], amount = 2
 * 输出：2
 *
 *
 * 提示：
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 *
 * https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChange {

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        int[] coins = {2};
        int ret = c.dp(coins,3);
        System.out.println(ret);
    }
    public int coinChange(int[] coins, int amount) {
        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            int len = amount / coins[i];
            for (int j = 0; j < len; j++) {

            }
        }
        return -1;
    }

    HashMap<Integer,Integer> map = new HashMap<>();
    int dp(int[] coins,int n){
        if(map.containsKey(n)){
            return map.get(n);
        }

        if(n == 0){
            return 0;
        }
        if(n < 0){
            return -1;
        }
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if(n - coins[i] < 0){
                continue;
            }
            int count;
            if(map.containsKey(n-coins[i])){
                count = map.get(n-coins[i]);
            }else {
                count = dp(coins,n-coins[i]);
                map.put(n-coins[i],count);
            }
            if(count < 0){
                continue;
            }
            ret = Math.min(ret,count + 1);
        }
        if(ret == Integer.MAX_VALUE){
            return -1;
        }
        System.out.println("n: "+n + " "+ret);
        return ret;
    }
}
