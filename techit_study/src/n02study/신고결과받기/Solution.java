package n02study.신고결과받기;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {


    public int[] solution(String[] id_list, String[] report, int k){
        int[] result = new int[id_list.length];

        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        HashMap<String, Integer> reportCountMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> reportId = new HashSet<>();
            reportMap.put(id_list[i], reportId);    // Muzi = [] -> 이런 형태로 초기화
            reportCountMap.put(id_list[i], 0);  // Muzi = 0 -> 신고받은 횟수 초기화
        }

        for (String s : report) {
            String reportId = s.split(" ")[0];
            String reportedId = s.split(" ")[1];

            reportMap.get(reportedId).add(reportId);
            // 신고 당한 User = Key, 신고한 User = Value;
        }

        for (String s : reportMap.keySet()) {
            HashSet<String> sendEmail = reportMap.get(s);
            if (sendEmail.size() >= k) {
                for (String userId : sendEmail) {
                    reportCountMap.put(userId, reportCountMap.get(userId)+1);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            result[i] = reportCountMap.get(id_list[i]);
        }

        return result;
    }


    public static void main(String[] args) {
        String[] idList = {"musi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        Solution s = new Solution();

        System.out.println(s.solution(idList, report, k));
    }
}
