//package bruteforce;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Baek_1074 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int N = Integer.parseInt(st.nextToken());
//        int r = Integer.parseInt(st.nextToken());
//        int c = Integer.parseInt(st.nextToken());
//
//        int total_x = zecop(N);
//        int total_y = zecop(N);
//
//        if(total_x/2 >= r&& total_y/2 >= c){
//            find(total_x*total_x/4*3,total_x*total_x-1, 4);
//        }
//        else if(total_x/2 < r&& total_y/2 >= c){
//            find(total_x*total_x/4,total_x*total_x/2-1, 2);
//        }else if(total_x/2 >= r&& total_y/2 < c){
//            find(total_x*total_x/2,total_x*total_x/4*3-1, 3);
//        }else {
//            find(0,total_x*total_x/4-1, 1);
//        }
//
//    }
//
//    static int find(int start ,int end,int cost){
//
//        if(total_x/2 >= r&& total_y/2 >= c){
//            find(start+(end-start)/4*3,start+(end-start)-1, );
//        }
//        else if(total_x/2 < r&& total_y/2 >= c){
//            find(start+(end-start)/4,start+(end-start)/2-1, 2);
//        }else if(total_x/2 >= r&& total_y/2 < c){
//            find(start+(end-start)/2,start+(end-start)/4*3-1, 3);
//        }else {
//            find(0,start+(end-start)/4-1, 1);
//        }
//    }
//
//
//
//    static int zecop(int n) {
//        int answer = 1;
//        for(int i = 0 ; i < n   ; i++){
//            answer *= 2;
//        }
//        return answer;
//    }
//}
