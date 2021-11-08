package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2206 {
//    static int min ;
//    static boolean[][] visited;
//    static int[][] arr;
//    static int[][] dir;
//    static boolean visit = false;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//
//        int M = Integer.parseInt(st.nextToken());
//        min = M*N;
//        visited = new boolean[N][M];
//       arr = new int[N][M];
//
//        for(int i = 0 ; i < arr.length; i++){
//            String a = br.readLine();
//            for (int j = 0; j < arr[i].length; j++) {
//                arr[i][j] = Integer.parseInt(a.substring(j, j + 1));
//            }
//        }
//        dir = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
//
//        visited[0][0] = true;
//        bfs(0, 0, 1);
//        System.out.println(min);
//    }
//
//    static void bfs(int x, int y, int count) {
//
//        if (x == arr.length - 1 && y == arr[x].length - 1) {
//
//            min = Math.min(min, count);
//
//            return;
//        }
//        for (int i = 0; i < dir.length; i++) {
//            int x_x = x + dir[i][0];
//            int y_y = y + dir[i][1];
//            if (x_x > -1 && x_x < arr.length && y_y > -1 && y_y < arr[0].length) {
//
//                if (arr[x_x][y_y] == 0 && visited[x_x][y_y] == false) {
//                    visited[x_x][y_y] = true;
//                    bfs(x_x, y_y, count + 1);
//                    visited[x_x][y_y] = false;
//                }else if (visit == false && arr[x_x][y_y] == 1 &&visited[x_x][y_y] == false) {
//                    visit = true;
//                    visited[x_x][y_y] = true;
//                    bfs(x_x, y_y, count + 1);
//                    visited[x_x][y_y] = false;
//                    visit = false;
//                }
//            }
//
//        }
//    }
    /**
     * 위에꺼는 dfs 쓴거였지만 시간초과 밑에 bfs 쓴
     */
    static boolean[][][] visited;
    static int[][] arr;
    static int[][] dir;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M][2];
       arr = new int[N][M];

        for(int i = 0 ; i < arr.length; i++){
            String a = br.readLine();
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(a.substring(j, j + 1));
            }
        }
        dir = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        visited[0][0][0] = true;
        visited[0][0][1] = false;
        System.out.println(bfs(0, 0));

    }
    static int bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(x, y, 1));

        while (!queue.isEmpty()) {

            Node node = queue.poll();
            if (node.x == arr.length - 1 && node.y == arr[0].length - 1) {
                return node.depth;
            }
            for(int i = 0 ; i < dir.length ; i++){
                int x_x = node.x + dir[i][0];
                int y_y = node.y + dir[i][1];

                if (x_x > -1 && x_x < arr.length && y_y > -1 && y_y < arr[0].length) {
                    if (arr[x_x][y_y] == 0 && visited[x_x][y_y][0] == false) {
                        if (visited[node.x][node.y][1] == true) {
                            visited[x_x][y_y][1] = true;
                        }
                        visited[x_x][y_y][0] = true;
                        queue.add(new Node(x_x, y_y, node.depth + 1));
                    } else if (arr[x_x][y_y] == 0 && visited[x_x][y_y][0] == true && visited[node.x][node.y][1] == false && visited[x_x][y_y][1] == true) {
                        visited[x_x][y_y][0] = true;
                        visited[x_x][y_y][1] = false;
                        queue.add(new Node(x_x, y_y, node.depth + 1));

                    } else if (arr[x_x][y_y] == 1 && visited[node.x][node.y][1] == false) {
                        visited[x_x][y_y][0] = true;
                        visited[x_x][y_y][1] = true;
                        queue.add(new Node(x_x, y_y, node.depth + 1));
                    }
                }
            }
        }
        return  -1;

    }
    static class Node{
        int x;
        int y;
        int depth;

        Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
