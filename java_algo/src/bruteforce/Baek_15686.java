package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baek_15686 {

    static int N = 0;
    static int M = 0;
    static int[][] arr;
    static LinkedList<Location> homelist = new LinkedList<>();
    static LinkedList<Location> chlist = new LinkedList<>();
    static int[][] arr2 ;
    static int MIN = Integer.MAX_VALUE;
    static class Location{
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    homelist.add(new Location(i, j));
                } else if (arr[i][j] == 2) {
                    chlist.add(new Location(i, j));
                }
            }
        }
        arr2 = new int[homelist.size()][chlist.size()];
        int a = 0;
        int b = 0;
        for (Location location : homelist) {

            for (Location location1 : chlist) {
                arr2[a][b] = Math.abs(location.x - location1.x) + Math.abs(location.y - location1.y);
                b++;
            }
            b=0;
            a++;
        }
        //조합 부분 chlist중에 M개를 뽑아야함.
        //1.두개 방법 백트래킹 2. dfs

        boolean[] visitied = new boolean[chlist.size()];
        for (int i = 0; i < chlist.size(); i++) {
            int count = 1;
            visitied[i] = true;
            combination(M, visitied, i, count);
            visitied[i] = false;
        }
        System.out.println(MIN);
    }

    static void combination(int size, boolean[] visieted, int start, int count) {

        if (count == size) {
            int temp = 0;
            for (int i = 0; i < homelist.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < chlist.size(); j++) {
                    if (visieted[j] == false) {
                        continue;
                    }
                    min = Math.min(min, arr2[i][j]);

                }
                temp += min;
            }
            MIN = Math.min(MIN, temp);
            return;
        }

        for (int i = start + 1; i < chlist.size(); i++) {
            visieted[i] = true;
            combination(size, visieted, i, count + 1);
            visieted[i] = false;
        }
    }



}
