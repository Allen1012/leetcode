import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *78. 子集
 * 给你一个整数数组 nums ，返回该数组所有可能的子集（幂集）。解集不能包含重复的子集。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};
        List<List<Integer>> list = subsets(nums);
        System.out.println(list.toString());
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> l = new ArrayList<Integer>();
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
