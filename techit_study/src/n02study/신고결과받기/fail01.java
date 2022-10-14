package n02study.신고결과받기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fail01 {

    String reporter;
    String reported;

    public fail01(String reporter, String reported) {
        this.reporter = reporter;
        this.reported = reported;
    }

    public int[] solution(String[] id_list, String[] report, int k){
        // 신고 누적 초기화, ID리스트
        Map<String, Integer> check = new HashMap<>(init(id_list));

        // 신고를 받아봅시다. // reporter, reported로 나뉨
        List<fail01> reportList = new ArrayList<>(parseReport(report));

        for(fail01 s: reportList){
            if(check == null){
            }
        }

        Map<String, Map<String, Integer>> sMap = new HashMap<>();

        return new int[5];
    }
    public Map<String, Integer> init(String[] id_list){
        Map<String, Integer> initReport = new HashMap<>();
        for(String s: id_list){
            initReport.put(s, 0);
        }
        return initReport;
    }

    public List<fail01> parseReport(String[] report){
        List<fail01> reportList = new ArrayList<>();
        for(int i = 0; i < report.length; i++){
            fail01 s;
            String reporter = report[i].split(" ")[0];
            String reported = report[i].split(" ")[1];
            s = new fail01(reporter, reported);
            reportList.add(s);
        }
        return reportList;
    }

    public static void main(String[] args) {
        String[] idList = {"musi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

    }
}
