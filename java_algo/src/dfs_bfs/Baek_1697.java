package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        for (int i = 0 ; i < visited.length; i++){
            visited[i] = false;
        }
        queue.add(new Node(N, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (poll.n == K) {
                System.out.println(poll.cost);
                break;
            }
            if (poll.n + 1 > -1 && poll.n + 1 < 100001) {
                if (visited[poll.n + 1] == false) {
                    visited[poll.n+1] = true;
                    queue.add(new Node(poll.n + 1, poll.cost + 1));
                }
            }
            if (poll.n -1 > -1 && poll.n -1 < 100001) {
                if (visited[poll.n -1] == false) {
                    visited[poll.n-1] = true;
                    queue.add(new Node(poll.n -1, poll.cost + 1));
                }

            }
            if (poll.n *2 > -1 && poll.n *2 < 100001) {
                if (visited[poll.n *2] == false) {
                    visited[poll.n*2] = true;
                    queue.add(new Node(poll.n *2, poll.cost + 1));
                }

            }

        }
    }
    static class Node{
        int n;
        int cost;

        Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }
    }
}
