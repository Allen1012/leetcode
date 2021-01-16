/**
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * https://leetcode-cn.com/problems/jump-game-ii/
 */
public class JumpGame2 {

    public static void main(String[] args) {

        int[] nums = {2,3,1,1,4};

        System.out.println(jump_niubi(nums));


    }

    public static int jump(int[] nums) {
        if(nums.length <= 1){
            return 0;
        }

        int step = nums.length - 1; //记录最后的位置
        int temp = step; //记录当前最后位置 向前最远能到达的位置
        int num = 0; //记录最少跳跃次数
        while (step > 0){
            for (int i = step; i >= 0; i--) {
                if(i + nums[i] >= step){
                    temp = i;
//                    System.out.println("temp:"+temp);
                }
            }
            step = temp;
//            System.out.println("step now:"+step);
            num++;
        }

        return num;
    }

    public static int jump_niubi(int[] nums) {
        if(nums.length <= 1){
            return 0;
        }

        int fast = 0; //记录i 到 step 可以到达最远的位置
        int step = 0; //记录位置
        int num = 0; //记录最少跳跃次数
        for (int i = 0; i < nums.length - 1; i++) {
            fast = Math.max(fast,i+nums[i]);
            if(i == step){
                System.out.println("step:"+step);
                num++;
                step = fast;
            }
        }

        return num;
    }
}
