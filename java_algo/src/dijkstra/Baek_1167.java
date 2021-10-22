package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_1167 {
    static int V ;
    static int max;
    static int index = 1;
    static Ar[] ar ;
    static boolean[] visited;
    static boolean[] visited_d ;
    static int index_2 ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        ar = new Ar[V+1];
        visited_d = new boolean[V + 1];
        visited = new boolean[V+1];
        for(int i = 0 ; i < V; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Node> nodes = new ArrayList<>();
            int x = Integer.parseInt(st.nextToken());

            while (true) {
                int y = Integer.parseInt(st.nextToken());
                if (y == -1) {
                    break;
                }
                int value = Integer.parseInt(st.nextToken());
                nodes.add(new Node(y, value));
            }
            ar[x] = new Ar(nodes);

        }

        dfs(1,0);


        dfs(index, 0);

        System.out.println(max);
    }
    static void dfs(int start,int cost){
        for(int i = 0 ; i < ar[start].nodes.size(); i++){
            if( visited[ar[start].nodes.get(i).loc] == false){
                visited[start] = true;
                dfs(ar[start].nodes.get(i).loc,cost+ar[start].nodes.get(i).value);
                visited[start] = false;
            }
            if(max < cost){


                max = cost;
                index = start;
            }
        }
    }



    static class Ar{
        ArrayList<Node> nodes;

        Ar(ArrayList<Node> nodes) {
            this.nodes = nodes;
        }
    }
    static class Node{
        int loc;
        int value;

        Node(int loc, int value) {
            this.loc = loc;
            this.value = value;

        }
    }

}
