package bj15990;

import java.util.Scanner;

public class Main {
    static final int MOD = 1_000_000_009;
    static long[][] dp;

    public static void main(String[] args) {
        dp = new long[100005][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= 100001; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][2] + dp[i - 3][1]) % MOD;
        }

        Scanner sc = new Scanner(System.in);
        final int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int input = sc.nextInt();
            long value = (dp[input][1] + dp[input][2] + dp[input][3]) % MOD;
            System.out.println(value);
        }
    }
}