import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 *
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 *
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 *
 * https://leetcode-cn.com/problems/sliding-window-maximum/submissions/
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7,3,5,6,5,8,9,10, 2};
        int k = 2;
        int[] ret = s.maxSlidingWindow(nums,k);
        for (int i = 0; i < ret.length; i++) {
            System.out.printf(" "+ret[i]);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ret = new int[nums.length - k + 1];
        int max = nums[0];
        for (int i = 1; i < k; i++) {
            if(nums[i] > max){
                max = nums[i];
            }
        }
        ret[0] = max;

        for (int i = k; i < nums.length ; i++) {
            if(nums[i] >= max){
                ret[i+1-k] = nums[i];
                max = nums[i];
                continue;
            }
            if(nums[i-k] < max){
                ret[i+1-k] = max;
                continue;
            }
            //移除的值是最大值  要重新找最大值
            if(nums[i-k] == max){
                max = nums[i];
                for (int j = i-k+1; j < i; j++) {
                    if(nums[j] > max){
                        max = nums[j];
                    }
                }
                ret[i+1-k] = max;
            }

        }
        return ret;
    }

}





// 使用优先队列 超时
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        //2，通过比较器排序，实现最大堆
//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
//
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                /**以下是对比较器升序、降序的理解.
//                 *(1) 写成return o1.compareTo(o2) 或者 return o1-o2表示升序
//                 *(2) 写成return o2.compareTo(o1) 或者return o2-o1表示降序
//                 */
//                return o2.compareTo(o1);
//            }
//
//        }) ;
//
//        int[] ret = new int[nums.length - k + 1];
//        for (int i = 0; i < k; i++) {
//            queue.offer(nums[i]);
//        }
//        ret[0] = queue.peek();
//        queue.remove(nums[0]);
//
//        for (int i = k; i < nums.length ; i++) {
//            queue.offer(nums[i]);
//            ret[i+1-k] = queue.peek();
//            queue.remove(nums[i+1-k]);
//        }
//        return ret;
//    }

































