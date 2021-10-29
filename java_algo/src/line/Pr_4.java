package line;

public class Pr_4 {
    public int[] solution(int n) {
        int[] answer = new int[n];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = i+1;
        }
        int[] temp = new int[n];
        int temp_n = n;
        while (n != 1) {
            for (int i = 0; i < answer.length; i +=temp_n) {
                int count= 0;
                count++;
                for (int j = i; j < i+temp_n; j += temp_n/n) {

                    for(int k = 0; k < temp_n/n; k++) {
                        temp[j+n*k] = answer[j+k];
                    }
                }

            }
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    temp_n = n;
                    n = n / i;
                }

            }
            answer = temp;
        }
        return answer;
    }



}

