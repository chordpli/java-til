import java.util.Stack;

public class ans03 {
    public static void main(String[] args) {

    }
}

class Solution {
    public String solution(String code) { // -> String 배열로 받아야 원하는 자료입력을 할 수 있습니다.
        Stack<Integer> stack = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        String temp = "";
        String answer = "";
        for (int i = 0; i < code.length; i++) { // -> 배열이 아니기 때문에 길이를 알고 싶다면 .length가 아닌 .length()를 사용해야합니다.
            int count = 0;
            if (code[i] >= '0' && code[i] <= '9') { //code가 배열이 아니기 때문에 index를 사용할 수 없습니다. String[] 배열 선언시 문자열이기 때문에 조건문이 성사되지 않습니다.
                                                    // 스트링 배열을 사용한다면 code[i].charAt(?) >= '0'로 코드를 고치셔야 사용 가능할 것 같습니다.
                while (code[i] >= '0' && code[i] <= '9') {
                    count = count * 10 + code[i] - '0';
                    i++;
                }
                i--;
                stack.push(count);

            } else if (code[i] == '{') {
                if (code[i - 1] >= '0' && code[i - 1] <= '9')
                    stack.push(code[i]);
                else {
                    stack.push(code[i]);
                }
            }
        }
    }
}