package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11660 {
    static int N;
    static int M;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        dp = new int[N+1][N+1];
        Node[] nodes = new Node[M];
        for(int i = 1 ; i < N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j < N+1 ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 1 ; i < N+1; i++){
            for(int j = 1 ; j < N+1 ; j++){
                dp[i][j] = arr[i][j] + dp[i-1][j] - dp[i-1][j-1] +dp[i][j-1];
            }
        }


        for(int i = 0; i< M; i++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(x1, y1,x2,y2);
        }



        for(int i = 0 ; i < M ; i++){

            int sum = dp[nodes[i].x2][nodes[i].y2] - dp[nodes[i].x1 -1][nodes[i].y2] -dp[nodes[i].x2][nodes[i].y1-1] + dp[nodes[i].x1-1][nodes[i].y1-1];

            System.out.println(sum);
        }


    }
    static class Node{
        int x1;
        int y1;
        int x2;
        int y2;
        Node(int x1, int y1,int x2,int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;

        }
    }
}
