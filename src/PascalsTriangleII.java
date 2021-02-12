import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * 难度
 * 简单
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class PascalsTriangleII {

    public static void main(String[] args) {
        PascalsTriangleII p = new PascalsTriangleII();
        p.getRow(33);
    }


    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<>();

        if(rowIndex == 0){
            list.add(1);
            return list;
        }
        if(rowIndex == 1){
            list.add(1);
            list.add(1);
            return list;
        }

        int[][] map = new int[rowIndex+1][rowIndex+1];
        map[0][0] = 1;
        map[1][0] = 1;
        map[1][1] = 1;
        for (int i = 2; i < rowIndex+1; i++) {
            for (int j = 0; j <= i; j++) {
                if(j==0){
                    map[i][j] = 1;
                }else if(j == i) {
                    map[i][j] = 1;
                }else {
                    map[i][j] = map[i-1][j] + map[i-1][j-1];

                }
            }
        }

        for (int i = 0; i < rowIndex+1; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.printf(" "+map[i][j]);
            }
            System.out.println(" ");
        }
        for (int i = 0; i < map[rowIndex].length; i++) {
            list.add(map[rowIndex][i]);
        }
        return list;
    }
}
