import java.util.*;

/**
 * 697. 数组的度
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2：
 *
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 *
 *
 * 提示：
 *
 * nums.length 在1到 50,000 区间范围内。
 * nums[i] 是一个在 0 到 49,999 范围内的整数。
 * 通过次数47,172提交次数79,222
 *
 * https://leetcode-cn.com/problems/degree-of-an-array/
 */

public class DegreeOfAnArray {
    public static void main(String[] args) {
        DegreeOfAnArray d = new DegreeOfAnArray();
        int[] nums = {1,2,3,4,5,6,4,4,3,2,1,0};
        int ret = d.findShortestSubArray(nums);
        System.out.println(ret);
    }
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashMap<Integer,Integer> startInd = new HashMap<>();
        HashMap<Integer,Integer> endInd = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
                endInd.put(nums[i],i);
            }else {
                map.put(nums[i],1);
                startInd.put(nums[i],i);
                endInd.put(nums[i],i);
            }
        }

        //降序排序
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        System.out.println(list);
        System.out.println(startInd);
        System.out.println(endInd);
        Map.Entry<Integer, Integer> t = list.get(0);
        if(t.getValue() == 1){
            return 1;
        }
        int min = nums.length;
        for (int i = 0;i<list.size();i++){
            Map.Entry<Integer, Integer> temp = list.get(i);
            System.out.println(temp.getKey() + " : "+temp.getValue());
            if(t.getValue() == temp.getValue()){
                min = Math.min(min,endInd.get( temp.getKey()) - startInd.get(temp.getKey()) + 1);
            }else {
                break;
            }
        }
        for (Map.Entry<Integer, Integer> mapping : list) {
            System.out.println("键：" + mapping.getKey() + " 值：" + mapping.getValue());
        }

        return min;
    }
}
