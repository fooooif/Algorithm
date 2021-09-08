package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_1916 {
    static int N = 0;
    static int M = 0;
    static int[][] arr;
    static int[] visited;
    static int start = 0;
    static int end = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new int[N];
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                arr[i][j] = Integer.MAX_VALUE;
            }
        }
        M = Integer.parseInt(br.readLine());



        int x = 0;
        int y = 0;
        int cost = 0;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            arr[x-1][y-1] = cost;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken())-1 ;
        end = Integer.parseInt(st.nextToken())-1 ;
        dijkstra(start, end);
        System.out.println(visited[end]);
    }

    static class Node implements Comparable<Node>{
        Node(int loc,
             int cost) {
            this.loc = loc;
            this.cost = cost;
        }

        int loc;
        int cost;

        @Override
        public int compareTo(Node o) {
            return o.cost <= this.cost ? 1:-1;
        }
    }
    public static int dijkstra(int x,int y) {



        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(new Node(x, 0));
        for (int i = 0; i < N; i++) {
            if (i != start) {
                visited[i] = Integer.MAX_VALUE;
            }
            else{
                visited[i] = 0;
            }

        }

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();
            for (int i = 0; i < N; i++) {
                if (i != N && visited[i] > node.cost + arr[node.loc][i]) {
                    visited[i] = node.cost +arr[node.loc][i];
                    priorityQueue.add(new Node(i,node.cost + arr[node.loc][i]));
                }
            }
        }
        return visited[end];
    }
}

