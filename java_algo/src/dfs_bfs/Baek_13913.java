package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_13913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100001];
        Queue<Node> queue = new LinkedList<>();
        visited[N] =true;
        queue.add(new Node(N, 0,Integer.toString(N)));
        while (!queue.isEmpty()) {

            Node poll = queue.poll();

            if (poll.n == K) {
                StringBuilder sb = new StringBuilder();
                sb.append(poll.cost + "\n");
                sb.append(poll.name);
                System.out.println(sb.toString());
                break;
            }
            //60000 45000



                if (poll.n + 1 > -1 && poll.n + 1 < 100001) {
                    if (visited[poll.n + 1] == false) {
                        visited[poll.n + 1] = true;
                        queue.add(new Node(poll.n + 1, poll.cost + 1, poll.name + " " + (poll.n + 1)));
                    }
                }
                if (poll.n + -1 > -1 && poll.n - 1 < 100001) {
                    if (visited[poll.n - 1] == false) {
                        visited[poll.n - 1] = true;
                        queue.add(new Node(poll.n - 1, poll.cost + 1, poll.name + " " + (poll.n - 1)));
                    }
                }
                if (poll.n * 2 > -1 && poll.n * 2 < 100001) {
                    if (visited[poll.n * 2] == false) {
                        visited[poll.n * 2] = true;
                        queue.add(new Node(poll.n * 2, poll.cost + 1, poll.name + " " + (poll.n * 2)));
                    }
                }

        }
    }

    static class Node{
        int n;
        int cost;
        String name ;
        Node(int n, int cost,String name) {
            this.n = n;
            this.cost = cost;
            this.name = name;
        }
    }
}
