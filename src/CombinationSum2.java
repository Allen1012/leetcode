import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40. 组合总和 II
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum2 {
    public static void main(String[] args) {

        int[] nums = {3,1,3,5,1,1};
        int target = 8;

        CombinationSum2 c = new CombinationSum2();

        List<List<Integer>> list = c.combinationSum2(nums,target);

        System.out.println(list.toString());
    }

    List<List<Integer>> lists = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0 || target < 0){
            return lists;
        }
        Arrays.sort(candidates);
        List<Integer> list = new LinkedList<>();
        backTrace(candidates,target,list, 0);
        return lists;
    }

    public void backTrace(int[] candidates, int target, List<Integer> list, int start){
        if(target == 0){
            lists.add(new ArrayList(list));
        }

        for(int i = start; i < candidates.length; i++){
            if(target < 0){
                break;
            }
            //剪枝：保证同一层中只有1个相同的元素，不同层可以有重复元素
            if(i > start && candidates[i] == candidates[start]){
                System.out.println(list.toString() + i + " " +candidates[i]);
                continue;
            }
            list.add(candidates[i]);
            backTrace(candidates,target-candidates[i],list,i+1);
            list.remove(list.size()-1);
        }
    }


}
