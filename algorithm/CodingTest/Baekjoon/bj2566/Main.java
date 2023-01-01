package bj2566;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[10][10];

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 2차원 배열을 입력 받습니다.
        for (int i = 1; i <= 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
    }

    // 최대 값을 찾는다.
    static void findMax(int[][] map) {
        int max = -1;
        int row = 0;
        int column = 0;

        // 행렬을 돌면서 최댓값을 찾는다.
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                // 저장되어 있는 최댓값보다 현재 map의 값이 크다면 값을 치환한다.
                if (max < map[i][j]) {
                    max = map[i][j];
                    row = i;
                    column = j;
                }
            }
        }

        System.out.println(max);
        System.out.print(row + " " + column);
    }

    public static void main(String[] args) throws IOException {
        input();
        findMax(map);
    }
}