package stackandqueue.week2.programmers.p42587;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println(solution.solution(priorities, location));
    }
}
