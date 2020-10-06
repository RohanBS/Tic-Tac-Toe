package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String inp = new Scanner(System.in).nextLine();
        String[][] map = new String[3][3];
        int xWins = 0;
        int oWins = 0;
        int xs = 0;
        int os = 0;
        int lineSum = 0;

        for (int row = 0; row < 3; row++) {   // reading input & filling the field
            for (int col = 0; col < 3; col++) {
                map[row][col] = String.valueOf(inp.charAt(3 * row + col));
            }
        }

        for (String[] i : map) {        // analysing rows
            for (String j : i) {
                xs = j.charAt(0) == 88 ? xs + 1 : xs;
                os = j.charAt(0) == 79 ? os + 1 : os;
                lineSum += j.charAt(0);
            }
            xWins = lineSum == 264 ? xWins + 1 : xWins;
            oWins = lineSum == 237 ? oWins + 1 : oWins;
            lineSum = 0;
        }

        for (int ver = 0; ver < 3; ver++) {     // analysing columns
            for (int hor = 0; hor < 3; hor++) {
                lineSum += map[hor][ver].charAt(0);
            }
            xWins = lineSum == 264 ? xWins + 1 : xWins;
            oWins = lineSum == 237 ? oWins + 1 : oWins;
            lineSum = 0;
        }

        lineSum = map[0][0].charAt(0) + map[1][1].charAt(0) + map[2][2].charAt(0); // looking at diagonals
        xWins = lineSum == 264 ? xWins + 1 : xWins;
        oWins = lineSum == 237 ? oWins + 1 : oWins;
        lineSum = map[0][2].charAt(0) + map[1][1].charAt(0) + map[2][0].charAt(0);
        xWins = lineSum == 264 ? xWins + 1 : xWins;
        oWins = lineSum == 237 ? oWins + 1 : oWins;

        System.out.println("---------");
        for (String[] g : map) {
            System.out.printf("| %s %s %s |\n", g[0], g[1], g[2]);
        }
        System.out.println("---------");

        while(true) {
            if (xWins + oWins > 1 || xs - os > 1 || os - xs > 1) {
                System.out.println("Impossible");
                break;
            } else if (xWins == 0 && oWins == 0 && xs + os < 9){
                System.out.println("Game not finished");
                break;
            } else if (xWins == 0 && oWins == 0 && xs + os == 9) {
                System.out.println("Draw");
                break;
            } else if (xWins == 1) {
                System.out.println("X wins");
                break;
            } else {
                System.out.println("O wins");
                break;
            }
        }
    }
}
