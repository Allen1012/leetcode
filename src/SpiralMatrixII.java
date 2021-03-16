/**
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 * 提示：
 *
 * 1 <= n <= 20
 * 通过次数78,350提交次数98,059
 *
 *https://leetcode-cn.com/problems/spiral-matrix-ii/
 */

public class SpiralMatrixII {
    public static void main(String[] args) {
        SpiralMatrixII s = new SpiralMatrixII();
        int n = 3;
        int[][] map = s.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf(" "+map[i][j]);
            }
            System.out.println(" ");
        }
    }
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int sL = 0;
        int sH = 0;
        int l = n - 1;
        int h = n - 1;
        int num = 1;
        while (sL <= l && sH <= h){
            for (int i = sL; i <= l; i++) {
                if(num <= n*n ){
                    matrix[sH][i] = num;
                }
                num++;
            }
            sH++;
            for (int i = sH; i <= h; i++) {
                if(num <= n*n ){
                    matrix[i][l] = num;
                }
                num++;
            }
            l--;
            for (int i = l; i >= sL; i--) {
                if(num <= n*n ){
                    matrix[h][i] = num;
                }
                num++;
            }
            h--;
            for (int i = h; i >= sH; i--) {
                if(num <= n*n ){
                    matrix[i][sL] = num;
                }
                num++;
            }
            sL++;

        }
        return matrix;
    }
}






































