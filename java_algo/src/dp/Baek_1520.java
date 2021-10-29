package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Baek_1520 {
    static int M;
    static int N;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        dp = new int[M][N];
        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i = 0 ; i < M; i++){
            for(int j = 0 ; j < N; j++){

                for(int k = 0 ; k < dir.length; k++){
                    int x = i+dir[k][0];
                    int y = j+dir[k][1];

                    if (x > -1 && x < M && y > -1 && y < N && dp[i][j] < dp[x][y]) {
                        dp[i][j] = dp[i][j] + dp[x][y];
                    }
                }
            }
        }
        //1년동안 열심히 한것

    }
}
