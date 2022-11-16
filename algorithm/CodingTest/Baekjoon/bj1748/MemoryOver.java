package bj1748;

import java.util.Scanner;

public class MemoryOver {
    /**
     * 1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.
     ***   1234567891011121314151617181920212223...
     * 이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.
     *
     *
     * 1~13 까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.
     * 12345678910111213
     * 해당 자리수는 몇 자리 수인가? -> 17
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫째 줄에 N이 주어진다.
        int N = sc.nextInt();

        // 수를 이어서 작성한다.
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N ; i++) {
            sb.append(String.valueOf(i));
        }
        // 첫째 줄에 새로운 수의 자릿수를 출력한다.

        System.out.println(sb.length());
    }
}
