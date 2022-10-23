package stackandqueue.p12909;

import java.util.Stack;

public class Solution {
    boolean solution(String s) {
        Stack<String> word = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                word.push("(");
            } else {
                if (s.charAt(i) == ')' && !word.isEmpty()) {
                    word.pop();
                } else {
                    return false;
                }
            }
        }
        if (word.isEmpty()) {
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String input = "(()(";

        System.out.println(s.solution(input));
    }
}
