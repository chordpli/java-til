package stackandqueue.week1.bj1158;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> input = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();
        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 1; i <=n ; i++) {
            input.add(i);
        }

        int i = 1;

        while (!input.isEmpty()) {
            if (i != k) {
                input.add(input.remove());
                i++;
            } else if (i == k) {
                result.add(input.remove());
                i = 1;
            }
        }

        System.out.print("<");
        for (int j = 0; j < n ; j++) {
            if (j == n - 1) {
                System.out.print(result.remove() + ">");
            }else{
                System.out.print(result.remove() + ", ");
            }

        }
        sc.close();
    }
}