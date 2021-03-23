import java.util.HashSet;

/**
 * 391. 完美矩形
 * 我们有 N 个与坐标轴对齐的矩形, 其中 N > 0, 判断它们是否能精确地覆盖一个矩形区域。
 *
 * 每个矩形用左下角的点和右上角的点的坐标来表示。例如， 一个单位正方形可以表示为 [1,1,2,2]。 ( 左下角的点的坐标为 (1, 1) 以及右上角的点的坐标为 (2, 2) )。
 *
 * 示例 1:
 *
 * rectangles = [
 *   [1,1,3,3],
 *   [3,1,4,2],
 *   [3,2,4,4],
 *   [1,3,2,4],
 *   [2,3,3,4]
 * ]
 *
 * 返回 true。5个矩形一起可以精确地覆盖一个矩形区域。
 *
 * 示例 2:
 *
 * rectangles = [
 *   [1,1,2,3],
 *   [1,3,2,4],
 *   [3,1,4,2],
 *   [3,2,4,4]
 * ]
 *
 * 返回 false。两个矩形之间有间隔，无法覆盖成一个矩形。
 *
 * 示例 3:
 *
 * rectangles = [
 *   [1,1,3,3],
 *   [3,1,4,2],
 *   [1,3,2,4],
 *   [3,2,4,4]
 * ]
 *
 * 返回 false。图形顶端留有间隔，无法覆盖成一个矩形。
 *
 * 示例 4:
 *
 * rectangles = [
 *   [1,1,3,3],
 *   [3,1,4,2],
 *   [1,3,2,4],
 *   [2,2,4,4]
 * ]
 *
 * 返回 false。因为中间有相交区域，虽然形成了矩形，但不是精确覆盖。
 * 通过次数3,157提交次数9,740
 *
 * https://leetcode-cn.com/problems/perfect-rectangle/
 */

public class PerfectRectangle {
    public static void main(String[] args) {
        PerfectRectangle p = new PerfectRectangle();
        int[][] rec = {
                {1,1,3,3},
                {3,1,4,2},
                {3,2,4,4},
                {1,3,2,4},
                {2,3,3,4}
        };

        boolean ret =  p.isRectangleCover(rec);
        System.out.println(ret);
    }
    public boolean isRectangleCover(int[][] rectangles) {
        int minX = rectangles[0][0];
        int minY = rectangles[0][1];
        int maxX = rectangles[0][2];
        int maxY = rectangles[0][3];
        int sum = 0;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < rectangles.length; i++) {
            minX = Math.min(minX,rectangles[i][0]);
            minY = Math.min(minY,rectangles[i][1]);

            maxX = Math.max(maxX,rectangles[i][2]);
            maxY = Math.max(maxY,rectangles[i][3]);

            sum += (rectangles[i][2] - rectangles[i][0]) * (rectangles[i][3] - rectangles[i][1]);

            String p1 = ""+rectangles[i][0]+","+rectangles[i][1];
            String p2 = ""+rectangles[i][2]+","+rectangles[i][3];
            String p3 = ""+rectangles[i][0]+","+rectangles[i][3];
            String p4 = ""+rectangles[i][2]+","+rectangles[i][1];
            if(set.contains(p1)){
                set.remove(p1);
            }else {
                set.add(p1);
            }
            if(set.contains(p2)){
                set.remove(p2);
            }else {
                set.add(p2);
            }
            if(set.contains(p3)){
                set.remove(p3);
            }else {
                set.add(p3);
            }
            if(set.contains(p4)){
                set.remove(p4);
            }else {
                set.add(p4);
            }
        }

        if(sum != (maxX - minX) * (maxY-minY)){
            return false;
        }

        if(set.size() != 4){
            return false;
        }
        if(!set.contains(""+minX+","+minY)){
            return false;
        }
        if(!set.contains(""+minX+","+maxY)){
            return false;
        }
        if(!set.contains(""+maxX+","+minY)){
            return false;
        }
        if(!set.contains(""+maxX+","+maxY)){
            return false;
        }
        return true;
//        System.out.println( "sum : "+ sum);
//        System.out.println(minX + " " + minY + " " + maxX + " " +maxY);
//
//
//        for (int i = 0; i < rectangles.length-1; i++) {
//            for (int j = i+1; j < rectangles.length; j++) {
//                if(rectangles[j][0] >= rectangles[i][0] && rectangles[j][0] < rectangles[i][2]
//                    && rectangles[j][1] >= rectangles[i][1] && rectangles[j][1] < rectangles[i][3]
//                        ||
//                        rectangles[j][2] > rectangles[i][0] && rectangles[j][2] <= rectangles[i][2]
//                        && rectangles[j][3] > rectangles[i][1] && rectangles[j][3] <= rectangles[i][3]
//                ){
//                    return false;
//                }
//            }
//        }
//        return true;

//        boolean[][] map = new boolean[maxX-minX][maxY-minY];
//        for (int i = 0; i < rectangles.length; i++) {
//            for (int j = rectangles[i][0] - minX; j < rectangles[i][2] - minX ; j++) {
//                for (int l = rectangles[i][1] - minY; l < rectangles[i][3] - minY ; l++) {
//                    if(map[j][l]){
//                        return false;
//                    }else {
//                        map[j][l] = true;
//                    }
//                }
//            }
//        }

//        for (int i = 0; i < maxX - minX ; i++) {
//            for (int j = 0; j < maxY - minY ; j++) {
//                System.out.printf(" " + map[i][j]);
//                if(!map[i][j]){
//                    return false;
//                }
//            }
//            System.out.println(" ");
//        }


//        return true;
    }
}
