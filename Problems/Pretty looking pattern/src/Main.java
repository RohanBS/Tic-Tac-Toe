import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[][] c = new char[4][4];
        for (int i = 0; i < 4; i++) {
            c[i] = s.next().toCharArray();
        }
        boolean pretty = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (c[i][j] == c[i][j + 1] &&
                        c[i][j] == c[i + 1][j] &&
                        c[i][j] == c[i + 1][j + 1]) {
                    pretty = false;
                }
            }
        }
        System.out.println(pretty ? "YES" : "NO");
    }
}