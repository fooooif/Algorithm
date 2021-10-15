package dfs_bfs;

class Pg_단어변환 {
    static boolean[] visited;
    static boolean[][] graph;
    static int answer ;
    static int index ;
    public int solution(String begin, String target, String[] words){
        answer = words.length+1;
        visited = new boolean[words.length+1];
        graph = new boolean[words.length+1][words.length+1];

        String[] words_temp = new String[words.length+1];
        words_temp[0] = begin;
        int count_tar = 0;
        for(int i = 1 ;i < words.length+1; i++){
            words_temp[i] = words[i-1];
            if(target.equals(words[i-1])){
                count_tar=1;
                index = i;
            }
        }
        if(count_tar != 1){
            return 0;
        }
        for(int i = 0 ; i < words_temp.length ; i++){
            for(int j = i+1 ; j < words_temp.length; j++){
                int aa = 0;
                for(int k = 0 ; k < begin.length(); k++){
                    String standard = words_temp[i].substring(k,k+1);
                    String com = words_temp[j].substring(k,k+1);

                    if(standard.equals(com)){
                        aa++;
                    }

                }
                if(aa == begin.length() -1){
                    graph[i][j] = true;
                    graph[j][i] = true;
                }
            }
        }

        int answer_count = 0;
        visited[0] = true;
        dfs(0,answer_count);

        if(answer == words.length+1){
            return 0 ;
        }
        return answer;
    }
    static void dfs(int a,int answer_count){
        if(a == index){
            answer = Math.min(answer,answer_count);
            System.out.println("-------------");
            for(int i = 0 ; i < visited.length; i++){
                System.out.println(visited[i]);

            }
            System.out.println("-------------");

            return;
        }
        for(int i = 1; i < graph.length;i++){
            if( i == a ){
                continue;
            }
            if(graph[a][i] == true){
                if(visited[i] == false){
                    visited[i] = true;
                    dfs(i,answer_count+1);
                    visited[i] = false;
                }

            }
        }
    }

}