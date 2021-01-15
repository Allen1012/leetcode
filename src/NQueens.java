import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 51. N 皇后
 */
public class NQueens {
    public static void main(String[] args) {

        int n = 4;

//        int[][] map = new int[n][n];
//        q.printMap(map,n);
//        map = q.updateMap(map,n,0,1,1);
//        q.printMap(map,n);
//        map = q.updateMap(map,n,1,3,1);
//        q.printMap(map,n);
//        map = q.updateMap(map,n,2,0,1);
//        q.printMap(map,n);
//        map = q.updateMap(map,n,3,2,1);
//        q.printMap(map,n);
//
//        map = q.updateMap(map,n,0,1,0);
//        q.printMap(map,n);
//        map = q.updateMap(map,n,1,3,0);
//        q.printMap(map,n);
//        map = q.updateMap(map,n,2,0,0);
//        q.printMap(map,n);
//        map = q.updateMap(map,n,3,2,0);
//        q.printMap(map,n);

        NQueens q = new NQueens();
        List<List<String>> list = q.solveNQueens(n);

        System.out.println(list.toString());

    }
    List<List<String>> lists = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {

        if(n == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add("Q");
            lists.add(list);
            return lists;
        }else if(n <= 3){
            return lists;
        }


        int[][] map = new int[n][n];
        backTrace(n,map,0,0,0);
        return lists;
    }

    public void backTrace(int n,int[][] map,int x,int y,int num ){
//        System.out.println(list.toString());
        //判断是否满足N皇后不能互相攻击
        if(num == n){
            System.out.println("==="+x+" __"+y);
            printMap(map,n);
            ArrayList<String> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                StringBuffer str = new StringBuffer();
                for (int j = 0; j < n; j++) {
                    if(map[i][j] == -1){
                        str.append("Q");
                    }else{
                        str.append(".");
                    }
                }
                list.add(str.toString());
            }

            lists.add(new ArrayList(list));
//            return;
        }
        int mapY = 0;
        for(int i = x; i < n; i++){
            mapY = 0;
            for (int j = 0; j < n; j++) {
                //判断是否可以访问
                if(map[i][j] != 0){
                    if(map[i][j] >= 1){
                        mapY++;
                    }
                    continue;
                }
//                list.add(nums[i]);
                map = updateMap(map,n,i,j,1);
//                printMap(map,n);
                //更新 行 列 斜 为-1
                backTrace(n,map,i,j,num+1);
                map = updateMap(map,n,i,j,-1);
//                list.remove(list.size()-1);
            }
            if(mapY == n){
                System.out.println("-------1111");
                break;
            }
        }
    }

    //0 可访问
    //1 2 3 4 已经被访问
    //-1 queue
    public int[][] updateMap(int[][] map,int n,int x,int y,int val){
        if(val == 1){
            map[x][y] = -1;
        }else {
            map[x][y] = 0;
        }

//        if(val == 1){
//            val = -1;
//        }
        //纵行
        for (int i = 0; i < n; i++) {
            if(i != y){
                map[x][i] += val;
            }
        }
        //横行
        for (int j = 0; j < n; j++) {
            if(j != x){
                map[j][y] += val;
            }
        }
        //斜
        for (int i = x +1,j = y+1; i < n && j < n; i++,j++) {
            map[i][j] += val;
        }
        //斜
        for (int i = x -1,j = y+1; i >= 0 && j < n; i--,j++) {
            map[i][j] += val;
        }
        //斜
        for (int i = x+1,j = y-1; i <n && j >=0 ; i++,j--) {
            map[i][j] += val;
        }
        //斜
        for (int i = x -1,j = y-1; i >= 0 && j >= 0; i--,j--) {
            map[i][j] += val;
        }

        return map;
    }

    public void printMap(int[][] map,int n){
        System.out.println("map:   ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf(" "+map[i][j]);
            }
            System.out.println(" ");
        }
    }

}
