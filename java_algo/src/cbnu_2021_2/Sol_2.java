import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

//        int T = 1;
        for(int i = 1 ; i <=T ; i++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

//            int N = 5;

            int[] arr = new int[N+1];
            int[] dp = new int[N+1];
            for(int j = 0 ; j < N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
//            arr[0]=1;
//            arr[1] = 1;
//            arr[2] = 3;
//            arr[3] = 1;
//            arr[4] = 2;
            dp[0] = arr[0];
            int max = 0;
            int count = 1;
            for (int k = 0 ; k < N ; k++){

                if(arr[k] <= arr[k+1]){
                    dp[k+1] = dp[k] + arr[k+1];
                    count++;
                }else{
                   max =  Math.max(arr[k] * (count-1) - dp[k-1], max);
                    dp[k+1] =arr[k+1];
                    count = 0;
                }
            }
//            for(int a = 0 ; a < N+1; a++){
//                System.out.println(dp[a]);
//            }
            System.out.println("#" + i+" "+max);
        }

    }
}
