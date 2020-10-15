import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] matrix = new String[n][n];

        int mid = n / 2 + 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == mid - 1 || j == mid - 1 || i == j || i + j == n - 1) {
                    matrix[i][j] = "*";
                } else {
                    matrix[i][j] = ".";
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}