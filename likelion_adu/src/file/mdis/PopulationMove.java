package file.mdis;

/* 11 : 서울, 21 : 부산, 22 : 대구
 * 23 : 인천, 24: 광주, 25: 대전, 26: 울산
 * 29 : 세종, 31: 경기도 32: 강원도, 33: 충청북도
 * 34 : 충청남도, 35: 전라북도, 36 :전라남도
 * 37 : 경상북도, 38: 경상남도, 39:제주도
 * */

public class PopulationMove {
    private int toSido;     // 전입
    private int fromSido;   // 전출

    public PopulationMove(int toSido, int fromSido) {
        this.toSido = toSido;
        this.fromSido = fromSido;
    }

    public int getToSido() {
        return toSido;
    }

    public void setToSido(int toSido) {
        this.toSido = toSido;
    }

    public int getFromSido() {
        return fromSido;
    }

    public void setFromSido(int fromSido) {
        this.fromSido = fromSido;
    }
}
