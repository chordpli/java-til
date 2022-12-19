package dp;

public class IntegerSquare {
    public static int solution(int[][] square) {
        int[][] sum = new int[square.length][square[0].length];

        // 첫 숫자 대입
        sum[0][0] = square[0][0];

        // 가장 윗줄, 가장 좌측 줄 초기화
        for (int i = 1; i < square[0].length ; i++) {
            sum[0][i] = sum[0][i-1] + square[0][i];
            sum[i][0] = sum[i-1][0] + square[i][0];
        }

        // 더하기 시작.
        for (int i = 1; i < square.length; i++) {
            for (int j = 1; j < square.length; j++) {
                sum[i][j] = Math.max(sum[i][j - 1] + square[i][j], sum[i - 1][j] + square[i][j]);
            }
        }

        // 최댓값 찾기
        int max = 0 ;
        for (int i = 0; i <square[0].length ; i++) {
            if(max < sum[sum.length-1][i]) max = sum[sum.length - 1][i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] square = {
                {9, 6, 1, 5, 3, 7, 8, 5},
                {3, 4, 2, 5, 7, 8, 7, 9},
                {8, 7, 7, 6, 4, 3, 5, 7},
                {3, 6, 8, 9, 5, 7, 7, 9},
                {8, 7, 6, 2, 3, 5, 6, 8},
                {1, 2, 3, 4, 5, 2, 3, 5},
                {9, 8, 7, 6, 8, 3, 4, 5},
                {6, 5, 4, 6, 3, 7, 9, 9}
        };
        System.out.println(solution(square));
    }
}
