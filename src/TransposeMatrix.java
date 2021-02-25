/**
 * 867. 转置矩阵
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 *
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 1 <= m * n <= 105
 * -109 <= matrix[i][j] <= 109
 * 通过次数54,185提交次数79,669
 *
 * https://leetcode-cn.com/problems/transpose-matrix/
 */
public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        int[][] map = new int[y][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0;j< y; j++) {
                map[j][i] = matrix[i][j];
            }
        }
        return map;
    }
}
