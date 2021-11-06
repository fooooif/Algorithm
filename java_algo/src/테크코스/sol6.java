package 테크코스;

public class sol6 {
    public String solution(double time, String[][] plans) {
        int index = 0;
        String mon_go = "13";
        String mon_end = "18";
        String fri_go = "9.5";
        String fri_end = "18";
        for (int i = 0 ; i < plans.length; i++) {
            String start = hourTrans(plans[i][1]);
            String end = hourTrans(plans[i][2]);
            double total = 0;
            total += pl(start,fri_go,fri_end);
            total += pl2(end,mon_go,mon_end);
            if (total <= time) {
                index = i;

            }
        }
        return plans[index][0];
    }

    //start = 출발
    //go = 출근
    //end 퇴근
    static double pl( String start, String go , String end){
        double total = 0;
        if (Double.parseDouble(start) >= Double.parseDouble(end)) {

        } else if (Double.parseDouble(start) <= Double.parseDouble(go)) {
            total += Double.parseDouble(end) - Double.parseDouble(go);
        }else {
            total += Double.parseDouble(end) - Double.parseDouble(start);
        }
        return total;
    }
    //start = 도착
    //go = 출근
    //end 퇴근
    static double pl2( String start, String go , String end){
        double total = 0;
        if (Double.parseDouble(start) <= Double.parseDouble(go)) {

        } else if (Double.parseDouble(start) >= Double.parseDouble(end)) {
            total += Double.parseDouble(end) - Double.parseDouble(go);
        }else {
            total += Double.parseDouble(start) - Double.parseDouble(go);
        }
        return total;
    }
    static String hourTrans(String hour){
        String re = "";
        if (hour.substring(hour.length() - 2, hour.length()).equals("PM")) {
            re = Integer.toString(Integer.parseInt(hour.substring(0, hour.length() - 2)) + 12);
        }
        else {
            if (Integer.parseInt(hour.substring(0, hour.length() - 2)) < 10) {
                re = "0"+hour.substring(0, hour.length() - 2);
            }else{
               re = hour.substring(0, hour.length() - 2);
            }

        }
        return re;
    }
}
