import java.util.ArrayList;
import java.util.LinkedList;
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
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permutations {
    public static void main(String[] args) {

        int[] nums = {1,2,3,4};

        Permutations p = new Permutations();

        List<List<Integer>> list = p.permute(nums);

        System.out.println(list.toString());

    }

    List<List<Integer>> lists = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {

        backTrace(nums,new ArrayList<Integer>(),0);
        return lists;
    }

    public void backTrace(int[] nums, List<Integer> list, int start){
        System.out.println(list.toString());
        if(list.size() == nums.length){
            lists.add(new ArrayList(list));
        }

        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])){
               continue;
            }

            list.add(nums[i]);
            backTrace(nums,list,i+1);
            list.remove(list.size()-1);
        }
    }

}
