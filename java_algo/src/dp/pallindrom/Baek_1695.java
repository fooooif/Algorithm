package dp.pallindrom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1695 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());


        for (int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


    }
    static int find(int N,int arr){
        int left = 0 ;
        int right = N - 1;

        return 0;
    }
//    static int findCount(int N, int[] arr) {
//        //홀수 일때.
//        if (N % 2 == 1) {
//            int mid_index = (N - 1) / 2;
//
//            int[][] dp = new int[mid_index+1][mid_index+1];
//            for (int i = 1 ; i < mid_index+1; i++){
//                dp[0][i] = i;
//                dp[i][0] = i;
//            }
//            int[] left_arr = new int[mid_index+1];
//            int[] right_arr = new int[mid_index+1];
//
//            for(int i = 1 ; i+mid_index < N ; i++){
//                left_arr[i ] = arr[mid_index + i];
//                right_arr[i ] = arr[mid_index - i];
//            }
//            for (int i = 1 ; i < mid_index +1; i++){
//                for(int j = 1 ; j < mid_index +1; j++){
//                    if (left_arr[i] == right_arr[j]) {
//                        dp[i][j] = dp[i - 1][j - 1] ;
//                    }
//                    else {
//                        dp[i][j] = Math.max(dp[i][j-1]+1,dp[i-1][j]+1);
//                    }
//                }
//            }
//
//            return dp[mid_index][mid_index];
//        } //짝수일때.
//        else {
//            int left = (N-1)/2;
//            int right = (N-1)/2+1;
//            // 왼쪽 오른쪽 개수 right
//            int[][] dp = new int[right+1][right+1];
//            for (int i = 1 ; i < right+1; i++){
//                dp[0][i] = i;
//                dp[i][0] = i;
//            }
//            int[] left_arr = new int[right];
//            int[] right_arr = new int[right];
//
//            for(int i = 0 ; i+right < N ; i++){
//                left_arr[i] = arr[left - i];
//                right_arr[i] = arr[right + i];
//            }
//            for (int i = 1 ; i < right +1; i++){
//                for(int j = 1 ; j < right +1; j++){
//                    if (left_arr[i-1] == right_arr[j-1]) {
//                        dp[i][j] = dp[i - 1][j - 1] ;
//                    }
//                    else {
//                        dp[i][j] = Math.max(dp[i][j-1]+1,dp[i-1][j]+1);
//                    }
//                }
//            }
//            return dp[right][right];
//        }
//    }
}
