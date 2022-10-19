package hash.n02study.위장;

import java.util.HashMap;
import java.util.HashSet;

public class fail {
    public int solution(String[][] clothes) {
        int answer = 0;

        HashMap<String, HashSet<String>> classification = new HashMap<>();

        // 초기화
        for (int i = 0; i < clothes.length; i++) {
            HashSet<String> clothesName = new HashSet<>();
            classification.put(clothes[i][1], clothesName);
        }

        for (int i = 0; i < clothes.length; i++) {
            classification.get(clothes[i][1]).add(clothes[i][0]);
        }

        for (int i = 0; i < clothes.length; i++) {
            for (int j = 0; j < clothes[i].length; j++) {
            }
        }
        int dup = 1;

        // 확인용 출력
        for (String s : classification.keySet()) {
            answer += classification.get(s).size();
            dup *= classification.get(s).size();
        }


        return dup + answer;
    }

    public static void main(String[] args) {
        fail s = new fail();
        String[][] clothes = {
                {"yellowHat", "headgear"},
                {"blueSunglasses", "eyewear"},
                {"greenTurban", "headgear"}
        };

        System.out.println(s.solution(clothes));

    }
}
