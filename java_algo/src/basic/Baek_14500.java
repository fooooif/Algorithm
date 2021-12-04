package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_14500 {
    static int max=-1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // ->->->
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][][] dir_2 = new int[][][]{{{1, 0}, {1, 1}, {0, 1}}, {{1, 0}, {0, -1}, {1, -1}}, {{-1, 0}, {-1, -1}, {0, -1}}, {{-1, 0}, {-1, 1}, {0, 1}},
                {{1, 0}, {-1, 0}, {0, 1}}, {{1, 0}, {-1, 0}, {0, -1}}, {{0, 1}, {0, -1}, {1, 0}}, {{0, 1}, {0, -1}, {-1, 0}}};
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for(int j = 0 ; j < M; j++){

                Queue<Node> queue = new LinkedList<>();

                queue.add(new Node(i, j, arr[i][j],1));
                while (!queue.isEmpty()) {
                    Node poll = queue.poll();
                    visited[poll.x][poll.y] = true;
                    if (poll.count == 4) {
                        max = Math.max(max, poll.cost);
                        continue;
                    }
                    for (int k = 0 ; k < dir.length; k++){
                        int x = poll.x + dir[k][0];
                        int y = poll.y + dir[k][1];
                        if (x > -1 && x < N && y > -1 && y < M) {
                            if (visited[x][y] == false) {
                                queue.add(new Node(x, y, poll.cost + arr[x][y],poll.count + 1));
                            }
                        }
                    }
                }
                clearVisited(visited);
                for (int k = 0; k < dir_2.length;k++){
                    int cost = arr[i][j];
                    for(int a = 0 ; a < dir_2[k].length; a++){
                        int x = i + dir_2[k][a][0];
                        int y = j + dir_2[k][a][1];
                        if (x > -1 && x < N && y > -1 && y < M) {
                            cost += arr[x][y];
                        }else {
                            cost = -1;
                            break;
                        }

                    }
                    max = Math.max(cost, max);
                }


            }
        }

        System.out.println(max);
    }

    static void clearVisited(boolean[][] visited) {
        for (int i = 0 ; i < visited.length; i++){
            for(int j = 0 ; j < visited[i].length; j++){
                visited[i][j] = false;
            }
        }
    }
    static class Node{
        int x;
        int y;
        int cost;
        int count;
        Node(int x, int y, int cost,int count) {
            this.x = x;
            this.y= y;
            this.cost = cost;
            this.count = count;
        }
    }
}
