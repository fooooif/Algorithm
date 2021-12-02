package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_16236 {
    public static void main(String[] args) throws IOException {
        //N * N
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        int shark_level =2;
        int level_count = 0 ;
        int fish_count = 0;
        for (int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    Node sha = new Node(i, j);
                }else if(arr[i][j] > 0){
                    fish_count++;
                }
            }
        }

        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<Node> queue = new LinkedList<>();


    }
    static class Node{
        int x ;
        int y ;

        Node(int x, int y) {
            this.x= x;
            this.y = y;

        }
    }
}
