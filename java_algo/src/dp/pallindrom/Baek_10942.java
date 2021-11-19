package dp.pallindrom;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_10942 {
    static int[] arr;
    static boolean[][] dp;
    static int M;
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
         M = Integer.parseInt(br.readLine());
        dp = new boolean[N][N];

//        for (int i = 0 ; i < N; i++){
//            for (int j = i; j < N; j++){
//                if(j== i){
//                    dp[i][j] = true;
//                }else if( j - i == 1){
//                    if (arr[i] == arr[j]) {
//                        dp[i][j] = true;
//                    }
//                }else{
//                    int left = i;
//                    int right = j;
//                    while (left <= right){
//                        if(arr[left] == arr[right]){
//                            left++;
//                            right--;
//                            if(left >= right){
//                                dp[i][j] = true;
//                            }
//                        }else {
//
//                            break;
//                        }
//                    }
//
//                }
//            }
//        }

        for (int i = 0 ; i < N-1; i++){
            dp[i][i] = true;

                if (arr[i] == arr[i + 1]) {
                    dp[i][i + 1] = true;
                }
        }
        dp[N-1][N-1] = true;
        for(int i = 2 ; i <= N-1 ; i++){
            for(int j = 0; j <= N-i-1; j++) {
                if(arr[j] == arr[j+i] && dp[j+1][i+j-1]){
                    dp[j][j+i] = true;
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            if(dp[S-1][E-1]){
                sb.append("1\n");
            }else {
                sb.append("0\n");
            }
        }
        System.out.print(sb);

    }



}
