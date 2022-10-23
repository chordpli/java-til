package array;

public class ThreeDimensionArray {
    public static void main(String[] args) {
        int[][][] intArr = {
                {   // [0][][]
                        {1, 3},   // [0][0][]
                        {5, 6, 7, 8},   // [0][1][]
                        {9, 10, 11, 12} // [0][2][]
                },
                {   // [1][][]
                        {13, 14, 15, 16},   // [1][0][]
                        {17, 18, 19 },   // [1][1][]
                        {21, 22, 23, 24}    // [1][2][]
                }

        };

        System.out.println(intArr[0][0][1]); // 2
        System.out.println(intArr[0][1][2]); // 8
        System.out.println(intArr[1][2][1]); // 22
        System.out.println(intArr[1][0][3]); // 16

        for (int[][] i : intArr) {
            for(int[] j : i){
                for (int z : j) {
                    System.out.println(z);
                }
            }
        }

        for(int i = 0; i < intArr.length; i++){
            for (int j = 0; j < intArr[i].length; j++) {        // 해당 자리의 길이를 알아내줘야한다.
                for (int z = 0; z < intArr[i][j].length; z++) { // 해당 자리의 길이를 알아내줘야한다.
                    System.out.print(intArr[i][j][z] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
