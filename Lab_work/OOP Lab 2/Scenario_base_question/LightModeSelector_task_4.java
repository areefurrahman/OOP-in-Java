import java.util.Scanner;

public class LightModeSelector_task_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mode;

        System.out.println("1 for Normal Mode");
        System.out.println("2 for Reading Mode");
        System.out.println("3 for Night Mode");
        System.out.print("Enter a number (1, 2, or 3): ");
        mode = scanner.nextInt();

        switch (mode) {
            case 1:
                System.out.println("The light is in Normal Mode.");
                break;
            case 2:
                System.out.println("The light is in Reading Mode.");
                break;
            case 3:
                System.out.println("The light is in Night Mode.");
                break;
            default:
                System.out.println("Please choose a valid option: 1, 2, or 3.");
        }

        scanner.close();
    }
}
