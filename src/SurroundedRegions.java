import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 130. 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * https://leetcode-cn.com/problems/surrounded-regions/
 */

public class SurroundedRegions {

    public static void main(String[] args) {
        SurroundedRegions s = new SurroundedRegions();
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','O'},
                {'O','X','O','X'},
                {'X','O','X','X'}
        };
        s.solve(board);
    }

    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0){
            return;
        }

        //1.遍历四条边 把边上的o 放入 待搜索队列
        LinkedList<int[]> findList = new LinkedList<>();
        int y = board[0].length - 1;
        int x = board.length - 1;
        //竖
        for (int i = 0; i < board.length; i++) {
            if(board[i][0] == 'O'){
                int[] temp = {i,0};
                findList.add(temp);
            }
            if(board[i][y] == 'O'){
                int[] temp = {i,y};
                findList.add(temp);
            }
        }

        for (int i = 1; i < y; i++) {
            if(board[0][i] == 'O'){
                int[] temp = {0,i};
                findList.add(temp);
            }
            if(board[x][i] == 'O'){
                int[] temp = {x,i};
                findList.add(temp);
            }
        }

        //2.从搜索队列取出边上的o 广度优先搜索 所有与之相连的o(未被放入list) 放入不会被填充的list
        while (!findList.isEmpty()){
            int[] arr = findList.remove(0);
            System.out.println(arr[0] + " " +arr[1]);
            bfs(board,arr[0],arr[1]);
        }

        //3.遍历board 把不在list中的o 填充为x
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O' && !visited.contains(i+","+j)){
                    board[i][j] = 'X';
                }
            }
        }

    }
    ArrayList<String> visited = new ArrayList<>();
    public void bfs(char[][] board, int x,int y){
        if(x<0 || y<0 || x>= board.length || y >= board[0].length){
            return;
        }
        System.out.println("vis:" + x +" "+y);
        if(visited.contains(x+","+y) || board[x][y] == 'X'){
            return;
        }
        visited.add(x+","+y);
        bfs(board,x+1,y);
        bfs(board,x-1,y);
        bfs(board,x,y-1);
        bfs(board,x,y+1);
    }
}
