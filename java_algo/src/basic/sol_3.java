package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sol_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <=T ;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            int a = Integer.parseInt(st.nextToken());

            int b = Integer.parseInt(st.nextToken());

            System.out.println("#" + i + " " + findMax(n, a, b) + " " + findMin(n, a, b));
        }

    }
    static int findMax(int n ,int a,int b){
        int min = Math.min(a, b);

        return min;

    }
    static int findMin(int n ,int a,int b){
        if (a + b >= n) {
            return a + b - n;
        }else {
            return 0;
        }
    }
}
