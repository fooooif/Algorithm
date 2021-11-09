package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());



        long[][] dp = new long[10][2];

        for (int i = 1 ; i < dp.length; i++){
            dp[i][0] = 1;
        }
        for (int k = 0; k < N-1; k++) {
            for (int i = 0; i < dp.length; i++) {
                if (i == 0) {
                    dp[i + 1][1] += dp[i][0] % 1000000000;
                } else if (i == 9) {
                    dp[i - 1][1] += dp[i][0] % 1000000000;
                } else {
                    dp[i - 1][1] += dp[i][0] % 1000000000;
                    dp[i + 1][1] += dp[i][0] % 1000000000;
                }

            }
            for (int j = 0; j < dp.length; j++) {
                dp[j][0] = dp[j][1];
                dp[j][1] = 0;
            }
        }
            long count = 0;
            for(int i = 0 ; i < dp.length ; i++){
                count += dp[i][0];
            }
            System.out.println(count%1000000000);



    }
}
