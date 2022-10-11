import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraryListInMap {
    public static void main(String[] args) {

        Map<String, ArrayList<String>> test01 = new HashMap<>();
        ArrayList<String> test02 = new ArrayList<String>();
        test01.put("안녕하세요", test02);
    }
}
