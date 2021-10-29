package kakao;

import java.util.*;

public class sol_1 {
    static HashMap<String, Integer> hashMap = new HashMap<>();
    static HashMap<String, Integer> return_a = new HashMap<>();
    static HashMap<String, Set<String>> check = new HashMap<>();

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        for (String s : id_list) {
            hashMap.put(s, 0);
            return_a.put(s, 0);
            check.put(s, new HashSet<>());
        }
        for (String s : report) {
            String[] ins = s.split(" ");

            if (check.get(ins[1]).contains(ins[0])) {
                continue;
            }else{
                check.get(ins[1]).add(ins[0]);
                hashMap.put(ins[1], hashMap.get(ins[1]) + 1);

            }

        }
        int i = 0;
        for (String s : hashMap.keySet()) {
            if (hashMap.get(s) >= k) {

                Set<String> aaa= check.get(s);
                for (String s1 : aaa) {
                    return_a.put(s1, return_a.get(s1) + 1);
                }
            }
        }
        for (String s : id_list) {
            answer[i] = return_a.get(s);
            i++;
        }

        return answer;
    }



}
