import java.util.Scanner;

public class BrightnessAdjuster_task_2 {

    public static int adjustBrightness(int currentBrightness, int adjustment) {
        currentBrightness += adjustment;

        if (currentBrightness < 0) {
            currentBrightness = 0;
        } else if (currentBrightness > 100) {
            currentBrightness = 100;
        }

        return currentBrightness;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int brightnessLevel, brightnessAdjustment;

        System.out.print("Enter the brightness level (0-100): ");
        brightnessLevel = scanner.nextInt();

        if (brightnessLevel < 0 || brightnessLevel > 100) {
            System.out.println("Brightness level must be between 0 and 100.");
            scanner.close();
            return;
        }

        System.out.print("Enter the adjustment value: ");
        brightnessAdjustment = scanner.nextInt();

        brightnessLevel = adjustBrightness(brightnessLevel, brightnessAdjustment);

        if (brightnessAdjustment > 0) {
            System.out.println("The brightness increased to: " + brightnessLevel + "%");
        } else if (brightnessAdjustment < 0) {
            System.out.println("The brightness decreased to: " + brightnessLevel + "%");
        } else {
            System.out.println("Brightness remains at: " + brightnessLevel + "%");
        }

        scanner.close();
    }
}
