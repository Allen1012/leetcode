/**
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 *
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 */
public class NextGreaterElementII {


    public static void main(String[] args) {
        NextGreaterElementII n = new NextGreaterElementII();
//        int[] nums1 = {1,2,3};
        int[] nums2 = {1,2,1,5,3,6,3,9,6,5,3,1,2,4,5,6,7,8,3,2,4,1,5,6,7,4,3,6,7,8,9,877,1,6,4,3,3,2,5};
        n.nextGreaterElements(nums2);
    }
    public int[] nextGreaterElements(int[] nums) {
        int[] map = new int[nums.length];
        if(nums.length == 0){
            return map;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if(i == nums.length - 1){
                map[i] = -1;
                for (int j = 0; j < nums.length; j++) {
                    if(nums[i] < nums[j]){
                        map[i] = nums[j];
                        break;
                    }
                }
                continue;
            }
            if(nums[i] < nums[i+1]){
                map[i] = nums[i+1];
                continue;
            }

            boolean unFind = true;
            for (int j = i+1; j < nums.length; j++) {
                if(map[j] > -1 && map[j] == -1){
                    break;
                }
                if(nums[i] < map[j]){
                    map[i] = map[j];
                    unFind = false;
                    break;
                }
            }
            if(unFind){
                for (int j = 0; j< i+1;j++){
                    if(nums[i] < nums[j]){
                        map[i] = nums[j];
                        unFind = false;
                        break;
                    }
                }
            }
            if(unFind){
                map[i] = -1;
            }
        }
        return map;
    }
}
