package 테크코스;

import java.util.ArrayList;
import java.util.Arrays;

public class sol4 {
    public int[] solution(String s) {
        int[] answer = {};

        int index = 0;
        int count = 0;
        String a = s.substring(index, index + 1);
        ArrayList<Cost> arrayList = new ArrayList<>();
        for(int i = 0 ; i < s.length();i++){

            String b = s.substring(i, i + 1);
            if(a.equals(b)){
                count += 1;
                if(i == s.length()-1){
                    arrayList.add(new Cost(index, count));
                }

            }else {
                arrayList.add(new Cost(index, count));
                index = i;
                a = s.substring(index,index+1);
                count = 1;
            }
        }

        if (s.substring(arrayList.get(0).index,arrayList.get(0).index+1).equals(s.substring(arrayList.get(arrayList.size() - 1).index,arrayList.get(arrayList.size() - 1).index+1)) && arrayList.size() > 1){
            answer = new int[arrayList.size() - 1];
            answer[0] = arrayList.get(0).count + arrayList.get(arrayList.size() - 1).count;
            for(int i = 1; i< arrayList.size()-1;i++){
                answer[i] = arrayList.get(i).count;
            }
        }
        else {
            answer = new int[arrayList.size()];
            for(int i = 0; i< arrayList.size();i++){
                answer[i] = arrayList.get(i).count;
            }
        }
        Arrays.sort(answer);

        return answer;
    }
    static class Cost{
        int index;
        int count;

        Cost(int index, int count) {

            this.index = index;
            this.count = count;
        }
    }
}
