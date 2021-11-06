package 테크코스;

public class sol2 {
    public String solution(String[] log) {
        String answer = "";
        String start_hour = "";
        String start_min = "";

        String end_hour = "";
        String end_min = "";
        int total=0;
        for (int i = 0; i < log.length; i += 2) {
            int term_total = 0;
            start_hour = log[i].substring(0,2);
            start_min = log[i].substring(3,5);
            end_hour = log[i+1].substring(0,2);
            end_min = log[i+1].substring(3,5);

            if (Integer.parseInt(end_min) - Integer.parseInt(start_min) >= 0) {
                term_total = Integer.parseInt(end_min) - Integer.parseInt(start_min)
                        + (Integer.parseInt(end_hour) - Integer.parseInt(start_hour)) * 60;
            }else {
                term_total = Integer.parseInt(end_min) - Integer.parseInt(start_min) + 60
                        + (Integer.parseInt(end_hour) - Integer.parseInt(start_hour) -1) * 60;
            }

            if (term_total >= 105) {
                total += 105;
            } else if (term_total < 5) {
                total += 0;
            }else {
                total += term_total;
            }
        }
        String answer_hour = "";
        String answer_min = "";
        if (total / 60 < 10) {
            answer += "0"+Integer.toString(total / 60);
        }
        else {
            answer += Integer.toString(total / 60);
        }
        answer += ":";
        if (total % 60 < 10) {
            answer += "0"+Integer.toString(total % 60);
        }
        else {
            answer += Integer.toString(total % 60);
        }


        return answer;
    }
}
