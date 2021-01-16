import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> l = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        list.add(l);
        if(nums.length == 0) {
            return list;
        }
        for (int i = 0; i < nums.length; i++) {
            int len = list.size();
            for (int j = 0; j < len  ; j++) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.addAll(list.get(j));
                temp.add(nums[i]);
                temp.sort(Comparator.naturalOrder());
                if(!list.contains(temp)){
                    list.add(temp);
                }
            }
        }
        return list;
    }
}
