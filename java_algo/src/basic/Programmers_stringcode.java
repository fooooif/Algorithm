package basic;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers_stringcode {

    static class Solution {
        public int solution(String s) {
            int max_length = s.length();
            int temp_length = s.length();
            for (int j = 2; j < max_length; j++) {
                int length = s.length();
                int i = 0;
                while (i < max_length) {
                    int count = 0;
                    if (i + j + j > max_length ) {
                        break;
                    }
                    while (s.substring(i, i + j).equals(s.substring(i + j, i + j + j))) {
                        System.out.println(i);
                        System.out.println(s.substring(i, i + j));
                        System.out.println(s.substring(i+j, i+j + j));
                        count = count + 1;

                        if (i + j + j > max_length - 1) {
                            break;
                        }
                        i = i + j;

                    }
                    System.out.println(length);
                    if (count > 0) {
                        length = length - ((count+1) * j) +j+1;
                    }

                    if (length < temp_length) {
                        temp_length = length;
                    }
                    System.out.println(length);

                    i = i+1;


                }
            }
            return temp_length;


        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.solution("aabbaccc") - 1);
//        System.out.println(solution.solution("ababcdcdababcdcd") -1 );
//        System.out.println(solution.solution("abcabcdede")-1);
//        System.out.println(solution.solution("abcabcabcabcdededededede")-1);
        System.out.println(solution.solution("xababcdcdababcdcd")-1);
    }

}

