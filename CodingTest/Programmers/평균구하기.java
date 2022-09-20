public class 평균구하기 {
    public static void main(String[] args) {
        평균구하기 result = new 평균구하기();
        int[] arr = {1, 2, 3, 4};
        System.out.println(result.solution(arr));
    }
    double solution(int[] arr){
        int sum = 0;
        double answer;

        for(int i : arr){
            sum += i;
        }

        answer = (double) sum/arr.length;
        return answer;
    }
}
