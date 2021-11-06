package 테크코스;

import java.util.HashMap;

public class sol3 {
    public int solution(String[] ings, String[] menu, String[] sell) {
        int answer = 0;
        HashMap<String, Integer> ings_map = new HashMap<>();
        HashMap<String, Integer> sell_map = new HashMap<>();

        for (int i = 0 ; i < ings.length ; i++){
            ings_map.put(ings[i].substring(0, 1)
                    ,Integer.parseInt(ings[i].substring(2)));
        }
        for (int i = 0 ; i < sell.length ; i++){
            String[] sp = sell[i].split(" ");
            sell_map.put(sp[0], Integer.parseInt(sp[1]));
        }

        for (int i = 0 ; i < menu.length ; i++){
            String[] me = menu[i].split(" ");
            int ing_price = 0;
            if (sell_map.get(me[0]) == null) {
                continue;
            }
            for (int j = 0 ; j < me[1].length() ; j++){
                ing_price += ings_map.get(me[1].substring(j, j + 1));

            }
            answer += sell_map.get(me[0]) * (Integer.parseInt(me[2])-ing_price);
        }
        return answer;
    }

}
