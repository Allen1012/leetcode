import java.util.ArrayList;

/**
 * 1004. 最大连续1的个数 III
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为 0 或 1
 *
 * https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 */
public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        MaxConsecutiveOnesIII m = new MaxConsecutiveOnesIII();
        int[] A = {1,1,0,0,0,0,1,1,0,1,0,1,1,0,1,0,1,0,0,0,1,0,1,1,1,1,1,0,1,1,1,0,0,1,1,1,0,0,1,0,0,0,0,1,1,1,0,1,1,1,0,1,1,1,1,0,1,0,0,0,0,0,0,1,1,1,1,1,1,0,1,0,0,1,0,1,0,1,1,0,0,0,0,0,1,1,1,1,0,1,0,0,1,1,0,1,0,0,0,0,1,1,0,0,0,0,0,1,0,0,0,1,1,1,1,0,1,1,1,1,0,1,1,0,1,1,1,0,1,1,0,1,1,1,0,0,0,1,1,1,1,0,1,1,0,0,0,1,1,1,1,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,1,1,0,1,1,1,0,0,0,0,0,1,1,1,0,1,0,0,0,0,0,0,1,1,0,0,1,1,0,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,1,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,1,1,0,1,0,0,1,1,0,0,1,0,1,1,0,0,0,1,1,1,0,0,1,0,0,1,0,0,1,0,0,0,1,0,1,1,1,0,1,1,0,1,0,0,0,1,1,1,1,1,0,1,0,1,1,0,1,0,1,0,1,0,0,1,1,1,1,1,1,0,1,0,0,0,1,0,0,0,0,0,1,0,1,0,0,1,1,0,1,0,1,1,0,1,1,1,0,0,0,1,0,0,1,0,1,1,0,0,0,1,0,0,0,1,1,1,0,0,1,0,1,0,0,1,0,1,0,1,0,0,1,1,1,1,1,0,1,0,0,0,1,1,1,1,1,1,0,0,0,1,1,1,0,0,1,1,0,1,0,0,1,0,1,1,1,0,0,0,1,1,1,1,1,0,0,0,1,0,1,1,0,1,1,1,0,0,1,1,1,0,1,0,1,1,0,1,0,1,1,0,0,0,0,0,1,0,1,0,0,0,1,1,0,0,0,1,0,1,0,1,1,0,1,1,1,0,1,1,0,0,0,1,0,1,0,1,1,0,0,1,0,0,0,1,1,1,0,0,0,0,0,1,0,1,1,0,0,0,0,0,0,0,1,0,1,1,1,0,1,1,0,1,0,0,0,1,1,0,1,0,0,1,0,1,1,0,1,0,0,0,1,0,1,1,1,0,0,0,1,0,0,1,0,0,1,1,0,1,1,1,0,1,1,0,1,1,1,1,1,1,0,0,1,0,1,0,1,0,1,1,0,1,1,0,0,1,1,0,1,0,0,0,0,0,0,0,1,0,0,0,1,1,1,1,1,1,0,0,1,1,1,0,1,0,1,1,0,1,0,0,1,1,0,1,1,1,0,0,0,0,0,1,1,1,1,1,0,1,1,1,1,0,1,1,1,0,0,1,0,0,1,0,0,0,1,0,0,1,0,0,1,1,0,0,1,0,0,0,0,0,1,1,0,1,0,0,0,1,0,0,0,1,1,1,0,1,1,0,0,1,1,0,1,0,0,1,0,0,0,1,1,0,0,1,0,1,1,1,1,1,1,1,0,1,0,0,0,1,1,1,1,0,0,1,0,0,1,1,0,1,0,1,1,0,0,0,0,0,1,0,1,1,0,0,1,0,0,1,1,1,0,1,1,1,1,0,0,1,0,0,0,0,1,0,1,1,0,0,1,0,1,0,0,0,0,1,1,0,0,0,0,1,0,1,0,1,1,1,0,0,0,1,1,0,1,1,0,1,1,1,1,0,1,1,0,0,1,1,0,1,1,0,1,1,0,0,1,1,0,0,1,1,0,1,1,1,1,0,0,1,1,0,0,1,1,0,1,1,0,1,1,0,1,1,0,0,1,0,1,1,0,0,1,0,1,0,0,1,0,1,0,0,1,0,1,1,0,1,0,0,1,1,1,0,0,0,0,1,1,0,0,1,0,0,1,1,0,0,1,1,0,1,0,0,1,1,1,1,0,0,0,1,0,1,0,1,1,0,0,1,0,1,1,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,0,1,0,1,1,1,1,0,0,0,1,1,0,1,1,1,0,0,1,0,1,1,0,0,1,0,1,0,1,0,0,1,0,1,1,0,0,1,0,1,0,1,0,1,0,0,0,0,1,0,1,1,0,1,0,0,0,1,1,0,0,1,1,0,0,0,1,1,0,0,1,1,1,0,0,1,1,1,1,0,0,1,1,0,1,0,0,0,1,0,0,1,0,0,0,0,1,1,0,1,1,1,1,1,1,1,0,0,1,0,0,0,1,1,1,1,0,0,0,0,0,0,0,1,0,1,1,1,1,0,1,0,1,1,0,0,0,0,1,0,1,0,1,1,0,0,0,0,1,0,0,0,0,1,0,1,1,0,1,0,0,1,0,1,1,1,0,1,1,1,1,1,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,0,0,1,1,0,1,0,1,0,1,1,0,0,0,1,1,1,1,0,1,1,0,1,1,1,1,1,1,0,0,1,1,1,0,0,0,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1,0,1,1,0,1,1,0,0,1,0,1,0,1,1,1,1,1,0,0,0,0,1,1,0,0,0,1,1,0,0,1,0,0,0,0,1,1,0,0,0,0,1,1,1,1,1,0,0,0,1,0,0,0,1,0,1,1,1,0,1,0,0,1,1,0,0,0,1,1,1,0,1,0,0,1,0,1,1,1,1,0,0,1,1,1,1,1,0,0,0,1,1,1,1,1,0,1,1,0,0,1,1,1,1,0,0,0,1,1,0,1,0,0,1,1,0,1,1,0,0,0,1,0,1,0,1,1,1,1,0,1,0,1,1,1,1,0,1,0,1,1,0,1,1,1,1,0,0,0,0,1,1,1,0,1,1,0,1,0,1,1,1,1,1,0,1,0,0,0,0,0,0,1,1,1,0,1,0,1,1,1,0,1,0,1,0,1,0,1,0,1,1,0,0,1,0,1,1,1,0,1,0,0,1,1,0,1,0,0,1,1,1,1,1,0,0,1,0,1,0,1,1,1,1,0,1,1,0,0,0,1,1,1,1,0,1,0,0,1,1,1,1,1,1,1,0,0,1,0,0,1,1,1,0,1,1};
        int t = m.longestOnes(A,289);
        System.out.println(t);
    }
    public int longestOnes(int[] A, int K) {
        System.out.println("A.length: "+A.length);
        if(K== 0){
            return longest(A,0,A.length -1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if(A[i] == 0){
              list.add(i);
            }
        }
        if(K>=list.size()){
            return A.length;
        }

        System.out.println(list.toString());
        System.out.println(list.size());
        if(list.size()>20)
        return 0;
        for (int j = 0; j < K; j++) {
            A[list.get(j)] = 1;
            System.out.println(list.get(j));
        }
        int max = longest(A,0,A.length-1);

        for (int i = 1; i < list.size() - K +1; i++) {
            A[list.get(i-1)] = 0;
            System.out.println(" ");
            System.out.println(list.get(i-1));
            A[list.get(i-1+K)] = 1;
            System.out.println(list.get(i-1+K));
            //计算最大值
            if(list.size() >= i+1+K && list.get(i-1+K) + 2 == list.get(i+1+K)) {
                continue;
            }

            max = Math.max(max,longest(A,list.get(i-1),list.get( Math.min(list.size() -1 , i-1+K))));

        }
        return  max;
    }

    public int longest(int[] A,int start,int end){
        int max = 0;
        int temp ;
        for (int i = start; i <= end; i++) {
            if(A[i] == 1){
                temp = 1;
                while (i+1<A.length && A[i+1] == 1){
                    temp++;
                    i++;
                }
                max = Math.max(temp,max);
            }
        }
        System.out.println("A:");
        for (int i = 0; i < A.length; i++) {
            System.out.printf(" "+A[i]);
        }
        System.out.println("max:"+max);
        return max;
    }
}
