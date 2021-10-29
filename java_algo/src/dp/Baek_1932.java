package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_1932 {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[][] value = new int[n][n];
        int[][] dp = new int[n][n];
        for(int i = 0 ; i  < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++){
                value[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        dp[0][0] = value[0][0];

        for(int i = 1 ; i  < n ; i++) {
            for (int j = 0; j <= i; j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + value[i][j];
                }
                else if(j == i){
                    dp[i][j] = dp[i-1][j-1]+value[i][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + value[i][j], dp[i - 1][j] + value[i][j]);
                }

            }
        }

        int max = dp[n-1][0];

        for(int i =1 ; i < dp[n-1].length; i++){
            max = Math.max(max, dp[n - 1][i]);
        }
        System.out.println(max);

    }
    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

        n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i  < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> arrayList1 = new ArrayList<>();
            for (int j = 0; j <= i; j++){
                arrayList1.add(Integer.parseInt(st.nextToken()));
            }
            arrayList.add(arrayList1);
        }

        dp.add(new ArrayList<>(arrayList.get(0)));



        for(int i = 1 ; i  < n ; i++) {

            ArrayList<Integer> arrayList1 = new ArrayList<>();

            ArrayList<Integer> arrayList2 = arrayList.get(i);
            ArrayList<Integer> arrayList3 = dp.get(i - 1);
            for (int j = 0; j <= i; j++) {
                if(j == 0){
                    arrayList1.add(arrayList3.get(j));
                }
                else if( j== i){
                    arrayList1.add(arrayList3.get(j - 1));
                }else{
                    arrayList1.add(Math.max(arrayList2.get(j) + arrayList3.get(j - 1), arrayList2.get(j) + arrayList3.get(j)));
                }
            }
            dp.add(arrayList1);
        }

        int max = dp.get(n-1).get(0) ;
        for (int i = 1; i < dp.get(n - 1).size(); i++) {
            max = Math.max(max, dp.get(n - 1).get(i));
        }
        System.out.println(max);
    }
}
