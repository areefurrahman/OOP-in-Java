import java.util.Scanner;

public class BrightnessAdjuster_task_6 {

    public static void adjustBrightness(int brightnessLevel) {
        System.out.println("Adjusting brightness by: " + brightnessLevel + "% units");
    }

    public static void adjustBrightness(double brightnessLevel) {
        System.out.println("Adjusting brightness by: " + brightnessLevel + "% units");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the brightness level (integer type): ");
        int brightnessLevelInt = scanner.nextInt();

        System.out.print("Enter the brightness level (double type): ");
        double brightnessLevelDouble = scanner.nextDouble();

        adjustBrightness(brightnessLevelInt);
        adjustBrightness(brightnessLevelDouble);

        scanner.close();
    }
}
