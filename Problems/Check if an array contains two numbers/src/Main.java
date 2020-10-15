import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < num; i++) {
            if (i != num - 1) {
                if (arr[i] == n && arr[i + 1] == m ||
                        arr[i] == m && arr[i + 1] == n) {
                    found = true;
                    break;
                }
            } else if (arr[i] == n && arr[i - 1] == m ||
                    arr[i] == m && arr[i - 1] == n) {
                found = true;
                break;
            }
        }
        System.out.println(found);
    }
}