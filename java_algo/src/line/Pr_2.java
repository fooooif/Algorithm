package line;

import java.util.HashMap;

public class Pr_2 {

    public String solution(String[] research, int n, int k) {
        String[] arr = new String[research[0].length()];
        for (int i = 0; i < research[0].length(); i++) {
            arr[i] = research[0].substring(i, i + 1);
        }

        int[] arr2 = new int[research[0].length()];

        String max_string = "";

        int max_index = -1;
        for (int i = 0; i < arr.length; i++) {

            for (int kk = 0; kk < research.length -n; kk++) {
                int count = 0;
                boolean visited = true;
                for (int j = kk; j < kk+n; j++) {
                    int in = 0;
                    for (int y = 0; y < research[j].length(); y++) {
                        if (arr[i].equals(research[j].substring(y, y + 1))) {
                            count++;
                            in++;
                        }
                    }
                    if (in < k) {
                        visited = false;
                        break;
                    }
                }
                if (visited = false) {
                    visited=true;
                    continue;
                }
                if (count >= 2 * k * n) {
                    arr2[i] ++;

                    if (max_string.equals("")) {
                        max_string = arr[i];
                        max_index = i;

                    } else if (arr2[i] > arr2[max_index]) {
                        max_string = arr[i];
                        max_index = i;
                    }
                    } else if (max_string.charAt(0) > arr[i].charAt(0)) {
                        max_string = arr[i];
                    }

                }
            }

        if (max_string == "") {
            return "None";
        }
        return max_string;
    }

}
