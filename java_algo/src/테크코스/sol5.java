package 테크코스;

public class sol5 {
    public int[][] solution(int rows, int columns) {
        int[][] answer = new int[rows][columns];


        int start = 1;
        int row = 0;
        int col = 0;
        int count = 1;
        answer[row][col] = start;
        if (rows == columns) {

            while (!(row == rows - 1 && col == 0)) {
                if (start % 2 == 1) {
                    if (col == columns - 1) {
                        col = 0;
                    } else {
                        col += 1;
                    }

                } else {
                    if (row == rows - 1) {
                        row = 0;
                    } else {
                        row += 1;
                    }
                }
                start += 1;
                answer[row][col] = start;
            }

        } else {
            while (!(count == rows * columns)) {
                if (start % 2 == 1) {
                    if (col == columns - 1) {
                        col = 0;
                    } else {
                        col += 1;
                    }

                } else {
                    if (row == rows - 1) {
                        row = 0;
                    } else {
                        row += 1;
                    }
                }
                start += 1;
                if(answer[row][col] ==0){
                    count+=1;
                }
                answer[row][col] = start;
            }
        }

            return answer;
        }
    public int[][] solution2(int rows, int columns) {
        int[][] answer = new int[rows][columns];


        int start = 1;
        int row = 0;
        int col = 0;
        answer[row][col] = start;
        int count = 0;
        while (!(count == rows * columns)){

            if (start % 2 == 1) {
                if (col == columns - 1) {
                    col = 0;
                } else {
                    col += 1;
                }

            } else {
                if (row == rows - 1) {
                    row = 0;
                } else {
                    row += 1;
                }
            }
            start += 1;
            if(answer[row][col] > 0 && answer[row][col] % 2 == start % 2 ){
                break;
            }
            if(answer[row][col] ==0){
                count+=1;
            }
            answer[row][col] = start;
        }


        return answer;
    }

}
