import java.util.Arrays;

public class MergeArrays {

    public int[] mergeArrays(int[] a, int[] b) {
        int[] intArr = new int[a.length+b.length];
        System.arraycopy(a, 0, intArr, 0, a.length);
        System.arraycopy(b, 0, intArr, a.length, a.length);
        return intArr;
    }

    public static void main(String[] args) {
        MergeArrays m = new MergeArrays();
        int[] output = m.mergeArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(Arrays.toString(output));
    }
}
