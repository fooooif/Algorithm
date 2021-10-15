package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baeak_14502 {

    static int[][] array;
    static int zero_count = 0;
    static int two_count = 0;
    static Node[] node;
    static Node[] node_two;
    public static void main(String[] args) throws IOException {
        int max = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        array = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];


        for (int i = 0; i < array.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < array[i].length; j++) {
                int a = Integer.parseInt(st.nextToken());
                if(a == 0){
                    zero_count++;
                }
                else if(a == 2){
                    two_count++;
                }

                array[i][j] = a;
            }
        }
        node = new Node[zero_count];
        node_two = new Node[two_count];
        //꼭 3개를 세워야한다.
        // 그러면  64 C 3  64
        int index = 0;
        int index_two = 0;
        int index_one = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] == 0){
                    node[index] = new Node(i, j);
                    index++;
                }
                else if(array[i][j] == 2){
                    node_two[index_two] = new Node(i, j);
                    index_two++;
                }
            }
        }


        for (int i = 0; i < node.length; i++) {
            for (int j = i+1; j < node.length; j++) {
                for (int k = j+1; k < node.length; k++){
                    array[node[i].x][node[i].y] =1;
                    array[node[j].x][node[j].y] =1;
                    array[node[k].x][node[k].y] =1;
                    int countZero = findCountZero(array);
                    if(max <   countZero){
                        max = countZero;

                    }
                    for(int m = 0 ; m < node.length; m++){
                        array[node[m].x][node[m].y] = 0;
                    }

                }
            }
        }
        System.out.println(max);

    }

    static int findCountZero(int[][] arr) {
        int return_count=0;
        for (int i = 0; i < node_two.length; i++) {
            Queue<Node> linkedList = new LinkedList<>();
            linkedList.add(node_two[i]);
            while (!linkedList.isEmpty()) {
                Node node = linkedList.poll();
                int x = node.x;
                int y = node.y;
                if (x + 1 < arr.length  && arr[x+1][y] == 0) {
                    arr[x+1][y] = 2;
                    linkedList.add(new Node(x + 1, y));
                }
                if(y+1 < arr[x].length&& arr[x][y+1] == 0){
                    arr[x][y+1] = 2;
                    linkedList.add(new Node(x, y+1));
                }
                if (x - 1 >= 0 && arr[x-1][y] == 0 ) {
                    arr[x-1][y] = 2;
                    linkedList.add(new Node(x -1, y));

                }
                if (y - 1 >= 0  && arr[x][y-1] == 0) {
                    arr[x][y-1] = 2;
                    linkedList.add(new Node(x ,y-1));

                }

            }


        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (arr[i][j] == 0) {
                    return_count++;
                }
            }
        }
        return return_count;
    }

    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
