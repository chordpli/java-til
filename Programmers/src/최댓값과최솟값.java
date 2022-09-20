public class 최댓값과최솟값 {

    public static void main(String[] args) {
        최댓값과최솟값 answer = new 최댓값과최솟값();
        System.out.println(answer.solution("1 2 3 4"));
    }

    String solution(String s){
        String[] words = s.split(" ");
        int[] num = new int[words.length];

        for(int i = 0; i < words.length; i++){
            num[i] = Integer.parseInt(words[i]);
        }

        return maxAndMin(num);
    }

    String maxAndMin(int[] num){
        int max = num[0];
        int min = num[0];

        for(int i = 1; i < num.length; i++){
            if(max < num[i]){
                max = num[i];
            }

            if(min > num[i]){
                min = num[i];
            }
        }

        return min + " " + max;
    }
}
