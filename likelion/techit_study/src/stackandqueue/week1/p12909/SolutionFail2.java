package stackandqueue.week1.p12909;

public class SolutionFail2 {
    boolean solution(String s) {
        String[] arr = s.split("");
        int open = 0, close = 0;
        if (arr[0].equals(")") || arr[s.length()-1].equals("(") || arr.length % 2 != 0) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("(")) {
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

    public static void main(String[] args) {
        SolutionFail2 s = new SolutionFail2();
        String input = "(())()";

        System.out.println(s.solution(input));
    }
}
