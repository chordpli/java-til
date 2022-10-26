package stackandqueue.week2.bj1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 문제를 이해 못했던 문제
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public StringBuilder solution(int n) throws IOException {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int saveNumber = 0;

        for (int i = 1; i <= n; i++) {
            int value = Integer.parseInt(br.readLine());

            if (value > saveNumber) {
                for (int j = saveNumber + 1; j <= value; j++) {
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                saveNumber = value;
            } else if (stack.peek() != value) {
                sb.setLength(0);
                return sb.append("NO");
            }
            stack.pop();
            sb.append('-').append('\n');
        }
        br.close();
        return sb;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        StringBuilder sb = main.solution(Integer.parseInt(br.readLine()));
        System.out.println(sb);
    }
}