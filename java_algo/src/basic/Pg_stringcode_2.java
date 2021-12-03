import java.util.LinkedList;
import java.util.Queue;

public class Pg_stringcode_2 {
    static class Solution_2 {
        public int solution(String s) {
            int max_length = s.length();

            for (int i = 1; i < s.length(); i++) {
                int length = s.length();


                Queue<String> linkedList = new LinkedList<>();
                for (int j = 0; j < s.length(); j = j + i) {
                    if (j + i > s.length()) {
                        break;
                    }
                    linkedList.add(s.substring(j, j + i));

                }
                int count = 0;
                String poll = linkedList.poll();
                while(!linkedList.isEmpty()) {
                    System.out.println(i);
                    if (poll.equals(linkedList.peek()) && linkedList.size() == 1) {
                        linkedList.poll();
                        count = count +1;
                        if (count > 8) {
                            length = length - ((count + 1) * i) + i + 2;
                        } else if (count >0)
                        {
                            length = length - ((count + 1) * i) + i + 1;
                        }
                    } else if(poll.equals(linkedList.peek())){
                        poll = linkedList.poll();
                        count = count+1;

                    }else {
                        if (count > 8) {
                            length = length - ((count + 1) * i) + i + 2;
                        } else if (count > 0)
                        {
                            length = length - ((count + 1) * i) + i + 1;
                        }
                        poll = linkedList.poll();
                        count = 0;
                    }
                }
                if (length < max_length) {
                    max_length = length;
                }
            }
            return max_length;

        }


    }

    public static void main(String[] args) {
        Solution_2 solution_2 = new Solution_2();
//        "aabbaccc"	7
//        "ababcdcdababcdcd"	9
//        "abcabcdede"	8
//        "abcabcabcabcdededededede"	14
//        "xababcdcdababcdcd" 17
//        System.out.println(solution_2.solution("aabbaccc"));
//        System.out.println(solution_2.solution("ababcdcdababcdcd"));
        System.out.println(solution_2.solution("bbaabaaaab"));
//        System.out.println(solution_2.solution("abcabcabcabcdededededede"));
//        System.out.println(solution_2.solution("xababcdcdababcdcd"));
    }
}
