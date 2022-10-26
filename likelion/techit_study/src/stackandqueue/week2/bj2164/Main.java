package stackandqueue.week2.bj2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = main.init(sc.nextInt());

        while (queue.size() != 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.peek());

        sc.close();
    }

    public Queue<Integer> init(int num) {
        Queue<Integer> output = new LinkedList<>();
        for (int i = 1; i <= num; i++) {
            output.add(i);
        }
        return output;
    }
}
