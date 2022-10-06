package N01Study.Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Boolean> result = new HashMap<>();
        String check = null;

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (String p : participant) {
            for (String c : completion) {
                if (result.containsKey(p) && result.get(p)) {
                    result.put(p, false);
                    break;
                } else {
                    if (p.equals(c)) {
                        result.put(p, true);
                        break;
                    } else {
                        result.put(p, false);
                    }
                }
            }
            if (!result.get(p)) {
                check = p;
            }
        }
        return check;
    }
}

public class 완주하지못한선수2 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden", "leo", "leo", "leo", "kiki"};
        String[] completion = {"eden", "kiki", "leo", "leo", "leo", "leo"};
        Solution2 s = new Solution2();
        System.out.println(s.solution(participant, completion));
    }
}
