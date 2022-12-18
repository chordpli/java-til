package bj5597;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Map<Integer, Integer> map = new HashMap<>();

    public Main() {
        init();
    }

    void init() {
        for (int i = 1; i <= 30; i++) {
            map.put(i, i);
        }
    }

    public void remove() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 28; i++) {
            map.remove(sc.nextInt());
        }
    }

    public void solution() {
        remove();
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            System.out.println(key);
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.solution();
    }
}