package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Baek_1339 {
    static int N;
    static String[] arr ;
    static int[] visited = new int[26];
    static boolean[] visited_ten = new boolean[10];
    static int max = 0 ;
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        for(int i = 0 ; i < N ;i++){
            arr[i] = br.readLine();
        }
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < arr[i].length() ;j++){
                visited[arr[i].charAt(j) - 'A'] = -1;

            }
        }
        for (int i = 0 ; i < visited.length; i++){
            if(visited[i] == -1){
                arrayList.add(i);
            }
        }
//        dfs(0);


        System.out.println(max);
    }
    static void dfs(int cost){


        for(int i = 9 ; i > -1 ;i--){

            if(visited_ten[i] != true) {
                visited_ten[i] = true;
                visited[arrayList.get(cost)] = i;
                if (arrayList.size()-1  == cost) {
                    int count = 0 ;
                    for(int k = 0 ; k < N ; k++){
                        String str = "";

                        for(int j = 0 ; j < arr[k].length();j++){
                            str += Integer.toString(visited[arr[k].charAt(j) - 'A']);
                        }
                        count += Integer.parseInt(str);
                    }
                    Math.max(count,max);
                    return;
                }
                dfs(cost + 1);
                visited_ten[i] = false;
            }
        }


    }
}
