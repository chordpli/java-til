package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 왼쪽 페이지가 짝수일때
        if (pobi.get(0) % 2 == 0 || crong.get(0) % 2 == 0) {
            return -1;
        }

        // 페이지가 연달아 있지 않을때
        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1)) {
            return -1;
        }

        // 두 수 비교 결과
        Problem1 p = new Problem1();
        try {
            answer = p.compareNumber(pobi, crong);
        } catch (Exception e) {
            answer = -1;
        }finally {
            return answer;
        }
    }

    public int compareNumber(List<Integer> pobi, List<Integer> crong) {
        int pobiNumber = returnBigNum(pobi);
        int crongNumber = returnBigNum(crong);

        if (pobiNumber == crongNumber) {
            return 0;
        } else if (pobiNumber > crongNumber) {
            return 1;
        } else {
            return 2;
        }
    }

    // 큰 수 리턴
    public int returnBigNum(List<Integer> people) {
        // 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        int plusNum = returnPlusNum(people.get(0), people.get(1));
        int multipleNum = returnMulipleNum(people.get(0), people.get(1));

        if (plusNum > multipleNum) {
            return plusNum;
        }else{
            return multipleNum;
        }

    }

    // 더하기 큰 수 반환

    public int returnPlusNum(int leftPage, int rightPage) {
        int sum = 0;

        while (leftPage > 0) {
            sum += leftPage % 10;
            leftPage /= 10;
        }

        while (rightPage > 0) {
            sum += rightPage%10;
            rightPage /= 10;
        }
        return sum;
    }

    // 곱하기 큰 수 반환
    public int returnMulipleNum(int leftPage, int rightPage) {
        int sum = 1;

        while (leftPage > 0) {
            sum *= leftPage%10;
            leftPage /= 10;
        }

        while (rightPage > 0) {
            sum *= rightPage%10;
            rightPage /= 10;
        }
        return sum;
    }
}