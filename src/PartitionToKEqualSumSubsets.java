import java.util.Arrays;

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
    public static void main(String[] args) {
        PartitionToKEqualSumSubsets t = new PartitionToKEqualSumSubsets();
        int[] nums = {10,10,10,7,7,7,7,7,7,6,6,6};
        int k = 3;
        boolean ret =  t.canPartitionKSubsets(nums,k);
        if(ret ){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }

    int[] list;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int ave ;
        int max = 0;
        if (k > nums.length) return false;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(max < nums[i]){
                max = nums[i];
            }
        }
        if(sum % k != 0){
            return false;
        }
        ave = sum / k;
        if(max > ave){
            return false;
        }
        list = new int[k];

        /* 降序排序 nums 数组 */
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        for (; i < j; i++, j--) {
            // 交换 nums[i] 和 nums[j]
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        hui(nums,0,0,ave,k);
        return find;
    }

    boolean find = false;
    public void hui(int[] nums,int x,int y,int ave,int k){
        if(find || x == nums.length){
            return;
        }

        for (int i = 0; i < list.length; i++) {
            System.out.printf(" " + list[i]);
        }
        System.out.println(" ");

        for (int j = y; j < k; j++) {
            if(x == nums.length - 1 &&  list[j] + nums[x] == ave) {
                find=true;
                return ;
            }
            if(list[j] + nums[x] > ave){
                continue;
            }else {
                list[j] += nums[x];
                if(list[j] == ave){
                    int tem = list[y];
                    list[y] = ave;
                    list[j] = tem;
                    hui(nums,x+1,y+1,ave,k);
                    //tem = list[j];
                    list[y] = list[j];
                    list[j] = ave;

                    if(j + 1 < k && list[j+1] == 0 ){
                        break;
                    }
                }else {
                    hui(nums,x+1,y,ave,k);
                }
                list[j] -= nums[x];
            }
        }

    }
}

































