package kakao;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

public class Sol_3 {
    static HashMap<String, String> cartime = new HashMap<>();
    static HashMap<String, Boolean> carinout = new HashMap<>();
    static HashMap<String, Integer> carfee = new HashMap<>();

    public int[] solution(int[] fees, String[] records) {

        for (String record : records) {
            String[] s = record.split(" ");
            carinout.put(s[1], false);
            cartime.put(s[1], "00:00");
            carfee.put(s[1],0);
        }
        //true in
        //false out
        for (String record : records) {
            String[] s = record.split(" ");
            if (carinout.get(s[1]) == false) {
                carinout.put(s[1], true);
                cartime.put(s[1],s[0]);
            }else {
                carinout.put(s[1], false);
                int inputhours = Integer.parseInt(cartime.get(s[1]).substring(0, 2));
                int inputtimes = Integer.parseInt(cartime.get(s[1]).substring(3, 5));
                int outputhours = Integer.parseInt(s[0].substring(0, 2));
                int outputtimes = Integer.parseInt(s[0].substring(3, 5));

                if (outputtimes == 0) {
                    carfee.put(s[1], carfee.get(s[1]) + (outputhours - inputhours-1) * 60 + (60 - inputtimes));
                } else if (outputtimes - inputtimes >= 0) {
                    carfee.put(s[1], carfee.get(s[1]) + (outputhours - inputhours) * 60 + (outputtimes - inputtimes));
                } else {
                    carfee.put(s[1], carfee.get(s[1]) + (outputhours - inputhours - 1) * 60 + (outputtimes+60 - inputtimes));
                }


            }
        }
        for (String s : carinout.keySet()) {
            if(carinout.get(s) == true){
                int inputhours = Integer.parseInt(cartime.get(s).substring(0, 2));
                int inputtimes = Integer.parseInt(cartime.get(s).substring(3, 5));
                int outputhours = 23;
                int outputtimes = 59;

                carfee.put(s,carfee.get(s)+(outputhours-inputhours)*60+(outputtimes-inputtimes));
            }
        }

        int basic_time =fees[0];
        int basic_fee =fees[1];
        int unit_time = fees[2];
        int unit_fee =fees[3];


        for (String s : carfee.keySet()) {
            int money = basic_fee;
            if (carfee.get(s) - basic_time > 0) {


                if( (carfee.get(s) - basic_time)%unit_time ==0){
                    money += (carfee.get(s) - basic_time)/unit_time * unit_fee;
                }else{
                    money+=((carfee.get(s) - basic_time)/unit_time+1)*unit_fee;
                }

            }
            carfee.put(s, money);
        }

        for (String s : carfee.keySet()) {

        }
        LinkedList<String> strings = new LinkedList<>(carfee.keySet());
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1) > Integer.parseInt(o2) ? 1: -1;
            }
        });

        int[] answer = new int[carinout.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = carfee.get(strings.get(i));
        }
        return answer;
    }
}
