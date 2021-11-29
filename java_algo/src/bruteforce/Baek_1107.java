package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1107 {
    static boolean[] arr;
    static String an = "";
    static int min;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int first = 100;
        String N = br.readLine();
        int M = Integer.parseInt(br.readLine());
        min = Math.abs(first - Integer.parseInt(N));
        arr = new boolean[10];
        if(M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arr[Integer.parseInt(st.nextToken())] = true;
            }
        }

        //여러번 누를수 있고
        //그냥 반복해서

        //반복

        brute(0,6,Integer.parseInt(N));

        System.out.println(min);

    }

    static void brute(int cost,int length,int go){
        if (cost != 0) {
            int aa = Integer.parseInt(an);
            if(aa == 0){
                min = Math.min(min, Math.abs(go - aa) + 1);
            }else {
                min = Math.min(min, Math.abs(go - aa) + cost);
            }
        }
        if (cost == length) {
            return;
        }
        for (int i = 0 ; i < 10; i++){
            if (!arr[i]) {
                an += i;
                brute(cost+1,6,go);
                an = an.substring(0, an.length() - 1);
            }else {
                continue;
            }

        }
    }
}
