package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Baek_2252 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //input이 몇개 있는지
        int[] arr = new int[N + 1];

        //graph => 간선확인용.
        HashMap<Integer, LinkedList<Integer>> hashMap = new HashMap<>();

        ArrayList<Integer>[] arrayLists = new ArrayList[N + 1];
        for (int i = 0 ; i < N+1; i++){
            arrayLists[i] = new ArrayList<>();
        }
        for (int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arrayLists[x].add(y);
            arr[y] += 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if (arr[i] == 0) {
                queue.add(i);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            q.add(poll);
            for (int i : arrayLists[poll]) {
                arr[i] -= 1;
                if (arr[i] == 0) {
                    queue.add(i);
                }
            }

        }

        while (!q.isEmpty()) {
            System.out.print(q.poll() + " ");
        }

    }

}
