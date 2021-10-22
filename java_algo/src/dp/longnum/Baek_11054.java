package dp.longnum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11054 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = 10;
        int[] arr = new int[N+2];
        int[] dp  = new int[N+1];
        int[] dp_reverse= new int[N+1];

//        arr[1] =1;
//        arr[2] = 5;
//        arr[3] = 2;
//        arr[4] =1;
//        arr[5] = 4;
//        arr[6] = 3;
//        arr[7] = 4;
//        arr[8] = 5;
//        arr[9] = 2;
//        arr[10] = 1;
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
        for(int i =N ; i > 0 ; i--){
           dp_reverse[i-1] = 1;
           for(int k = N+1  ; k >i; k--){
               if(arr[k] < arr[i] ){
                   dp_reverse[i-1] = Math.max(dp_reverse[i-1], dp_reverse[k-1] + 1);

           }
           }

        }
        int max = 0;
        for(int i = 0 ; i < N; i++){
            max = Math.max(dp[i+1]+dp_reverse[i],max);
        }
//        for(int i = 0 ; i < N +1; i++){
//            System.out.print(dp[i]);
//        }
//        System.out.println("---------");
//        System.out.println("---------");
//        for(int i = 0 ; i < N+1 ; i++){
//            System.out.print(dp_reverse[i]);
//        }
//        System.out.println("---------");
        System.out.println(max -1 );


    }
}
