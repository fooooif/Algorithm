package kakao;

import javax.swing.*;
import java.util.HashMap;

public class sol_4 {
    static int N;
static int MAX = 0;
static int MAX_apach ;
static int[] MAX_INFO;

    public int[] solution(int n, int[] info) {

        N = n;
        int index = 0;

        MAX_INFO = new int[info.length];
        int[] result = new int[info.length];
        for (int i = N; i > -1; i--) {
            int count = 10;
            result[count] = i;
            dfs(result,count,N-i,info);

        }
        if (MAX == MAX_apach) {
            int[] returnva = new int[1];
            returnva[0] =-1;
            return returnva;
        }
        return MAX_INFO;
    }

    //now count 몇개 안쏜지
    static void dfs(int[] result, int count,int now_count,int[] info) {
        count--;
        if (count <0) {
            return;
        }

        for (int j = now_count; j > -1; j--) {
            result[count] = j;
            dfs(result,count,now_count-j,info);
        }
        result[0] = now_count;
        int num = 0;
        int num1 =0 ;
        int num_indi = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();

        if (count == 0) {

            for (int k = 0; k < 11; k++) {
                if (result[k] - info[k] > 0) {
                    num1+= 10-k;
                }
                else if(info[k] - result[k] >= 0 && info[k] > 0){
                    num_indi += 10-k;
                }

            }
            num = num1-num_indi;

            if (MAX < num) {
                MAX = num;
                int index = 0;
                for (int i1 : result) {
                    MAX_INFO[index] = i1;
                    index++;
                }
            }
            else if (MAX == num && num != 0) {

                for (int k = 10; k >-1; k--) {
                    if (MAX_INFO[k] < result[k] ) {
                        int index = 0;
                        for (int i1 : result) {
                            MAX_INFO[index] = i1;
                            index++;
                        }
                        break;
                    }else{
                        break;
                    }

                }
            }
        }


    }
}
