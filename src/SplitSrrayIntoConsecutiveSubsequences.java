import java.util.HashMap;
/**
 * 659. 分割数组为连续子序列
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个长度至少为 3 的子序列，其中每个子序列都由连续整数组成。
 *
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 * 示例 2：
 *
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * 示例 3：
 *
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 *
 * 提示：
 *
 * 1 <= nums.length <= 10000
 * 通过次数25,482提交次数46,895
 *
 * https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/
 */
public class SplitSrrayIntoConsecutiveSubsequences {
    public static void main(String[] args) {
        SplitSrrayIntoConsecutiveSubsequences s = new SplitSrrayIntoConsecutiveSubsequences();
        int[] nums = {1,2,3,4,4,5,5,6};
        boolean ret = s.isPossible(nums);
        if(ret){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> need = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == 0){
                continue;
            }
            System.out.println(need.get(nums[i]));
            if (need.containsKey(nums[i]) && need.get(nums[i]) > 0){
                map.put(nums[i],map.get(nums[i]) - 1);
                need.put(nums[i],need.get(nums[i])-1);

                if(need.containsKey(nums[i] + 1)){
                    need.put(nums[i]+1,need.get(nums[i]+1)+1);
                }else{
                    need.put(nums[i]+1,1);
                }
            }else if((!need.containsKey(nums[i]) || need.get(nums[i]) == 0 )
                    && map.containsKey(nums[i]+1) && map.containsKey(nums[i]+2) && map.get(nums[i]) > 0 && map.get(nums[i]+1) > 0 && map.get(nums[i]+2) > 0){
                map.put(nums[i],map.get(nums[i]) - 1);
                map.put(nums[i]+1,map.get(nums[i]+1) - 1);
                map.put(nums[i]+2,map.get(nums[i]+2) - 1);
                if(need.containsKey(nums[i]+3)){
                    need.put(nums[i]+3,need.get(nums[i]+3)+1);
                }else {
                    need.put(nums[i]+3,1);
                }
            }else {
                return  false;
            }
            System.out.println(need.toString());

        }
        return true;
    }
}
