package dp.lcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Baek_9252 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String one = br.readLine();
        String two = br.readLine();


        int[][] arr = new int[one.length()+1][two.length()+1];
        int[][] dp = new int[one.length()+1][two.length()+1];


        for(int i = 1 ; i < one.length()+1 ; i++){
            for(int j = 1 ; j < two.length()+1;j++){
                if (one.substring(i-1, i).equals(two.substring(j-1, j ))) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int x = one.length();
        int y = two.length();
        Stack<String> stack = new Stack<>();
        while(dp[x][y] != 0){
            if (dp[x - 1][y] < dp[x][y] && dp[x][y - 1] < dp[x][y]) {
                stack.add(one.substring(x - 1, x));
                x = x - 1;
                y = y - 1;
            }
            else if(dp[x-1][y] == dp[x][y]){
                x = x-1;

            }
            else if(dp[x][y-1] == dp[x][y]){
                y = y-1;
            }

        }
        String answer = "";
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        if(answer.length() != 0) {

        System.out.println(answer.length());
        System.out.println(answer);
        }
        else{
            System.out.println(answer.length());
        }

//        if(max == 0 ){
//            System.out.println(max);
//        }
//        else if(max == 1 ){
//            System.out.println(max);
//            System.out.println(max_string);
//        } else {
//            int a = 1;
//            String max_s = "";
//            for(int i = 1 ; i < one.length()+1 ; i++){
//                for(int j =1 ; j < two.length() +1; j++){
//                    if(dp[i][j] == a){
//                        max_s += one.substring(i-1, i );
//                        a++;
//                    }
//                }
//            }
//            if(max_s.length() != max){
//                max_s = "";
//                a=1;
//                for(int i = 1 ; i < two.length()+1 ; i++){
//                    for(int j =1 ; j < one.length() +1; j++){
//                        if(dp[j][i] == a){
//                            max_s += two.substring(i-1, i);
//                            a++;
//                        }
//                    }
//                }
//            }
//            System.out.println(max);
//            System.out.println(max_s);
//        }
    }
}
