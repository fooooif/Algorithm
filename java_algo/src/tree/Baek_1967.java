package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 트리의 지름.
 */
public class Baek_1967 {


    static int n;
    static boolean[] visited ;
    static  InAr[] inar;
    static int max = 0;
    static int max_index = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. tree니까 뭘로 연결할까? ArrayList?
        n = Integer.parseInt(br.readLine());
       inar = new InAr[n+1];
        visited = new boolean[n+1];

        for(int i = 0 ; i < n+1; i++){
            inar[i] = new InAr(new ArrayList<Node>());

        }
        for(int i = 0 ; i < n+1; i++){
            ArrayList<Node> arrayList = inar[i].arrayList;
            for(int j = 0 ; j < arrayList.size(); j++){
                System.out.println(arrayList.get(j).value);
                System.out.println(arrayList.get(j).index);
            }

        }
        for(int i = 0 ; i< n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());


            int par = Integer.parseInt(st.nextToken());
            int chi = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            inar[par].arrayList.add(new Node(chi, cost));
            inar[chi].arrayList.add(new Node(par, cost));
        }
        int count = 0;
        dfs(1,count);
        max = 0;
        dfs(max_index,count);
        System.out.println(max);
    }

    static void dfs(int start, int count) {
        ArrayList<Node> arrayList = inar[start].arrayList;
        for (int i = 0; i < arrayList.size(); i++) {
            if(visited[arrayList.get(i).index] == false){
                visited[start] = true;
                dfs(arrayList.get(i).index, count + arrayList.get(i).value);
                visited[start] = false;
            }
        }
        if(max < count){
            max_index = start;
            max = count;
        }
    }
    static class InAr{
        ArrayList<Node> arrayList;

        InAr(ArrayList<Node> arrayList) {
            this.arrayList = arrayList;
        }
    }
    static class Node{
        int index;
        int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
