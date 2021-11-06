package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_5052 {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < t; i++){

            int n = Integer.parseInt(br.readLine());

            String[] arr = new String[n];
            for(int j = 0; j< n; j++){
                arr[j] = br.readLine();
            }
            int[] arrr =  new int[3];
            Arrays.sort(arrr);
            boolean answer = false;
            for(int a = 0 ; a<n; a++){
                for(int b = a+1 ; b<n; b++){
                    if (arr[a].equals(arr[b].substring(0, arr[a].length()))) {
                        answer = true;
                        break;
                    }
                }
                if(answer == true){
                    break;
                }
            }
            if(answer == true){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }



        }
    }

}
