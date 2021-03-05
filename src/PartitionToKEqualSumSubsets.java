/**
 * 698. 划分为k个相等的子集
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 * 示例 1：
 *
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *
 * 提示：
 *
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 * 通过次数19,034提交次数42,616
 *
 * https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/
 */
public class PartitionToKEqualSumSubsets {
    int[] list;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int ave ;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum % k != 0){
            return false;
        }
        ave = sum / k;
        list = new int[k];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > ave){
                return false;
            }
            for (int j = 0; j < k; j++) {
                if(list[j] + nums[i] > ave){
                    continue;
                }else {
                    list[j] += nums[i];
                    break;
                }
            }
        }


        return false;
    }

    public boolean hui(int[] nums,int x,int y,int ave,int k){
        for (int i = x; i < nums.length; i++) {
            if(nums[i] > ave){
                return false;
            }
            for (int j = y; j < k; j++) {
                if(list[j] + nums[i] > ave){
                    continue;
                }else {
                    list[j] += nums[i];
                    break;
                }
            }
        }
        
    }
}

































