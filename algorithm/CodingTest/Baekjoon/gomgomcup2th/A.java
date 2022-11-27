package gomgomcup2th;

import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        // 치킨 기프티콘 선물바등ㄴ 횟수 N
        // 선물의 남은 유효기간이 주어질 때, 임스가 사용할 기프티콘 갯수
        // 유효기간 90일 이하


        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        sc.nextLine();

        int count = 0;
        for (int i = 0; i <N ; i++) {
            String[] input = sc.nextLine().split("-");
            if (Integer.parseInt(input[1]) <= 90) {
                count ++;
            }
        }

        System.out.println(count);
    }
}
