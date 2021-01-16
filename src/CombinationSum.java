import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * https://leetcode-cn.com/problems/permutations/
 */
public class CombinationSum {
    public static void main(String[] args) {

        int[] nums = {};
        int target = 3;

        CombinationSum c = new CombinationSum();

        List<List<Integer>> list = c.combinationSum(nums,target);

        System.out.println(list.toString());

    }

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums,int target) {
        if(nums.length == 0) {
            return list;
        }
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            bfs(target,temp,0,nums,i);
        }
        return list;
    }

    public  void bfs(int target,List<Integer> arr,int count,int[] nums,int i){
        if(count + nums[i] > target){
            return;
        }
        List<Integer> temp = new ArrayList<Integer>();
        temp.addAll(arr);
        temp.add(nums[i]);
        temp.sort(Comparator.naturalOrder());
        count += nums[i];

        if(count == target){
            System.out.println(count + "+"  + "=" + count + nums[i]);
            System.out.println(temp.toString());
            if(!list.contains(temp)){
                list.add(temp);
            }
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            bfs(target,temp,count ,nums,j);
        }
    }
}
