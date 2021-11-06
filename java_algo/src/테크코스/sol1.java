package 테크코스;

public class sol1 {
    public int[] solution(int[] arr) {
        int[] count = new int[4];
        int max_index = 1;
        int[] answer = new int[3];
        for (int i = 0 ; i < arr.length; i++){
            count[arr[i]] +=1;
        }

        for(int i = 1 ; i < count.length ;i++){
            if(count[max_index] < count[i]){
                max_index = i;
            }
        }
        for(int i =  0; i < answer.length ;i++){
            answer[i] = count[max_index] - count[i + 1];
        }
        return answer;
    }
}
