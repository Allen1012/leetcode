import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

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
        int[] nums = {18,20,39,73,96,99,101,111,114,190,207,295,471,649,704,1037};
        int k = 4;
        boolean ret =  t.canPartitionKSubsets(nums,k);
        if(ret ){
            System.out.println("true");
        }
    }

    int[] list;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int ave ;
        int max = 0;
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
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            set.add(i);
        }

        hui(nums,0,ave,set);
        return find;
    }

    boolean find = false;
    int num = 0;
    public void hui(int[] nums,int x,int ave,HashSet<Integer> set){
        num++;
        System.out.println(x  + "find xxxxxxxxxxoooooooooooooooooooooooooxxxxxxxx11111111   " + num);
        if(find || x == nums.length){
            return;
        }

       // System.out.println("qweqeqqrqrqrqrqtwtwtwtwtrrwrww" + nums[x]);

        Iterator<Integer> it = set.iterator();
        while (it.hasNext()){

            int j = it.next();

            if(x == nums.length - 1 &&  list[j] + nums[x] == ave) {
                find=true;
                return ;
            }
            System.out.println(list[j] + nums[x]);
            if(list[j] + nums[x] > ave){
                System.out.println(set.toString());
                continue;
            }else {
                list[j] += nums[x];
                System.out.println(list[j] );
         //       System.out.println("qweqeqqrqrqrqrqtwtwtwtwtrrwrww======" + list[j]);
           //     System.out.println("qweqeqqrqrqrqrqtwtwtwtwtrrwrww======ave" + ave);
                if(list[j] == ave){
                    System.out.println(list[j]  + "find aaaa");
                    HashSet<Integer> s = new HashSet<>();
                    s.addAll(set);
                    s.remove(j);
                    System.out.println(s);
                    hui(nums,x+1,ave,s);
                }else{
                    System.out.println(x  + "find xxxxxxxxxxxxxxxxxx" + x);
                    hui(nums,x+1,ave,set);
                }
                list[j] -= nums[x];
                System.out.println(x  + "find xxxxxxxxxxooxx============-----list j " + list[j]);
            }
        }

        System.out.println(x  + "find xxxxxxxxxxoooooooooooooooooooooooooxxxxxxxx============" + x);
    }
}

































