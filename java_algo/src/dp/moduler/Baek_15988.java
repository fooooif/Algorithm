package dp.moduler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Baek_15988 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long dp[] = new long[1000004];
        dp[0] =1;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 1000000; i++) {
            dp[i + 1] += dp[i] % 1000000009;
            dp[i + 2] += dp[i] % 1000000009;
            dp[i + 3] += dp[i] % 1000000009;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(dp[Integer.parseInt(br.readLine())]% 1000000009);
        }
    }
}
