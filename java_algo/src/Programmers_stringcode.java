import java.util.LinkedList;
import java.util.Queue;

public class Programmers_stringcode {

    class Solution{
        public int solution(String s) {
            int length = s.length();
            int max_length = length;
            String temp = "";
            for (int j = 2; j < length; j++) {
                for (int i = 0; i < length; i++) {
                    //-1
                    if (i + j + 1 > length) {
                        break;
                    }
                    temp = s.substring(i, i + j);



                }
            }

            Queue<String> queue = new LinkedList<>();


        }
    }
    public static void main(String[] args) {

    }

}
