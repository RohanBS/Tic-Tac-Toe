import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int[][] matrix = new Scanner(System.in).useDelimiter("\n").tokens()
                .takeWhile(line -> !"end".equals(line))
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toArray(int[][]::new);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int sum = matrix[i - 1 < 0 ? matrix.length - 1 : i - 1][j] +
                        matrix[i + 1 == matrix.length ? 0 : i + 1][j] +
                        matrix[i][j - 1 < 0 ? matrix[i].length - 1 : j - 1] +
                        matrix[i][j + 1 == matrix[i].length ? 0 : j + 1];
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}