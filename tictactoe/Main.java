package tictactoe;

import java.util.Scanner;

public class Main {
    static String[] chars = new String[9];
    static boolean isXWin = false;
    static boolean isOWin = false;
    static boolean isGameFinished = false;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        start();
        middleGame();
//        end();
    }

    private static void start() {
        System.out.print("Enter 9 cells (X, O or _): ");
        String input = scanner.nextLine();
        init(input);
        printField(chars);
    }

    private static void end() {
        printField(chars);
        stateOfGame(chars);
    }

    private static void middleGame() {
        int index = -1;
        System.out.print("Enter the coordinates: ");
        String[] input = scanner.nextLine().trim().split("\\s+");
        if (input.length != 2) {
            System.out.println("You should enter numbers!");
            middleGame();
            return;
        }

        try {
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            if (x < 1 || x > 3 || y < 1 || y > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                middleGame();
                return;
            } else {
                index = 3 * (3 - y) + x - 1;
            }
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            middleGame();
            return;
        }

        if (index == -1) {
            System.out.println("Error");
            return;
        }

        if (chars[index].equals("X") || chars[index].equals("O")) {
            System.out.println("This cell is occupied! Choose another one!");
            middleGame();
            return;
        } else {
            chars[index] = "X";
        }

        printField(chars);
    }

    private static void init(String input) {
        for (int i = 0; i < 9; i++) {
            chars[i] = String.valueOf(input.charAt(i));
        }
    }

    private static void printField(String[] chars) {
        int index = 0;

        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(chars[index] + " ");
                index++;
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private static void stateOfGame(String[] chars) {
        String horizontal1 = chars[0] + chars[1] + chars[2];
        String horizontal2 = chars[3] + chars[4] + chars[5];
        String horizontal3 = chars[6] + chars[7] + chars[8];
        String vertical1 = chars[0] + chars[3] + chars[6];
        String vertical2 = chars[1] + chars[4] + chars[7];
        String vertical3 = chars[2] + chars[5] + chars[8];
        String diagonal1 = chars[0] + chars[4] + chars[8];
        String diagonal2 = chars[2] + chars[4] + chars[6];

        if (horizontal1.equals("XXX") || horizontal2.equals("XXX") || horizontal3.equals("XXX")
                || vertical1.equals("XXX") || vertical2.equals("XXX") || vertical3.equals("XXX")
                || diagonal1.equals("XXX") || diagonal2.equals("XXX"))  {
            isXWin = true;
        }

        if (horizontal1.equals("OOO") || horizontal2.equals("OOO") || horizontal3.equals("OOO")
                || vertical1.equals("OOO") || vertical2.equals("OOO") || vertical3.equals("OOO")
                || diagonal1.equals("OOO") || diagonal2.equals("OOO"))  {
            isOWin = true;
        }

        if (!chars.equals(" ") && !chars.equals("_")) {
            isGameFinished = true;
        }

        if (isGameImpossible(chars)) {
            System.out.println("Impossible");
            return;
        }

        if (isOWin) {
            System.out.println("O wins");
            return;
        }

        if (isXWin) {
            System.out.println("X wins");
            return;
        }

        if (!isGameFinished) {
            System.out.println("Game not finished");
            return;
        }

        System.out.println("Draw");
    }

    private static boolean isGameImpossible(String[] chars) {
        boolean isItImpossible = false;
        int countX = 0;
        int countO = 0;

        for (int i = 0; i < 9; i++) {
            if (chars[i].equals("X")) {
                countX++;
            }
            if (chars[i].equals("O")) {
                countO++;
            }
        }

        if (isOWin && isXWin || Math.abs(countO - countX) > 1) {
            isItImpossible = true;
        }
        return isItImpossible;
    }
}
