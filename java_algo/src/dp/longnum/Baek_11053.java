package dp.longnum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11053 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        int[] dp  = new int[N+1];

        for(int i = 1 ; i < N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());

        }
        for(int i =1 ; i < N+1 ; i++){
            dp[i] = 1;
            for(int k = 0 ; k < i;k++){
                if(arr[k] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[k] + 1);
                }
            }
        }

        int max = 0;
        for(int i = 0 ; i < N+1; i++){
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);


    }
}
