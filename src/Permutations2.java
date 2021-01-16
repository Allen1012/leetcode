import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. 全排列 II
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permutations2 {
    public static void main(String[] args) {

        int[] nums = {1,1,1,2};

        Permutations2 p = new Permutations2();

        List<List<Integer>> list = p.permuteUnique(nums);

        System.out.println(list.toString());

    }

    List<List<Integer>> lists = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] map = new int[nums.length];
        backTrace(nums,map,new ArrayList<Integer>(),0);
        return lists;
    }

    public void backTrace(int[] nums,int[] map, List<Integer> list, int start){
        System.out.println(list.toString());
        if(list.size() == nums.length && !(lists.contains(list))){
            lists.add(new ArrayList(list));
        }

        for(int i = 0; i < nums.length; i++){
            if(map[i] == 1){
               continue;
            }

            list.add(nums[i]);
            map[i] = 1;
            backTrace(nums,map,list,i+1);
            map[i] = 0;
            list.remove(list.size()-1);
        }
    }

}
