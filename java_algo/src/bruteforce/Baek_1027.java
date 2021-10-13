package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1027 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }
        N = 3;
        int max_count = 0;
        int index = 0;

        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if(arr[i] < arr[j]){
                    break;
                }
                else{
                    count++;
                }
            }
            for (int j = i+1; j < N; j++) {
                if(arr[i] < arr[j]){
                    break;
                }
                else{
                    count++;
                }
            }
            if(max_count < count){
                index = i;
                max_count = count;
            }
        }
        System.out.println(max_count);
    }
}
