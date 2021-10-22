package dp.knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_12865 {
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        int[][] dp = new int[N + 1][K + 1];
        WV[] list = new WV[N];
        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            list[i] = new WV(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        }

        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < K+1; j++){
                if(j < list[i].weigth){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - list[i].weigth] + list[i].value);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
    static class WV{
        int weigth;
        int value;
        WV(int a, int b){
            this.weigth =a;
            this.value = b;
        }
    }
}
