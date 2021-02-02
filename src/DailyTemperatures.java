/**
 * 739. 每日温度
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * https://leetcode-cn.com/problems/daily-temperatures/
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures d = new DailyTemperatures();
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        d.dailyTemperatures(nums);
    }

    public int[] dailyTemperatures(int[] nums) {
        int[] map = new int[nums.length];
        int[] days = new int[nums.length];
        if(nums.length == 0){
            return days;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if(i == nums.length - 1){
                days[i] = 0;
                map[i] = -1;
                continue;
            }
            if(nums[i] < nums[i+1]){
                days[i] = 1;
                map[i] = nums[i+1];
                continue;
            }


            map[i] = -1;
            int day = 1;
            for (int j = i+1; j < nums.length; j++) {
                day++;
                if(map[j] < 0){
                    break;
                }
                if(nums[i] < map[j]){
                    days[i] = day + days[j] - 1;
                    map[i] = map[j];
                    break;
                }
            }
        }

        return days;
    }
}
