import java.util.ArrayList;
import java.util.HashMap;

/**
 * 494. 目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例：
 *
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 *
 * 提示：
 *
 * 数组非空，且长度不会超过 20 。
 * 初始的数组的和不会超过 1000 。
 * 保证返回的最终结果能被 32 位整数存下。
 *
 * https://leetcode-cn.com/problems/target-sum/
 */
public class TargetSum {

    public static void main(String[] args) {
        TargetSum t = new TargetSum();
        int[] nums = {1,1,1,1,1};
        t.findTargetSumWays(nums,3);
    }

    public int findTargetSumWays(int[] nums, int S) {

//        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] sybol = {1,-1};
        for (int j = 0; j < nums.length; j++) {
            if(map.isEmpty()){
                for (int i = 0; i < sybol.length; i++) {
//                    list.add(nums[j] * sybol[i]);
                    if(map.containsKey(nums[j]*sybol[i])){
                        map.put(nums[j]*sybol[i],2);
                    }else{
                        map.put(nums[j]*sybol[i],1);
                    }
                }
            }else {
//                ArrayList<Integer> newL = new ArrayList<>();
//                for (int ii = 0; ii < list.size(); ii++) {
//                    for (int i = 0; i < sybol.length; i++) {
//                        newL.add(list.get(ii) + nums[j] * sybol[i]);
//                    }
//                }
//                list.clear();
//                list.addAll(newL);
//                newL.clear();

                HashMap<Integer,Integer> newM = new HashMap<>();
                for(Integer key : map.keySet()){
                    for (int i = 0; i < sybol.length; i++) {
                        int k = key + nums[j] * sybol[i];
                        if(newM.containsKey(k)){
                            int val = newM.get(k);
                            newM.put(k,val+map.get(key));
                        }else{
                            newM.put( k ,map.get(key));
                        }
                    }
                }

                map.clear();
                map.putAll(newM);
                newM.clear();
            }
//            System.out.println(list.toString());
            System.out.println(map.toString());
        }

//        System.out.println(list.size());
//        System.out.println(map.toString());
        if(map.containsKey(S)){
            return map.get(S);
        }
        return 0;
    }
}
