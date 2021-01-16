/**
 * 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 *
 * 示例 2:
 *
 * 输入: [1, 2, 3, 5]
 *
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {

        int[] nums = {1, 5, 11, 5};

        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();

        if(p.canPartition(nums)){
            System.out.println("true");
        }else {
            System.out.println("flase");
        }
    }

    public boolean canPartition(int[] nums) {
        if(nums.length <= 1){
            return false;
        }
        if(nums.length == 2){
            return nums[0] == nums[1];
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
        }
        if(count % 2 == 1){ //如果数组和为基数 则不能分为两个相等的数组
            return false;
        }
        count = count/2;
        boolean[] dp = new boolean[count+1];
        dp[0] = true;
        if(nums[0] <= count){
            dp[nums[0]] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = count ; j >= nums[i] && j >= 0; j--){
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }

        return dp[count];
    }

}
