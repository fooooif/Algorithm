package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.LinkedList;

public class Baek_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < T; i++){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String x = br.readLine();
            x = x.substring(1, x.length()-1);
            LinkedList<String> linkedList = new LinkedList<>();
            if (x.equals("")) {

            }else {
                String[] split = x.split(",");

                for (int j = 0; j < split.length; j++) {

                    linkedList.add(split[j]);

                }
            }
            int reverse = 0;

            for(int j = 0 ; j < p.length(); j++){
                String s = p.substring(j, j + 1);
                if (s.equals("R")) {
                    reverse += 1;
                }else {
                    if (linkedList.isEmpty()) {
                        System.out.println("error");
                        break;
                    }
                    if (reverse % 2 == 0) {
                        linkedList.removeFirst();
                    }else {
                        linkedList.removeLast();
                    }
                }

                if (j == p.length() - 1) {
                    StringBuilder answer = new StringBuilder();
                    answer.append("[");
                    for (int k = 0 ; k < linkedList.size(); j++){
                        if (reverse % 2 == 0) {
                            answer.append(linkedList.removeFirst());
                            answer.append(",");
                        }else {
                            answer.append(linkedList.removeLast());
                            answer.append(",");
                        }
                    }
                    if (answer.length() > 1) {
                        answer.delete(answer.length() - 1, answer.length());


                    }
                    answer.append("]");
                    System.out.println(answer.toString());
                }
            }

        }
    }
}
