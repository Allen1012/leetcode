import java.util.HashMap;

/**
 * 496. 下一个更大元素 I
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 *
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 示例 2:
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *
 *
 * 提示：
 *
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 *
 *
 * 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
 *
 * https://leetcode-cn.com/problems/next-greater-element-i/
 */
public class NextGreaterElementI {

    public static void main(String[] args) {
        NextGreaterElementI n = new NextGreaterElementI();
        int[] nums1 = {1,2,3};
        int[] nums2 = {6,2,4,3,5,1};
        n.nextGreaterElement(nums1,nums2);
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ret = new int[nums1.length];
//        int[] map = new int[nums2.length];
        HashMap<Integer,Integer> map = new HashMap();
        if(nums1.length == 0){
            return ret;
        }

        for (int i = nums2.length - 1; i >= 0; i--) {
            System.out.println(i);
            if(i == nums2.length - 1){
//                map[i] = -1;
                map.put(nums2[i],-1);
                continue;
            }
            if(nums2[i] < nums2[i+1]){
//                map[i] = nums2[i+1];
                map.put(nums2[i],nums2[i+1]);
                continue;
            }

            if(nums2[i] < map.get(nums2[i+1])){
//                map[i] = map[i+1];
                map.put(nums2[i],map.get(nums2[i+1]));
                continue;
            }

//            map[i] = -1;
            map.put(nums2[i],-1);
            for (int j = i+2; j < nums2.length; j++) {
                if(map.get(nums2[j]) < 0){
                    break;
                }
                if(nums2[i] < map.get(nums2[j])){
//                    map[i] = map[j];
                    map.put(nums2[i],map.get(nums2[j]));
                    break;
                }
            }
        }

        System.out.println(nums2.toString());
        for (int i = 0; i < nums2.length; i++) {
            System.out.printf(" "+nums2[i]);
        }
        System.out.println( " ");
        System.out.println(map.toString());
        for (int i = 0; i < nums2.length; i++) {
            System.out.printf(" " + map.get(nums2[i]));
//            System.out.printf(" "+map[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            ret[i] = map.get(nums1[i]);
        }
        return ret;
    }
}
