package dp.dp_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_17070 {
    static int N;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];
        dp = new int[N+1][N+1];
        dp[1][1] =1;
        dp[1][2] =1;
        for (int i = 1; i < N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j < N+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        for(int i = 1 ; i< N+1; i++){
//            for(int j = 3 ;j < N+1; j++){
//                if(arr[i][j] == 1){
//                    dp[i][j] = 0;
//                }
//                else {
//                    if (dp[i - 1][j] != 0) {
//                        dp[i][j]=dp[i][j]+dp[i - 1][j] - dp[i - 1][j - 1];
//                    }
//                    if(dp[i][j-1] !=0){
//                        dp[i][j]=dp[i][j]+dp[i ][j-1] - dp[i - 1][j - 1];
//                    }
//                    if(dp[i-1][j-1] != 0){
//                        dp[i][j] = dp[i][j]+dp[i - 1][j - 1];
//                    }
//
//                }
//            }
//        }
//        System.out.println(dp[N][N]);

        dp[1][1] =1;
        dp[1][2] =1;
        move(new Index(1,2),0);

    }


    static void move(Index index,int dir){
        int x = index.x;
        int y = index.y;

        for(int i = 0 ; i < 3; i++){
            if(dir == 0){
                dp[x][y+1] = dp[x][y+1] + dp[x][y];
                move(new Index(x,y+1),0);
                dp[x][y+1] = dp[x][y+1] + dp[x][y];
                move(new Index(x+1,y+1),1);

            }else if(dir == 1){
                move(new Index(x,y+1),0);

                move(new Index(x+1,y),2);

                move(new Index(x+1,y+1),1);
            }else{
                move(new Index(x+1,y),2);

                move(new Index(x+1,y+1),1);
            }
        }
    }
    static class Index{
        int x;
        int y;
        Index(int x,int y ){
            this.x = x;
            this.y = y;
        }
    }
}
