package bj1003;

import java.util.Scanner;

public class Main {
    static int[][] dp = new int[2][41];

    public static int inputTestCase(Scanner sc) {
        return sc.nextInt();
    }

    public Main() {
        fibonacci();
    }

    public  void fibonacci() {
        getOne();
        getZero();
    }

    public  void getZero() {
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[0][2] = 1;
        dp[0][3] = 1;
        for (int i = 4; i <dp[0].length ; i++) {
            dp[0][i] = dp[0][i - 1] + dp[0][i - 2];
        }
    }

    public  void getOne() {
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 2;
        for (int i = 4; i <dp[1].length ; i++) {
            dp[1][i] = dp[1][i - 1] + dp[1][i - 2];
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int testC = inputTestCase(sc);

        for (int i = 0; i < testC; i++) {
            int value = sc.nextInt();
            System.out.println(dp[0][value] + " " +dp[1][value]);
        }
    }
}