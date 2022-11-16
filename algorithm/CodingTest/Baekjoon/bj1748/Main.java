package bj1748;

import java.util.Scanner;

public class Main {
    /**
     * 1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.
     * **   1234567891011121314151617181920212223...
     * 이렇게 만들어진 새로운 수는 몇 자리 수일까? 이 수의 자릿수를 구하는 프로그램을 작성하시오.
     */
     /*
      1~13 까지의 수를 이어서 쓰면 다음과 같이 새로운 하나의 수를 얻을 수 있다.
      12345678910111213
      해당 자리수는 몇 자리 수인가? -> 17
     */

    /* 1-9까지는 1자리
        10-99까지는 2자리
        100-999까지는 3자리리
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int intN = Integer.parseInt(n);
        // n의 길이 구하기
        int nLength = n.length();

        // 자리수 구하기
        int pow = (int)Math.pow(10, nLength - 1);

        // 최대 자리수의 자리수 합.
        int sum = ((intN - pow + 1) * nLength);

        for (int i = nLength-1; i > 0 ; i--) {
            sum += (Math.pow(10, i) - Math.pow(10, i-1))*i;
        }

        System.out.println(sum);
    }
}