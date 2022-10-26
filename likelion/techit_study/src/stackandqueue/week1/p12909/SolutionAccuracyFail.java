package stackandqueue.week1.p12909;

import java.util.Stack;

public class SolutionAccuracyFail {
    boolean solution(String s) {
        Stack<String> word = new Stack<>();
        word = insert(word, s);
        int open = 0, close = 0;

        if (word.peek().equals("(") || s.length() % 2 != 0) {
            return false;
        }

        while (!word.isEmpty()) {
            if (open > close) {
                return false;
            } else if (open == close) {
                open = 0;
                close = 0;
            }

            if (word.pop().equals(")")) {
                close++;
            } else {
                open++;
            }
        }
        return true;
    }

    public Stack<String> insert(Stack<String> word, String s) {
        String[] sArr = s.split("");
        for (String str : sArr) {
            word.push(str);
        }
        return word;
    }

    public static void main(String[] args) {
        SolutionAccuracyFail s = new SolutionAccuracyFail();
        String input = "())()()";

        System.out.println(s.solution(input));
    }
}
