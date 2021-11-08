package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2178 {
    static int N;
    static int M;
    static int[][] arr;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0 ; i < N; i++){
            String a = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(a.substring(j, j + 1));
            }
        }

        System.out.println(bfs(0,0));
    }

    static int bfs(int x, int y) {

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(x, y, 1));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.x == arr.length - 1 && poll.y == arr[0].length - 1) {
                return poll.depth;
            }
            for(int i = 0 ; i < dir.length; i++){
                int x_x = poll.x + dir[i][0];
                int y_y = poll.y + dir[i][1];

                if (x_x > -1 && x_x < arr.length && y_y > -1 && y_y < arr[x].length) {
                    if (arr[x_x][y_y] == 1 && visited[x_x][y_y] == false) {
                        visited[x_x][y_y] = true;
                        queue.add(new Node(x_x, y_y, poll.depth + 1));
                    }

                }
            }
        }
        return -1;
    }

    static class Node{

        int x;
        int y;
        int depth;

        Node(int x, int y, int depth) {
            this.x = x;
            this.y= y;
            this.depth = depth;
        }
    }
}
