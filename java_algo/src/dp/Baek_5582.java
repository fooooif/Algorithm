package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_5582 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        dp = new int[a.length()+1][b.length()+1];

        for(int i = 0 ; i < a.length()+1; i++){
            dp[i][0] = 0;
        }
        for(int j = 0 ; j < b.length()+1; j++){
            dp[0][j] = 0;
        }

        int max = 0;
        for(int i = 1 ; i < a.length()+1 ; i++){
            for(int j = 1 ; j < b.length()+1; j++){
                if (a.substring(i-1, i).equals(b.substring(j-1, j))) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(dp[i][j],max);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(max);
    }

}
