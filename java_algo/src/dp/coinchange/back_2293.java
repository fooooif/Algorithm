package dp.coinchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_2293 {
    static int n;
    static int k;
    static int[] coins;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        k = Integer.parseInt(st.nextToken());
        int answer = 0;

        dp = new int[n][k+1];
        coins = new int[n];
        for(int i = 0 ; i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);
        for(int i = 0 ; i < n; i++){
            for(int j = 1 ; j < k+1; j++){
                if(coins[i] != 1){
                    if(j > coins[i]){
                        for(int a = 0 ; a < i + 1; a++){
                            dp[i][j] += dp[a][j - coins[i]];
                        }
                    }
                    else if(j == coins[i]){
                        dp[i][j] =1;
                    }
                }
                else{
                    dp[i][j] = 1;
                }
            }
        }
        for(int i = 0 ; i < n; i++){
            answer += dp[i][k];
        }

        System.out.println(answer);
    }
}
class version_2{
    static int n;
    static int k;
    static int[] coins;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        k = Integer.parseInt(st.nextToken());
        int answer = 0;

        dp = new int[n+1][k + 1];
        coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i< n+1; i++){
            dp[i][0] = 1;
        }

        for(int i = 1 ; i < n+1; i++){
            for(int j = 1 ; j < k+1; j++){
                if(j < coins[i]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}