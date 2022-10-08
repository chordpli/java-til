package file.mdis;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
    public List<PopulationMove> readByLine(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String str;
        List<PopulationMove> pml = new ArrayList<>();
        while ((str = br.readLine()) != null) {
            PopulationMove pm = parse(str);
            pml.add(pm);
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
        String fileAddress = "P:\\TechIt\\교재\\week3\\2021_인구관련연간자료_20220927_66125.csv";
        PopulationStatistics ps = new PopulationStatistics();
        List<PopulationMove> pml = ps.readByLine(fileAddress);

        //  $$(전출코드),$$(전입코드) 형식으로 파일 정리.
        String folderName = "P:\\Study\\BootSpring\\TIL\\likelion_adu\\src\\file\\mdis\\splitData.txt";
        ps.createFile(folderName);

        List<String> inData = new ArrayList<>();
        for (PopulationMove pm : pml) {
            String str = pm.getFromSido() + "," + pm.getToSido() + "\n";
            inData.add(str);
        }

        ps.write(inData, folderName);

    }
}
