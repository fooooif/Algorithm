package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_17144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());


        int[][] arr = new int[R][C];

        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int up=-1;
        int down=-1;
        for(int i = 0 ; i < R; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0 ; j < C; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == -1){
                    if(up == -1){
                        up = i;
                    }else {
                        down = i;
                    }
                }
            }

        }
        int answer = 0;
        for (int i = 0 ; i < T; i++){
            answer = spread(arr, R, C, dir);
            clean_up(up,R,C,arr);
            clean_down(down,R,C,arr);
        }
        System.out.println(answer +2);


    }

    static int spread(int[][] arr, int R, int C, int[][] dir) {
        int[][] sa = new int[R][C];
        for(int i = 0 ; i < R; i++){
            for(int j = 0 ; j < C; j++) {
                int count = 0 ;
                if (arr[i][j] != -1) {
                    for (int k = 0; k < dir.length; k++) {

                        int x = i + dir[k][0];
                        int y = j + dir[k][1];
                        if (x > -1 && x < R && y > -1 && y < C) {

                            if (arr[x][y] != -1){
                                count++;
                                sa[x][y] += arr[i][j] /5;
                            }
                        }
                    }
                }
                arr[i][j] = arr[i][j] - ((arr[i][j] / 5 )*count);
                
            }
        }
        int count = 0;
        for(int i = 0 ; i < R; i++){
            for(int j = 0 ; j < C; j++) {

                arr[i][j] = arr[i][j] + sa[i][j];
                count += arr[i][j];
            }
        }

        return count;
    }
    static void clean_up(int up,int R,int C,int[][] arr){

        int temp =arr[up][1];
        arr[up][1] = 0;
        int tem = 0;
        for (int i = 1; i <= C-2 ; i++) {
            tem = temp;
            temp = arr[up][i+1];
            arr[up][i+1] = tem;

        }

        for (int i = up; i > 0; i--) {
            tem = temp;
            temp = arr[i-1][C-1];
            arr[i-1][C-1] = tem;
        }
        for (int i = C-1; i > 0; i--) {
            tem = temp;
            temp = arr[0][i-1];
            arr[0][i-1] = tem;
        }
        for (int i = 0; i < up-1; i++) {
            tem = temp;
            temp = arr[0][i+1];
            arr[0][i+1] = tem;
        }
    }
    static void clean_down(int down, int R,int C,int[][] arr){
        int temp =arr[down][1];
        arr[down][1] = 0;
        int tem = 0;
        for (int i = 1; i < C-1; i++) {
            tem = temp;
            temp = arr[down][i+1];
            arr[down][i+1] = tem;
        }
        for (int i = down; i < R-1; i++) {
            tem = temp;
            temp = arr[i+1][C-1];
            arr[i+1][C-1] = tem;
        }
        for (int i = C-1; i > 0; i--) {
            tem = temp;
            temp = arr[R-1][i-1];
            arr[R-1][i-1] = tem;
        }
        for (int i = R-11; i > down+1; i--) {
            tem = temp;
            temp = arr[i-1][0];
            arr[i-1][0] = tem;
        }
    }
}
