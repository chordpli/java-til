public class 피보나치수 {

    public static void main(String[] args) {
        피보나치수 f = new 피보나치수();
        System.out.println(f.solution(5));
    }

    // 재귀로 풀었을 시, 시간초과
    // 반복문을 통한 DP로 풀어야함.
    public int solution(int n) {
        int[] result = new int[100001];
        result[1] = 1;
        result[2] = 1;
        result[3] = 2;

        for(int i = 4; i < result.length; i++){
            result[i] = (result[i-1] + result[i-2])%1234567;
        }

        return result[n];
    }

}
