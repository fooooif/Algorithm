package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2096 {
    static int N;
    static int[][] dp_min;
    static int[][] dp_max;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp_max = new int[N][3];
        dp_min= new int[N][3];
        arr = new int[N][3];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());

        }
        dp_max[0][0] = arr[0][0];
        dp_min[0][0] = arr[0][0];
        dp_max[0][1] = arr[0][1];
        dp_min[0][1] = arr[0][1];
        dp_max[0][2] = arr[0][2];
        dp_min[0][2] = arr[0][2];

        for(int i = 1 ; i < N ; i++){
            dp_max[i][0] = Math.max(dp_max[i - 1][0] + arr[i][0], dp_max[i - 1][1] + arr[i][0]);
            dp_max[i][1] = Math.max(dp_max[i - 1][0] + arr[i][1], Math.max(dp_max[i - 1][1] + arr[i][1], dp_max[i - 1][2] + arr[i][1]));
            dp_max[i][2] = Math.max(dp_max[i - 1][1] + arr[i][2], dp_max[i - 1][2] + arr[i][2]);
            dp_min[i][0] = Math.min(dp_min[i - 1][0] + arr[i][0], dp_min[i - 1][1] + arr[i][0]);
            dp_min[i][1] = Math.min(dp_min[i - 1][0] + arr[i][1], Math.min(dp_min[i - 1][1] + arr[i][1], dp_min[i - 1][2] + arr[i][1]));
            dp_min[i][2] = Math.min(dp_min[i - 1][1] + arr[i][2], dp_min[i - 1][2] + arr[i][2]);
        }

        int max = Math.max(dp_max[N - 1][0], Math.max(dp_max[N - 1][1], dp_max[N - 1][2]));
        int min = Math.min(dp_min[N - 1][0], Math.min(dp_min[N - 1][1], dp_min[N - 1][2]));
        System.out.println(max + " " + min);
    }
}
