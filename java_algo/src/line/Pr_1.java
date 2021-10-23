package line;

public class Pr_1 {
    public int solution(int[] student, int k) {


        int length = student.length;
        int answer = 0;
        for (int i = 0; i < length; i++) {

            int end = i;
            int count = 0;
            while (end < length && count <= k) {
                if (student[end] == 1) {

                    count++;
                }
                if(count == k){
                    System.out.println(i);
                    System.out.println(end);
                    answer++;
                }
                end++;
            }


        }

        return answer;
    }

}
