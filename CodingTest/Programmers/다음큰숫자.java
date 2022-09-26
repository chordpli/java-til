class Solution {
    public int solution(int n) {
        String binaryA = Integer.toBinaryString(n);
        String binaryB;

        int ACount = findOne(binaryA);
        int BCount;
        int resultNum;

        for (int i = n + 1; ; i++) {
            resultNum = i;
            BCount = findOne(i);
            if (ACount == BCount) {
                break;
            }
        }
        return resultNum;
    }

    public int findOne(String binary) {
        String[] checkOne = binary.split("");
        int count = 0;
        for (int i = 0; i < checkOne.length; i++) {
            if (checkOne[i].equals("1")) {
                count++;
            }
        }
        return count;
    }

    public int findOne(int binary) {
        String[] checkOne = Integer.toBinaryString(binary).split("");
        int count = 0;
        for (int i = 0; i < checkOne.length; i++) {
            if (checkOne[i].equals("1")) {
                count++;
            }
        }
        return count;
    }
}

public class 다음큰숫자 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(15));
    }
}
