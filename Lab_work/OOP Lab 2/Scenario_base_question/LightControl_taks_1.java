import java.util.Scanner;

public class LightControl_taks_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int brightnessLevel;
        boolean isLightOn = false;

        System.out.print("Enter the brightness level: ");
        brightnessLevel = scanner.nextInt();

        if (brightnessLevel >= 0 && brightnessLevel <= 100) {
            isLightOn = true;
        }

        if (isLightOn) {
            System.out.println("Light Status: ON");
            System.out.println("Brightness Level: " + brightnessLevel);
        } else {
            System.out.println("Light Status: OFF");
            System.out.println("Brightness Level: " + brightnessLevel);
        }

        scanner.close();
    }
}
