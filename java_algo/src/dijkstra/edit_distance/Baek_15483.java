package dijkstra.edit_distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_15483 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] input = new String[2];
        input[0] = br.readLine();
        input[1] = br.readLine();
        int x_length = input[0].length();
        int y_length = input[1].length();

        int[][] dp = new int[x_length + 1][y_length + 1];

        for(int i = 1; i < x_length +1; i++){
            dp[i][0] = input[0].substring(0,i).length();

        }
        for(int j = 1; j < y_length +1; j++){
            dp[0][j] = input[1].substring(0,j).length();

        }
        for(int i = 1; i < x_length+1; i++){
            for(int j = 1; j < y_length+1; j++){
                if (input[0].substring(i - 1, i).equals(input[1].substring(j - 1, j))) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1])+1;
                }
            }
        }
        System.out.println(dp[x_length][y_length]);
    }
}
