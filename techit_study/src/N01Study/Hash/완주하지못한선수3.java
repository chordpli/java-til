package N01Study.Hash;

import java.util.HashMap;
import java.util.Map;

class Solution3 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> result = new HashMap<>();
        String check = null;

        for (String p : participant) {
            result.put(p, result.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            result.put(c, result.get(c) - 1);
        }

        for (String key : result.keySet()) {
            if (result.get(key) != 0) {
                check = key;
                break;
            }
        }
        return check;
    }
}

public class 완주하지못한선수3 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden", "leo", "leo", "leo", "kiki"};
        String[] completion = {"eden", "kiki", "leo", "leo", "leo", "leo"};
        Solution2 s = new Solution2();
        System.out.println(s.solution(participant, completion));
    }
}
