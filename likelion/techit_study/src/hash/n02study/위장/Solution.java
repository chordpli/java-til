package hash.n02study.위장;

import java.util.HashMap;

public class Solution {

    public int solution(String[][] clothes) {
        int ans = 1;
        HashMap<String, Integer> clothesMap = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 1) + 1);
        }

        for (String s : clothesMap.keySet()) {
            ans *= clothesMap.get(s);
        }

        return ans - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] clothes = {
                {"yellowHat", "headgear"},
                {"blueSunglasses", "eyewear"},
                {"greenTurban", "headgear"}
        };

        System.out.println(s.solution(clothes));
    }
}
