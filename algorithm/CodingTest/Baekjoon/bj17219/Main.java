package bj17219;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String firstLine = br.readLine();
        Map<String, String> siteAndPassword = new HashMap<>();

        StringTokenizer st = new StringTokenizer(firstLine);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            st = new StringTokenizer(input);
            siteAndPassword.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            String url = br.readLine();
            bw.write(siteAndPassword.get(url));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
