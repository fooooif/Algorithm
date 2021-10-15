package dp;

class pg_정수삼각형{
    static int[] dp;
    static int len=0;
    public int solution(int[][] triangle) {
        sum_heigth(triangle.length);
        dp = new int[len];
        dp[0] = triangle[0][0];
        int count = 0;
        int left =1;
        int right =2;
        int answer = 0 ;
        for(int i = 0 ; i < triangle.length -1; i++){
            for(int j = 0; j < i+1; j++){
                dp[count+left] = Math.max(dp[count] + triangle[i+1][j],dp[count+left]);
                dp[count+right] = Math.max(dp[count] + triangle[i+1][j+1] , dp[count+right] );
                count++;
            }
            if(i == triangle.length -2){
                count--;


            }
            left++;
            right++;
        }
        for(int i = 0 ; i < triangle.length ; i++){
            int sum = 0 ;
            for(int j = 1 ; j < triangle.length; j++){
                sum += j;
            }
            answer = Math.max(dp[sum+i],answer);
        }
        // for(int i = 0 ; i < dp.length; i++){
        //     System.out.println(dp[i]);
        // }

        return answer;
    }
    static void sum_heigth(int i){
        if(i > 0){
            len += i;
            sum_heigth(i-1);
        }


    }
}
