package wintercording;

public class Sol_1 {
    public String solution(String character, String[] monsters) {
        String answer = "";
        double max = 0;
        int g = 0;

        for (String m : monsters) {
            String[] player = character.split(" ");
            String[] monster = m.split(" ");
            String first = player[0];
            int  count= 0;
            while (true) {
                int attak_m = Integer.parseInt(player[1]) - Integer.parseInt(monster[4]);
                if (attak_m <= 0) {
                    count = 0;
                    break;
                }
                if (attak_m > 0) {
                    monster[2] = Integer.toString(Integer.parseInt(monster[2]) - attak_m);
                    count++;
                    if(Integer.parseInt(monster[2]) <= 0 ){
                        break;
                    }
                }

                int attack_p = Integer.parseInt(monster[3]) - Integer.parseInt(player[2]);
                if(attack_p > 0){
                    player[0] = Integer.toString(Integer.parseInt(player[0]) - attack_p);
                }
                if(Integer.parseInt(player[0]) <= 0){
                    count = 0;
                    break;
                }
                player[0] = first;
            }
            if(count != 0) {
                if (max < Integer.parseInt(monster[1]) / count) {
                    answer = monster[0];
                    max = Integer.parseInt(monster[1]) / count;
                    g = Integer.parseInt(monster[1]);
                } else if (max == Integer.parseInt(monster[1]) / count) {
                    if(g < Integer.parseInt(monster[1])){
                        answer = monster[0];
                        max = Integer.parseInt(monster[1]) / count;
                        g = Integer.parseInt(monster[1]);

                      }
                }
            }
        }


        return answer;
    }


}

class Sol_2{
    public int solution(int time, int gold, int[][] upgrade) {
        int answer = -1;
        int t = 0 ;
        int c = 0;
        int max = time/upgrade[0][1] *gold;

        for (int i = 1 ; i < upgrade.length ; i++){
            int i1 = upgrade[i][0];
            int i2 = upgrade[i][1];


            int made_count = (i1-c) / gold;
            if(i1 % gold != 0 ){
                made_count += 1;
            }
            //만드는데 필요한 시간들
            if(made_count > 0) {
                t += made_count * upgrade[i - 1][1];
                //남아 있는 돈.
                c += made_count * gold - i1;
            }else {
                t = 0;
                c = c-i1;
            }
            if(time < t){
                break;
            }
            if ((time - t) / i1 * gold + c > max) {
                max= (time - t) / i1 * gold + c;
            }


        }
        return max;
    }

}
class Sol_3 {

}
