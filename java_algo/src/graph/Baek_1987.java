package graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek_1987 {
    static int R ;
    static int C ;
    static String[][] arr ;
    static boolean[] visited ;
    static int max = 0;
    static HashMap<String, Integer> hashMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[26];

        arr = new String[R][C];
        for(int i = 0; i < R; i++ ) {
            String a = br.readLine();
            for(int j = 0 ; j < C; j++){

                arr[i][j] = a.substring(j,j+1);
            }
        }

        dfs_2(0,0,0);
        System.out.println(max+1);
    }

    static int[][] v = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static void dfs_2(int x , int y,int count ){

        visited[arr[x][y].charAt(0)-'A'] = true;

        for(int i = 0; i < 4; i++){
            int xx = x+v[i][0];
            int yy = y+v[i][1];
            if(xx > -1 && yy >-1 && xx < R && yy <C)
            {
                if(!visited[arr[xx][yy].charAt(0)-'A']){
                    dfs_2(xx ,yy,count+1);
                }
            }
        }
        visited[arr[x][y].charAt(0)-'A'] = false;

        max = Math.max(max,count);
    }
}
