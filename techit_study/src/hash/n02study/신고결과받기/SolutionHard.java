package hash.n02study.신고결과받기;

import java.util.*;

public class SolutionHard {


    public int[] solution(String[] id_list, String[] report, int k){
        int[] result = new int[id_list.length];

        HashMap<String, HashSet<String>> reporterInfo = new HashMap<>();
        HashMap<String, Integer> reportedCnt = new HashMap<>();
        HashSet<String> reportSet = new HashSet<>(Arrays.asList(report));

        for (String s : reportSet) {
            String reporter = s.split(" ")[0];
            String reported = s.split(" ")[1];
            reporterInfo.putIfAbsent(reporter, new HashSet<String>(){{
                add(reported);
            }});
            reporterInfo.get(reporter).add(reported);
            reportedCnt.put(reported, reportedCnt.getOrDefault(reported, 0) + 1);
        }

        for (String reported : reportedCnt.keySet()) {
            int reportedCount = reportedCnt.get(reported);
            if (reportedCount >= k) {
                for (int i = 0; i < id_list.length; i++) {
                    if(reporterInfo.containsKey(id_list[i]) && reporterInfo.get(id_list[i]).contains(reported)){
                        result[i]++;
                    }
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        String[] idList = {"musi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;




    }
}
