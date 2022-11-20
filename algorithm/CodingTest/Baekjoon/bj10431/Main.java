package bj10431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] sum = new int[N];
        List<List<Integer>> input = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> online = new ArrayList<>();
            st.nextToken();
            while (st.hasMoreTokens()) {
                online.add(Integer.parseInt(st.nextToken()));
            }
            input.add(online);
        }

        for (int i = 0; i < N; i++) {
            int size = input.get(i).size();
            for (int j = 0; j < size; j++) {
                int min = input.get(i).get(j);
                int idx = 0;
                for (int k = j+1; k < size; k++) {
                    if (input.get(i).get(k) < min) {
                        min = input.get(i).get(k);
                        idx = k;
                    }
                }
                if (min < input.get(i).get(j)) {
                    for (int k = idx; k > j; k--) {
                        int temp = input.get(i).get(k);
                        input.get(i).remove(k);
                        input.get(i).add(k, input.get(i).get(k - 1));
                        input.get(i).remove(k-1);
                        input.get(i).add(k - 1, temp);
                        sum[i] += 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(i + 1 + " " + sum[i]);
        }

    }
}
