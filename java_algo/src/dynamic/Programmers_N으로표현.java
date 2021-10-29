package dynamic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_N으로표현 {

    static Queue<Integer> aa = new LinkedList<>();
    static int answer ;
    public int solution(int N, int number) {

        if (N == number) {
            return 1;
        }
        aa.add(5);
        dfs(number, N, 1);
        return answer;
    }


    public static void dfs(int number, int N,int length) {
        if (length > 8) {
            answer= -1;
            return;
        }
        String dup = "";
        for (int i = 0; i < length+1; i++) {
            dup += Integer.toString(N);
        }
        int length_que = aa.size();
        for (int i = 0; i < length_que; i++) {

            int temp = aa.poll();
            if (temp == number) {
                answer = length;
                return;
            }
            aa.add(temp * N);
            if(temp !=0) {
                aa.add(temp / N);
            }
            aa.add(temp - N);
            aa.add(temp + N);
        }
        aa.add(Integer.parseInt(dup));
        dfs(number, N , length+1);

    }

}

class Solution {
    ArrayList<Integer> cnt_list = new ArrayList<>();
    int answer = -1;
    public int solution(int N, int number) {
        expressionHelper(N, 0, 0, number);

        return answer;
    }
    public void expressionHelper(int N, int count, int result, int number) {
        int temp = N;
        if(count>8) return;
        if(result==number) {
            if(answer==-1 || answer>count){
                answer = count;
            }
            return;
        }
        for(int i=0; i<8-count; i++) {
            expressionHelper(N, count+i+1, result + temp, number);
            expressionHelper(N, count+i+1, result - temp, number);
            expressionHelper(N, count+i+1, result * temp, number);
            expressionHelper(N, count+i+1, result / temp, number);

            temp = extendNumber(temp, N);
        }
    }

    public int extendNumber(int result, int N) {
        return result*10 + N;
    }
}
