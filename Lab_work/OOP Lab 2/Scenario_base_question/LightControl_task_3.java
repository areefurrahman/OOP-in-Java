import java.util.Scanner;

public class LightControl_task_3 {

    public static void main(String[] args) {
        int lightLevel;
        boolean isLightOn = false;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the light level between (1 to 100): ");
        lightLevel = scanner.nextInt();

        if (lightLevel > 0 && lightLevel < 100) {
            isLightOn = true;
        }

        if (isLightOn) {
            System.out.println("The light is: ON");
        } else {
            System.out.println("The light is: OFF");
        }

        scanner.close();
    }
}
