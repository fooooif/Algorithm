import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Baek_1918 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("(",0);
        hashMap.put("+",1);
        hashMap.put("-",1);
        hashMap.put("*",2);
        hashMap.put("/",2);
        hashMap.put(")",3);
        Stack<String> stack = new Stack<>();

        String answer = "";
        for(int i = 0 ; i < input.length(); i++){
            String s = input.substring(i, i + 1);
            if(input.charAt(i) -'A' >=0 && input.charAt(i) -'A'<= 35){
                answer += s;
                continue;
            }
            if (stack.isEmpty()) {

                stack.push(s);
            } else if (s.equals("(")) {
                stack.push(s);
            } else if (s.equals(")")) {
                while (!stack.peek().equals("(")) {
                    answer += stack.pop();
                }
                stack.pop();
            } else if (hashMap.get(stack.peek()) < hashMap.get(s)) {
                stack.push(s);
            } else if (hashMap.get(stack.peek()) >= hashMap.get(s)) {
                while (hashMap.get(stack.peek()) >= hashMap.get(s)) {
                    answer += stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                }
                stack.push(s);
            }


        }
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        System.out.println(answer);
    }
}

