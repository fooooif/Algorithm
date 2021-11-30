package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_10026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[][] arr = new String[N][N];

        for (int i = 0 ; i < N; i++){
            String aa = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = aa.substring(j, j + 1);
            }
        }

        boolean[][] visited = new boolean[N][N];
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        System.out.print(rgb(N, arr, visited, dir) + " ");

        visited = new boolean[N][N];
        for (int i = 0 ; i < N; i++){
            for (int j = 0; j < N; j++) {
                if (arr[i][j].equals("R")) {
                    arr[i][j] = "G";
                }
            }
        }
        System.out.println(rgb2(N, arr, visited, dir));
    }

    static int rgb(int N, String[][] arr, boolean[][] visited, int[][] dir) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (visited[i][j] == false) {
                    count++;
                    Queue<Node> queue = new LinkedList<>();

                    queue.add(new Node(i, j, arr[i][j]));
                    while (!queue.isEmpty()) {
                        Node poll = queue.poll();

                        for (int k = 0; k < dir.length; k++) {
                            int x = poll.x + dir[k][0];
                            int y = poll.y + dir[k][1];

                            if (x > -1 && x < N && y > -1 && y < N) {
                                if (visited[x][y] == false && arr[x][y].equals(poll.cost)) {
                                    visited[x][y] = true;
                                    queue.add(new Node(x, y, poll.cost));
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    static int rgb2(int N, String[][] arr, boolean[][] visited, int[][] dir){
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (visited[i][j] == false) {
                    count++;
                    Queue<Node> queue = new LinkedList<>();

                    queue.add(new Node(i, j, arr[i][j]));
                    while (!queue.isEmpty()) {
                        Node poll = queue.poll();

                        for (int k = 0; k < dir.length; k++) {
                            int x = poll.x + dir[k][0];
                            int y = poll.y + dir[k][1];

                            if (x > -1 && x < N && y > -1 && y < N) {
                                if (visited[x][y] == false && arr[x][y].equals(poll.cost)) {
                                    visited[x][y] = true;
                                    queue.add(new Node(x, y, poll.cost));
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    static class Node{
        int x ;
        int y;
        String cost;
        Node(int x,int y, String cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
