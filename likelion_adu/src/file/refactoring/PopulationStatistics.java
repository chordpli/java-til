package file.refactoring;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
1. csv파일을 읽어온다.
2. 콤마(,)를 사용하여 Split을 진행한다. 우리에게 필요한 것은 1 진입 시,도 코드 2. 전출 시,도 코드
3. 스플릿한 내용을 파일로 저장한다.
*/

public class PopulationStatistics {

    // 파일을 불러와서 10,000자 읽기
    public void read10000Char(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);

        // 10,000 문자를 저장할 변수 String 선언
        String fileContents = "";

        // String fileContent의 길이가 10,000자를 넘어가면 멈춤.
        // 10,000자 미만일 땐, 한 글짜씩 계속 추가된다.
        while (fileContents.length() < 10000) {
            fileContents += (char) fileReader.read();
        }
        System.out.println(fileContents);
    }

    // 파일을 읽어와서 한 줄씩 읽기
    public List<PopulationMove> readByLine(String filename) {
        List<PopulationMove> pml = new ArrayList<>();
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8);
            String str;
            while ((str = br.readLine()) != null) {
                PopulationMove pm = parse(str);
                pml.add(pm);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pml;
    }

    // 파일에서 split 하기
    public PopulationMove parse(String data) {
        String str[] = data.split(",");
        int toSido = Integer.parseInt(str[0]);
        int fromSido = Integer.parseInt(str[6]);
        PopulationMove pm = new PopulationMove(fromSido, toSido);
        return pm;
    }

    // 파일 생성하기
    public void createFile(String filename) {
        File file = new File(filename);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 파일 작성하기 (생성된 파일에 내용 집어넣기)
    public void write(List<String> strs, String filename) {
        File file = new File(filename);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (String str : strs) {
                bw.write(str);
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Map<String, Integer> getMoveCntMap(List<PopulationMove> populationMoveList) {
        Map<String, Integer> moveCntMap = new HashMap<>();

        for (PopulationMove pm : populationMoveList) {
            String key = pm.getFromSido() + "," + pm.getToSido();
            moveCntMap.put(key, moveCntMap.getOrDefault(key, 0) + 1);
        }
        return moveCntMap;
    }

    public Map<String, Integer> heatmapIdxMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("11", 0);
        map.put("26", 1);
        map.put("27", 2);
        map.put("28", 3);
        map.put("29", 4);
        map.put("30", 5);
        map.put("31", 6);
        map.put("36", 7);
        map.put("41", 8);
        map.put("42", 9);
        map.put("43", 10);
        map.put("44", 11);
        map.put("45", 12);
        map.put("46", 13);
        map.put("47", 14);
        map.put("48", 15);
        map.put("50", 16);

        return map;
    }

    public static void main(String[] args) throws IOException {
        String fileAddress = "P:\\TechIt\\교재\\week3\\2021_인구관련연간자료_20221006_45659.csv";
        //String fileAddress = "F:\\techit\\2021_인구관련연간자료_20220927_66125.csv";
        PopulationStatistics ps = new PopulationStatistics();
        List<PopulationMove> pml = ps.readByLine(fileAddress);

        //  $$(전출코드),$$(전입코드) 형식으로 파일 정리.
        String filename = "P:\\Study\\BootSpring\\TIL\\likelion_adu\\src\\file\\mdis\\splitData2.txt";
        ps.createFile(filename);

        List<String> inData = new ArrayList<>();
        for (PopulationMove pm : pml) {
            String str = pm.getFromSido() + "," + pm.getToSido() + "\n";
            inData.add(str);
        }

        ps.write(inData, filename);
        Map<String, Integer> map = ps.getMoveCntMap(pml);
        Map<String, Integer> heatmapIdxMap = ps.heatmapIdxMap();

        // + 전입 전출한 숫자 증가자료 포함하여 다시 추출
        String targetFilename = "./for_heatmap2.txt";
        ps.createFile(targetFilename);
        List<String> cntResult = new ArrayList<>();

        for (String key : map.keySet()) {
            String[] fromto = key.split(",");
            // 매핑 후 저장
            String s = String.format("[%s, %s, %d] ,", heatmapIdxMap.get(fromto[0]), heatmapIdxMap.get(fromto[1]), map.get(key));
            cntResult.add(s);
        }
        System.out.println(pml.size()); // 6209323
        ps.write(cntResult, targetFilename);

    }
}