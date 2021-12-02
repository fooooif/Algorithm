package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Baek_2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        for (int i = 0 ; i < N; i++){
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0 ; i < N; i++){
            for (int j = 0; j < N; j++) {
                int count = 1 ;
                if (arr[i][j] == 1 && visited[i][j] == false) {
                    queue.add(new Node(i, j));
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        Node poll = queue.poll();

                        for (int k = 0 ; k < dir.length ; k++){
                            int x = poll.x + dir[k][0];
                            int y = poll.y + dir[k][1];

                            if (x > -1 && x < N && y > -1 && y < N) {
                                if (visited[x][y] == false && arr[x][y] == 1) {
                                    visited[x][y] = true;
                                    count++;
                                    queue.add(new Node(x, y));
                                }
                            }
                        }
                    }
                    arrayList.add(count);
                    count  = 1;
                    queue.clear();
                }


            }

        }
        List<Integer> list = arrayList.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : -1;
            }
        }).collect(Collectors.toList());

        System.out.println(list.size());

        for (int a : list) {
            System.out.println(a);
        }

    }
    private static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
