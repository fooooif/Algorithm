//package nosolve;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.nio.Buffer;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Baek_1520 {
//    static int M;
//    static int N;
//    static int[][] arr;
//    static int[][] dp;
//    static boolean[][] visited;
//    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        M = Integer.parseInt(st.nextToken());
//        N = Integer.parseInt(st.nextToken());
//
//        arr = new int[M][N];
//        dp = new int[M][N];
//        visited = new boolean[M][N];
//        for(int i = 0 ; i < M; i++){
//            st = new StringTokenizer(br.readLine());
//            for(int j = 0 ; j < N; j++){
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        dp[0][0] = 1;
//
//
//
//
////
////        while (!queue.isEmpty()) {
////            Node poll = queue.poll();
////
////
////            for (int k = 0; k < dir.length; k++) {
////                int x = poll.x + dir[k][0];
////                int y = poll.y + dir[k][1];
////
////                if (x > -1 && x < M && y > -1 && y < N ) {
////                    if (arr[poll.x][poll.y] > arr[x][y]) {
////                        if (visited[x][y] == false) {
////                            dp[x][y] += dp[poll.x][poll.y];
////                        }
////                        else {
////                            dp[x][y] = dp[poll.x][poll.y];
////                        }
////                    }
////                }
////            }
////        }
//        //1년동안 열심히 한것
//
//    }
//    static class Node{
//        int x;
//        int y;
//        Node(int x,int y){
//            this.x = x;
//            this.y = y;
//
//        }
//    }
//
//    static void dfs(int x, int y) {
//
//
//        if (x == arr.length - 1 && y == arr.length - 1) {
//            return;
//        }
//        for (int i = 0; i < dir.length; i++) {
//            int x_x = x + dir[i][0];
//            int y_y = y + dir[i][1];
//            if (x_x > -1 && x_x < M && y_y > -1 && y_y < N) {
//                if (arr[x_x][y_y] < arr[x][y]) {
//                    if (visited[x_x][y_y] == true) {
//
//                    }
//                    dp[]
//                    dfs(x_x, y_y);
//                }
//            }
//        }
//    }
//}
