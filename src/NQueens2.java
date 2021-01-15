/**
 * 52. N皇后 II
 */
public class NQueens2 {
    public static void main(String[] args) {

        int n = 5;
        NQueens2 q = new NQueens2();
        int totle = q.totalNQueens(n);
        System.out.println(totle);

    }

    int count = 0;
    public int totalNQueens(int n) {
        if(n == 1){
            return 1;
        }else if(n <= 3){
            return 0;
        }
        int[][] map = new int[n][n];
        backTrace(n,map,0,0,0);
        return count;
    }

    public void backTrace(int n,int[][] map,int x,int y,int num ){
//        System.out.println(list.toString());
        //判断是否满足N皇后不能互相攻击
        if(num == n){
            System.out.println("==="+x+" __"+y);
            printMap(map,n);
            count++;
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
