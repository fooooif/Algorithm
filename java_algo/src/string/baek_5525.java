package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baek_5525 {
    static int N = 0;
    static int M = 0;
    static String S = "";
    static String P = "I";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        S = br.readLine();

        for (int i = 0; i < N; i++) {
            P += "OI";
        }

        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (i + P.length() > S.length()) {
                break;
            }
            if (S.substring(i, i + P.length()).equals(P)) {
                count++;
            }

        }
        System.out.println(count);

        // N+1 I N 0  2N+1
    }
}
