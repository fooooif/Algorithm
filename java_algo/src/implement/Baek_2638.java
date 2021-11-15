package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2638 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());


            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1){
                    queue.add(new Node(i, j));
                }
            }
        }
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int answer_count = 0;
        ArrayList<Node> arrayList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0 ;i < size; i++){
                Node poll = queue.poll();
                int count = 0 ;
                for (int j = 0; j < dir.length; j++) {
                    int x = poll.x + dir[j][0];
                    int y = poll.y + dir[j][1];
                    if (x > -1 && x < arr.length && y > -1 && y < arr[0].length) {
                        if (arr[x][y] == 0) {
                            count +=1;
                        }

                    }
                }
                if (count < 2) {
                    queue.add(poll);

                }else {
                    arrayList.add(poll);
                }
            }
            for (int i = 0 ; i < arrayList.size(); i++){
                arr[arrayList.get(i).x][arrayList.get(i).y] = 0;
            }
            arrayList.clear();
            answer_count +=1;
        }
        System.out.println(answer_count);



    }
    static class Node{
        int x;
        int y;

        Node(int x, int y) {
            this.x= x;
            this.y = y;

        }
    }
}
