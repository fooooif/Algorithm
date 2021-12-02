import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        //array는 검색;
        //Linked 삽입 삭제
        int num_one = 0;
        int num_not = 0;
        int num_zero = 0;
        int num_total = N*M;
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0 ; i< N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    num_one += 1;
                    queue.add(new Node(i, j,0));
                } else if (arr[i][j] == -1) {
                    num_not += 1;
                }
            }
        }
        num_zero = num_total - num_one - num_not;
        if(num_one + num_not == num_total){
            System.out.println(0);
            return;
        }
        int count = 0;
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            count = poll.cost;
            for (int i = 0 ; i < dir.length ; i++){
                int x = poll.x + dir[i][0];
                int y = poll.y + dir[i][1];

                if (x > -1 && x < N && y > -1 && y < M) {
                    if (arr[x][y] == 0) {
                        num_zero -=1;
                        num_one +=1;
                        arr[x][y] =1;
                        queue.add(new Node(x, y, poll.cost + 1));
                    }
                }
            }
        }
        if (num_zero > 0) {
            System.out.println(-1);

        }else {
            System.out.println(count);
        }

    }
    static class Node{
        int x;
        int y;
        int cost;
        Node(int x,int y,int cost){
            this.x =x ;
            this.y=  y;
            this.cost = cost;
        }
    }
}
