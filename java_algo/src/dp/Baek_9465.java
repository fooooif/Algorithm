package dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_9465 {

    static int n;
    static int T;
    static int[][] dp;
    static int[][] value;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T; i++){
            n = Integer.parseInt(br.readLine());
            dp = new int[2][n];
            value = new int[2][n];
            for(int k = 0; k< 2;k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    value[k][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = value[0][0];
            dp[1][0] = value[1][0];

            for(int j = 1; j <n; j++){
                if(j == 1 ){
                    dp[0][j] = value[0][j] + dp[1][j-1];
                    dp[1][j] = value[1][j] + dp[0][j-1];
                }
                else{
                    dp[0][j] = Math.max(value[0][j] + dp[1][j-1],value[0][j]+dp[1][j-2]);
                    dp[1][j] = Math.max(value[1][j] + dp[0][j - 1], value[1][j] + dp[0][j - 2]);
                }
            }
            int max = Math.max(dp[0][n - 1], dp[1][n - 1]);
            System.out.println(max);
        }
    }
}
