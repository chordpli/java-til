package stackandqueue.p12909;

import java.util.Stack;

public class SolutionFail {
    boolean solution(String s) {
        Stack<String> word = new Stack<>();
        word = insert(word, s);
        int open = 0, close = 0;

        while (!word.isEmpty()) {
            if (word.size() == 1 && word.peek().equals(")")) {
                return false;
            }
            if (word.pop().equals("(")) {
                open++;
            } else {
                close++;
            }
        }

        if (open == close) {
            return true;
        } else {
            return false;
        }
    }

    public Stack<String> insert(Stack<String> word, String s) {
        String[] sArr = s.split("");
        for (int i = 0; i < s.length(); i++) {
            word.push(sArr[i]);
        }
        return word;
    }

    public static void main(String[] args) {
        SolutionFail s = new SolutionFail();
        String input = ")()(";

        System.out.println(s.solution(input));
    }
}
