import java.util.*;

public class Main {
    public static boolean isValidSudoku(int[][] board, int n) {
        int length = board.length;
        for (int i=0; i< length; i++) {
            boolean checkRow[] = new boolean[length];
            boolean checkCol[] = new boolean[length];

            for (int j=0; j<board.length; j++) {
                if (board[i][j] != '.') {
                    //check row
                    if (checkRow[board[i][j] - 1]) {
                        return false;
                    }
                    else {
                        checkRow[board[i][j] - 1] = true;
                    }
                }

                if (board[j][i] != '.') {
                    //check col
                    if (checkCol[board[j][i] - 1]) {
                        return false;
                    }
                    else {
                        checkCol[board[j][i] - 1] = true;
                    }
                }
            }
        }

        for (int i = 0; i < length; i += n) {
            for (int j = 0; j < length; j += n) {
                boolean check3x3[] = new boolean[length];
                for (int k = i; k < i + n; k++) {
                    for (int l = j; l < j + n; l++) {
                        if (check3x3[board[k][l] - 1]) {
                            return false;
                        }
                        else {
                            check3x3[board[k][l] - 1] = true;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int length = n * n;
        int[][] matrix = new int[length][length];
        char[][] matrix1 = new char[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        if (isValidSudoku(matrix, n)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }




















//    public static boolean isSudokuValid(int[][] board, int n) {
//        if (board == null || board.length == 0)
//            return true;
//        int rowlen = board.length, collen = board[0].length;
//        Set<Integer> digits = new HashSet<>();
//        for (int i = 1; i <= n * n; i++) {
//            digits.add(i);
//        }
//        for (int i = 0;i < rowlen; i++) {
//            Set<Integer> rowSet = new HashSet<>();
//            Set<Integer> colSet = new HashSet<>();
//            Set<Integer> gridSet = new HashSet<>();
//            for(int j = 0; j < collen; j++) {
//                if (!rowSet.add(board[i][j]))
//                    return false;
//                if (!colSet.add(board[j][i]))
//                    return false;
//                int RowIndex = n * (i / n);
//                int ColIndex = n * (i % n);
//                if(!gridSet.add(board[RowIndex + j / n][ColIndex + j % n])
//                        && digits.containsAll(rowSet)
//                        && digits.containsAll(colSet)
//                        && digits.containsAll(gridSet))
//                    return false;
//            }
//        }
//
//        return true;
//
//    }
}
