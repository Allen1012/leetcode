import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * 难度
 * 简单
 *
 *
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 *
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray f = new FindAllNumbersDisappearedInAnArray();
        int[] nums = {4,3,2,7,8,2,3,1};
        f.findDisappearedNumbers(nums);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int k = 0;
        int temp;
        while (k< nums.length){
            System.out.println("K: "+k + " nums "+nums[k]);
            if(nums[k] != k+1 && nums[k] > 0){
//                temp = nums[k];
                if(nums[nums[k] - 1] == nums[k]){
                    nums[k] = 0;
                }else {
                    temp = nums[nums[k] - 1];
                    nums[nums[k] -1] = nums[k];
                    nums[k] = temp;
                }
            }else {
                k++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            System.out.printf(" "+nums[i]);
            if(nums[i] == 0){
                list.add(i+1);
            }
        }
        System.out.println(" ");

        System.out.println(list.toString());
        return list;
    }
}
