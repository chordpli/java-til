package gomgomcup2th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B {

    public static String start = "ChongChong";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int n = Integer.parseInt(br.readLine());
        Map<String, Boolean> rainbowDance = new HashMap<String, Boolean>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String person = st.nextToken();
            String opponent = st.nextToken();

            rainbowDance.putIfAbsent(person, false);

            if (person.equals(start) || opponent.equals(start) || rainbowDance.get(person)) {
                rainbowDance.put(person, true);
                rainbowDance.put(opponent, true);
            }

            if (rainbowDance.get(opponent) != null) {
                if (rainbowDance.get(opponent)) {
                    rainbowDance.put(person, true);
                }
            }
        }
        Set<String> keySet = rainbowDance.keySet();
        for (String s : keySet) {
            if (rainbowDance.get(s)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
