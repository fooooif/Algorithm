package sorting;

import java.util.ArrayList;

public class Programmers_가장큰수 {
    static ArrayList<String> arrayList = new ArrayList<>();
    public String solution(int[] numbers) {
        String answer = "";

        for (int number : numbers) {
            arrayList.add(Integer.toString(number));
        }
        arrayList = quick(arrayList);

        for (String s : arrayList) {
            answer += s;
        }
        String temp = "";
        for (int i = 0; i < numbers.length; i++) {
            temp +=0;
        }
        if (temp.equals(answer)) {
            return "0";
        }
        return answer;
    }

    public ArrayList<String> quick(ArrayList<String> arrayList) {

        String fibet = arrayList.get(0);
        System.out.println(fibet);
        ArrayList<String> left = new ArrayList<>();

        ArrayList<String> right = new ArrayList<>();
        for (int i = 1; i < arrayList.size(); i++) {

            if (Integer.parseInt(fibet + arrayList.get(i)) > Integer.parseInt(arrayList.get(i) + fibet)) {
                right.add(arrayList.get(i));
            } else if (Integer.parseInt(fibet + arrayList.get(i)) == Integer.parseInt(arrayList.get(i) + fibet)) {
                if (fibet.length() > arrayList.get(i).length()) {
                    left.add(arrayList.get(i));
                } else {
                    right.add(arrayList.get(i));
                }
            } else {
                left.add(arrayList.get(i));
            }
        }
        if (left.size() > 1) {
            System.out.println(0);
            left = quick(left);
        }
        left.add(fibet);
        if (right.size() > 1) {
            System.out.println(2);
            right = quick(right);
        }
        left.addAll(right);
        return left;
    }
}
