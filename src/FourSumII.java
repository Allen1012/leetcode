import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * 通过次数58,998提交次数100,950
 *
 * https://leetcode-cn.com/problems/4sum-ii/
 */
public class FourSumII {
    public static void main(String[] args) {
        FourSumII f = new FourSumII();
        int[] A = {1,2};
        int[] B = {-2,-1};
        int[] C = {-1,2};
        int[] D = {0,2};
        f.fourSumCount(A,B,C,D);
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int sum = 0;
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if(map1.containsKey(A[i] + B[j])){
                    map1.put(A[i]+B[j],map1.get(A[i]+B[j])+1);
                }else {
                    map1.put(A[i]+B[j],1);
                }
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                if(map2.containsKey(C[i] + D[j])){
                    map2.put(C[i]+D[j],map2.get(C[i]+D[j])+1);
                }else {
                    map2.put(C[i]+D[j],1);
                }
            }
        }
        System.out.println(map1.toString());
        System.out.println(map2.toString());

        for (Map.Entry<Integer, Integer> entry1 : map1.entrySet()) {

//                System.out.println("key = " + entry2.getKey() + ", value = " + entry2.getValue())
            if(map2.containsKey(0-entry1.getKey())){
                sum += entry1.getValue() * map2.get(0-entry1.getKey());
            }
        }
        return sum;
    }
}


//    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
//        int sum = 0;
//        for (int i = 0; i < A.length; i++) {
//            for (int j = 0; j < B.length; j++) {
//                for (int k = 0; k < C.length; k++) {
//                    for (int l = 0; l < D.length; l++) {
//                        if(A[i] + B[j] + C[k] + D[l] == 0){
//                            sum++;
//                        }
//                    }
//                }
//            }
//        }
//        return sum;
//    }
