public class 짝수와홀수 {

    public static void main(String[] args) {
        짝수와홀수 evenOrOdd = new 짝수와홀수();
        System.out.println(evenOrOdd.solution(10));
    }

    String solution(int num) {
        String answer;
        if (num % 2 == 0) {
            answer = "Even";
        } else {
            answer = "Odd";
        }
        return answer;
    }
}