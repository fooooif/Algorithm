package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_9251 {
    static int[][] dp ;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        dp = new int[a.length() + 1][b.length() + 1];

        for(int i = 1; i < a.length()+1; i++){
            for(int j = 1; j < b.length()+1; j++){
                if (a.substring(i - 1, i).equals(b.substring(j - 1, j))) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[a.length() ][b.length() ]);
    }
}
