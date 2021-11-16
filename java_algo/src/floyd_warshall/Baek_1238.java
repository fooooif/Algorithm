package floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_1238 {
    static int[][] arr;
    static int MAX = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];

        for (int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[x][y] = cost;

        }
        for (int i = 1 ; i < N+1; i++){
            for(int j = 1 ; j < N+1 ; j++){
                if (arr[i][j] == 0) {
                    arr[i][j] = MAX;
                }
            }
        }
        int[] arr_x = dijkstra(X, N);
        int[] arr_x_reverse = dijkstra_reverse(X, N);

        int max  = 0;
        for(int i = 1 ; i < N+1; i++){
                max = Math.max(arr_x[i] + arr_x_reverse[i], max);
        }

        System.out.println(max);
    }
    static int[] dijkstra(int x,int N) {
        int[] ar = new int[N + 1];
        for (int i = 1 ; i < N+1; i++){
            if (i != x) {

                ar[i] = MAX;
            }

        }
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(x, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int x_x = poll.x;
            if(poll.cost > ar[x_x]) continue;
            for (int i = 1; i < N+1; i++){
                if (arr[x_x][i] != MAX) {
                    if(ar[i] > poll.cost + arr[x_x][i]){
                        ar[i] = poll.cost + arr[x_x][i];
                        queue.add(new Node(i, ar[i]));
                    }
                }
            }
        }

        return ar;
    }
    static int[] dijkstra_reverse(int x,int N) {
        int[] ar = new int[N + 1];
        for (int i = 1 ; i < N+1; i++){
            if (i != x) {

                ar[i] = MAX;
            }

        }
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(x, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int x_x = poll.x;
            if(poll.cost > ar[x_x]) continue;
            for (int i = 1; i < N+1; i++){
                if (arr[i][x_x] != MAX) {
                    if(ar[i] > poll.cost + arr[i][x_x]){
                        ar[i] = poll.cost + arr[i][x_x];
                        queue.add(new Node(i, ar[i]));
                    }
                }
            }
        }

        return ar;
    }
    static class Node implements Comparable<Node> {
        int x;
        int cost;

        Node(int x, int cost) {
            this.x = x;
            this.cost = cost;

        }
        @Override
        public int compareTo(Node o) {
            return o.cost > cost ? 1: -1;
        }
    }

}
