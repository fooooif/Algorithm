package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baek_2003 {

    static int N = 0;
    static int S = 0;
    static int end = 0;
    static int sum = 0;
    static int count = 0;
    static int min;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        min = N + 1;
        arr =new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            while (sum < S && end < N) {
                sum += arr[end];
                end++;
            }
            if (min > end - i && sum >= S) {
                min = end - i;
                count++;
            }
//            if(sum <S){
//
//            } else if (min > end - i) {
//                min = end - i;
//                count++;
//            }



            sum -= arr[i];


        }
        if (count == 0) {
            min = 0;
        }

        System.out.println(min);
    }

}
