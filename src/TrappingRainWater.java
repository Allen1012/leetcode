/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * 提示：
 *
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 * 通过次数212,081提交次数387,101
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */

public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        int[] height = {};

        int ret = t.trap(height);
        System.out.println(ret);
    }


    public int trap(int[] height) {
        int sum = 0;
        if(height.length == 0){
            return sum;
        }

        int[] leftTopStep = getLeftTopSteps(height);

        for (int i = 0; i < leftTopStep.length; i++) {
            System.out.printf(" "+leftTopStep[i]);
        }
        System.out.println(" ");

        int[] rightTopStep = getLeftTopSteps(reverseArray(height));
        for (int i = 0; i <= rightTopStep.length / 2 - 1; i++) {
            int temp1 = rightTopStep[i];
            int temp2 = rightTopStep[height.length - i - 1];
            rightTopStep[i] = temp2;
            rightTopStep[height.length - i - 1] = temp1;
        }
        for (int i = 0; i < height.length; i++) {
            int water = 0;
            if(height[i] < leftTopStep[i] && height[i] < rightTopStep[i]){
                water = leftTopStep[i] - height[i];
                if(water > (rightTopStep[i] - height[i])){
                    water = rightTopStep[i] - height[i];
                }
                sum += water;
            }
        }

        return sum;
    }

    public int[] getLeftTopSteps(int[] steps){
        int[] height = new int[steps.length];
        height[0] = 0;
        for (int i = 1; i < steps.length; i++) {
            if(steps[i-1] > height[i-1]){
                height[i] = steps[i-1];
            }else {
                height[i] = height[i-1];
            }
        }
        return height;
    }

    public int[] reverseArray(int[] Array) {
        int[] new_array = new int[Array.length];
        for (int i = 0; i < Array.length; i++) {
            // 反转后数组的第一个元素等于源数组的最后一个元素：
            new_array[i] = Array[Array.length - i - 1];
        }
        return new_array;
    }
}
