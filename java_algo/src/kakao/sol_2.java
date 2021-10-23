package kakao;

public class sol_2 {
    public int solution(int n, int k) {

        String s = "";

        while (n >= k) {
            s = s + Integer.toString(n % k);
            n = n / k;
            if (n < k) {
                s = s + Integer.toString(n);
            }
        }
        String[] con_s = new String[s.length()];
        int j = 0;
        for (int i = s.length() - 1; i > -1; i--) {
            con_s[j] = s.substring(i, i + 1);
            j++;
        }
        int start=0;
        int end = 0;
        int count = 0;
        for (int i = 0; i < con_s.length; i++) {
            System.out.println(con_s[i]);
        }
        while (start < con_s.length) {
            if (start != 0) {
                start = end;
                end++;
            }
            while (end < con_s.length) {
                if (!con_s[end].equals("0")) {
                    end++;
                } else {
                    break;
                }

            }
            String temp = "";
            if (end > con_s.length - 1 ) {
                for (int i = start+1; i < con_s.length; i++) {
                    temp = temp + con_s[i];
                }
                int i1 = Integer.parseInt(temp);
                for (int i = 2; i < i1; i++) {
                    if (i1 % i == 0) {
                        count++;
                    }

                }
            }
            if (start != 0) {
                for (int i = start+1; i < end; i++) {
                    temp = temp + con_s[i];
                }
                int i1 = Integer.parseInt(temp);
                for (int i = 2; i < i1; i++) {
                    if (i1 % i == 0) {
                        count++;
                    }

                }
            }


        }
        return 0;
    }




}
