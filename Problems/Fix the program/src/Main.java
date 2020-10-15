import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int a = scanner.nextInt(); 
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        sum = a + b + c;

        System.out.println(sum); 
    }
}