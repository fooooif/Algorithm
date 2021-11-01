package dp.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Baek_2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(st.nextToken());

        BigInteger a1 = new BigInteger("1");
        BigInteger a2 = new BigInteger("1");

        for(int i = 0 ; i < m ; i++){
            a1 = a1.multiply(new BigInteger(String.valueOf(n - i)));
            a2 = a2.multiply(new BigInteger(String.valueOf(i + 1)));
        }
        BigInteger answer = a1.divide(a2);

        System.out.println(answer);




    }

}
