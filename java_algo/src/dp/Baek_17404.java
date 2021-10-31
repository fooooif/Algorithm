package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Baek_17404 {
    static int min = 10000000;
    static int[][] dp;
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        //1번부터 시작하는거랑
        //2번부터 시작하는 거랑
        //3번 부터 시작하는거랑 세번을 하는게 좋을까?
        arr = new int[N + 1][3];
        dp = new int[N + 1][3];

        for(int i = 1; i< N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //1
        //2
        //3


        for(int i = 0 ; i < 3 ;i++){
            dp = new int[N+1][3];
            vv(i);
        }
        System.out.println(min);
    }
    static void vv(int num){

        for(int i = 0 ; i < 3; i++){
            if(i != num){
                dp[1][i] = 10000000;
            }
            else{
                dp[1][num] = arr[1][num];
            }

        }
        for (int i = 2; i < N+1; i++) {

            dp[i][0] = Math.min(dp[i - 1][1] + arr[i][0], dp[i - 1][2] + arr[i][0]);
            dp[i][1] = Math.min(dp[i - 1][0] + arr[i][1], dp[i - 1][2] + arr[i][1]);
            dp[i][2] = Math.min(dp[i - 1][0] + arr[i][2], dp[i - 1][1] + arr[i][2]);

        }
        dp[N][num] = 10000000;
        for(int i = 0 ; i < 3; i++){
            min = Math.min(min,dp[N][i]);
        }
    }
}
