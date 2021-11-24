package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_13549 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100001];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(N, 0));
        int cost=0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            visited[poll.n] = true;
            if (poll.n == K ) {
                cost = poll.cost;
                break;
            }

            if (poll.n *2 > -1 && poll.n *2 < 100001) {
                if (visited[poll.n *2] == false) {
                    queue.add(new Node(poll.n *2, poll.cost));
                }

            }

            if (poll.n + 1 > -1 && poll.n + 1 < 100001) {
                if (visited[poll.n + 1] == false) {
                    queue.add(new Node(poll.n + 1, poll.cost + 1));

                }

            }if (poll.n -1 > -1 && poll.n -1 < 100001) {
                if (visited[poll.n - 1] == false) {
                    queue.add(new Node(poll.n -1, poll.cost + 1));
                }

            }



        }
        System.out.println(cost);
    }

    static class Node implements Comparable<Node> {

        int n;
        int cost;

        Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return o.cost > cost ? -1 : 1;
        }
    }
}
