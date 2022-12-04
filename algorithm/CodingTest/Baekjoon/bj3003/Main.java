package bj3003;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        int[] chess = {1, 1, 2, 2, 2, 8};
        int[] result = new int[6];

        for(int i = 0; i < 6; i++){
            if(Integer.parseInt(input[i]) > chess[i] || chess[i] > Integer.parseInt(input[i])){
                result[i] = chess[i] - Integer.parseInt(input[i]);
            }else{
                result[i] = 0;
            }
        }

        for(int i = 0; i< result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
