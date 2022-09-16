import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Random;
import java.util.Scanner;

public class ans01 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        char buy = 'A';
        int min = 1;
        int max = 45;
        int[] num = new int[6];

        System.out.println("로또 개수를 입력해주세요 (숫자 1 ~ 10)");
        int count = sc.nextInt();
        int check = 1;

        for (int i = 0; i < num.length; i++){
            num[i] = (rd.nextInt((max-min)+1) + min);

            for (int j = 0; j < i ; j++){
                if(num[i] == num[j]){
                    i--;
                }
            }

            if(i == 5){
                System.out.print(buy + " ");
                for(int k = 0; k < 6; k++){
                    System.out.print(num[k] + " ");
                }
                buy++;
                i = 0;

                if(check == count){
                    break;
                }
                check++;
                System.out.println();
            }

        }
    }
}
