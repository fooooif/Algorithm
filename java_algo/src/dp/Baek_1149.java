package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1149 {
    static int N ;
    static int[][] color;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        color = new int[N+1][3];
        for (int i = 1; i < N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3; j++){
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[N+1][3];
        //이웃한 집과 색이 달라야함

        dp[1][0] = color[1][0];
        dp[1][1] = color[1][1];
        dp[1][2] = color[1][2];
        for(int i = 2; i < N+1; i++){
            dp[i][0] = Math.min(dp[i-1][1] + color[i][0], dp[i-1][2] + color[i][0]);
            dp[i][1] = Math.min(dp[i-1][0] + color[i][1], dp[i-1][2] + color[i][1]);
            dp[i][2] = Math.min(dp[i-1][0] + color[i][2], dp[i-1][1] + color[i][2]);
        }
        int min = dp[N][0] ;
        for(int i = 1 ; i <3; i++){
            min = Math.min(dp[N][i], min);
        }

        System.out.println(min);



    }
}
