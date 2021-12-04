package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sol_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i =1 ; i<= T; i++){
            boolean[] visited = new boolean[26];

            StringTokenizer st = new StringTokenizer(br.readLine());

            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int[][] arr = new int[R][C];
            for (int a =0 ; a < R; a++){
                String s = br.readLine();
                for (int b = 0; b < C; b++) {
                    arr[R][C] = s.charAt(b) - 'A';
                }
            }


        }
    }

    static void dfs(boolean[][] visited, int[][] arr,int x) {

    }
}
