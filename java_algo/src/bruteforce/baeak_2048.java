package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//array 다시 되돌리는 문제임!!
public class baeak_2048 {
    static int N ;
    static int[][] arr ;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        max = 0;
        arr = new int[N][N];
        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j++){

                arr[i][j] = Integer.parseInt(st.nextToken());
                if(max < arr[i][j]){
                    max =arr[i][j];
                }
            }
        }
        //배열 다시 돌리는게 제일 문제.
        //배열 copy를 어떻게 할지 생각하자.
        //4가지를 1,2,3,4 다 순서에 영향을 받는다

            dfs(arr,-1,-1);
        System.out.println(max);
    }
    static void dfs(int[][] array,int depth,int dir){
        int[][] temp = new int[array.length][array[0].length];
        for(int i = 0 ; i < array.length; i++){
            temp[i] = Arrays.copyOf(array[i],array[i].length);
        }
        if(depth == 5){
            return;
        }
        if(dir == 1){

            for(int x = 0; x < array.length; x++){
                ArrayList<Integer> arrayList = new ArrayList<>();
                Queue<Integer> queue = new LinkedList<>();
                for(int y = 0 ; y< array[x].length; y++){
                    if(array[x][y] != 0) {
                        arrayList.add(array[x][y]);
                    }
                }
                while(arrayList.size() > 1){
                    int end = arrayList.get(arrayList.size() - 1);
                    arrayList.remove(arrayList.size()-1);
                    int end_1 = arrayList.get(arrayList.size() - 1);
                    arrayList.remove(arrayList.size()-1);
                    if(end == end_1){
                        queue.add(end+end_1);
                    }
                    else{
                        arrayList.add(end_1);
                        queue.add(end);
                    }
                }
                if(arrayList.size() == 1){
                    queue.add(arrayList.get(0));
                }
                for(int y = array[x].length-1 ; y>-1; y--){
                    if(!queue.isEmpty()) {
                        array[x][y] = queue.poll();
                    }else{
                        array[x][y] = 0;
                    }
                }
            }
        }
        else if(dir == 2 ){
            for(int x = 0; x < array.length; x++){
                ArrayList<Integer> arrayList = new ArrayList<>();
                Queue<Integer> queue = new LinkedList<>();
                for(int y = array[x].length -1; y>-1; y--){
                    if(array[x][y] != 0) {
                        arrayList.add(array[x][y]);
                    }
                }
                while(arrayList.size() > 1){
                    int end = arrayList.get(arrayList.size() - 1);
                    arrayList.remove(arrayList.size()-1);
                    int end_1 = arrayList.get(arrayList.size() - 1);
                    arrayList.remove(arrayList.size()-1);
                    if(end == end_1){
                        queue.add(end+end_1);
                    }
                    else{
                        arrayList.add(end_1);
                        queue.add(end);
                    }
                }
                if(arrayList.size() == 1){
                    queue.add(arrayList.get(0));
                }
                for(int y = 0; y < array[x].length; y++){
                    if(!queue.isEmpty()) {
                        array[x][y] = queue.poll();
                    }else{
                        array[x][y] = 0;
                    }
                }
            }
        }
        else if(dir == 3){
            for(int y = 0; y < array[0].length; y++){
                ArrayList<Integer> arrayList = new ArrayList<>();
                Queue<Integer> queue = new LinkedList<>();
                for(int x = array.length ; x>-1; x--){
                    if(array[x][y] != 0) {
                        arrayList.add(array[x][y]);
                    }
                }
                while(arrayList.size() > 1){
                    int end = arrayList.get(arrayList.size() - 1);
                    arrayList.remove(arrayList.size()-1);
                    int end_1 = arrayList.get(arrayList.size() - 1);
                    arrayList.remove(arrayList.size()-1);
                    if(end == end_1){
                        queue.add(end+end_1);
                    }
                    else{
                        arrayList.add(end_1);
                        queue.add(end);
                    }
                }
                if(arrayList.size() == 1){
                    queue.add(arrayList.get(0));
                }
                for(int x = 0; x < array.length; x++){
                    if(!queue.isEmpty()) {
                        array[x][y] = queue.poll();
                    }else{
                        array[x][y] = 0;
                    }
                }
            }
        }
        else if(dir ==4){
            for(int y = 0; y < array[0].length; y++){
                ArrayList<Integer> arrayList = new ArrayList<>();
                Queue<Integer> queue = new LinkedList<>();
                for(int x = 0 ; x< array.length; x++){
                    if(array[x][y] != 0) {
                        arrayList.add(array[x][y]);
                    }
                }
                while(arrayList.size() > 1){
                    int end = arrayList.get(arrayList.size() - 1);
                    arrayList.remove(arrayList.size()-1);
                    int end_1 = arrayList.get(arrayList.size() - 1);
                    arrayList.remove(arrayList.size()-1);
                    if(end == end_1){
                        queue.add(end+end_1);
                    }
                    else{
                        arrayList.add(end_1);
                        queue.add(end);
                    }
                }
                if(arrayList.size() == 1){
                    queue.add(arrayList.get(0));
                }
                for(int x = array.length -1; x > -1; x--){
                    if(!queue.isEmpty()) {
                        array[x][y] = queue.poll();
                    }else{
                        array[x][y] = 0;
                    }
                }
            }
        }
        for(int i = 1; i < 5; i++){

            dfs(temp,depth+1,i);
        }

        if(depth == 4){
            for(int i = 0 ; i < array.length; i++){
                for(int j = 0 ; j < array[i].length ; j++){
                    if(max < array[i][j]){
                        max = array[i][j];
                    }
                }
            }
        }
        for(int i = 0 ; i < array.length; i++){
            array[i] = Arrays.copyOf(temp[i],temp[i].length);
        }
    }
}
