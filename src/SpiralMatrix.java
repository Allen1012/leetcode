import java.util.LinkedList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * 通过次数117,780提交次数264,859
 *
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        s.spiralOrder(matrix);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> list = new LinkedList<>();
        int sL = 0;
        int sH = 0;
        int l = matrix[0].length - 1;
        int h = matrix.length - 1;
        int sum = (l+1)*(h+1);
        while (sL <= l && sH <= h){
            for (int i = sL; i <= l; i++) {
                if(list.size() < sum ){
                    list.add(matrix[sH][i]);
                }
            }
            sH++;
            for (int i = sH; i <= h; i++) {
                if(list.size() < sum ){
                    list.add(matrix[i][l]);
                }
            }
            l--;
            for (int i = l; i >= sL; i--) {
                if(list.size() < sum ){
                    list.add(matrix[h][i]);
                }
            }
            h--;
            for (int i = h; i >= sH; i--) {
                if(list.size() < sum ){
                    list.add(matrix[i][sL]);
                }
            }
            sL++;

            System.out.println(list);
        }
        System.out.println(list);
        return list;
    }
}


















