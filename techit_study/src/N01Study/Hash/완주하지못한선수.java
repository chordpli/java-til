package N01Study.Hash;

import java.util.HashMap;
import java.util.Map;

class Solution {
    String[] participant;
    String[] completion;

    public String solution(String[] participant, String[] completion) {
        Map<String, String> result = new HashMap<>();

        for (String s : participant) {
            for (int j = 0; j < completion.length; j++) {
                if (s.equals(completion[j])) {
                    if (result.get(s).equals("completion")) {
                        result.put(s, "fail");
                    } else {
                        result.put(s, "completion");
                    }
                    break;
                }
            }
        }
        String fail = null;
        for (Map.Entry<String, String> entry : result.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (value.equals("fail")) {
                fail = key;
            }
        }
        return fail;
    }
}

public class 완주하지못한선수 {
    public static void main(String[] args) {

    }
}
