import java.util.Scanner;
import java.util.ArrayList;

public class Lab_3_task_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Part A: Static Array
        System.out.println("=== Part A: Static Array ===");
        int[] B_level = {17, 34, 26, 64, 14};

        System.out.println("Brightness levels:");
        for (int i : B_level) {
            System.out.println(i + "%");
        }

        System.out.println("Enter the light number to modify (1-5): ");
        int light_number = input.nextInt();

        System.out.println("Enter the new brightness level (0-100): ");
        int new_light_level = input.nextInt();

        // Validate the new brightness level
        if (new_light_level < 0) {
            new_light_level = 0;
        } else if (new_light_level > 100) {
            new_light_level = 100;
            System.out.println("Value exceeds 100. Setting to 100.");
        }

        B_level[light_number - 1] = new_light_level;

        System.out.println("New Brightness levels:");
        for (int i : B_level) {
            System.out.println(i + "%");
        }

        System.out.println("\n=== Part B: Dynamic Array - ArrayList ===");
        ArrayList<Integer> brightnessList = new ArrayList<>();
        for (int level : B_level) {
            brightnessList.add(level);
        }

        System.out.println("Brightness levels from ArrayList:");
        for (int i : brightnessList) {
            System.out.println(i + "%");
        }

        System.out.println("Do you want to modify or remove a brightness level? (yes/no)");
        String response = input.next();

        while (response.equalsIgnoreCase("yes")) {
            System.out.println("Enter the light number to modify (1-" + brightnessList.size() + "): ");
            light_number = input.nextInt();

            System.out.println("Enter the new brightness level (0-100): ");
            new_light_level = input.nextInt();

            if (new_light_level < 0) {
                new_light_level = 0;
            } else if (new_light_level > 100) {
                new_light_level = 100;
                System.out.println("Value exceeds 100. Setting to 100.");
            }

            brightnessList.set(light_number - 1, new_light_level);

            System.out.println("Updated Brightness levels from ArrayList:");
            for (int i : brightnessList) {
                System.out.println(i + "%");
            }

            System.out.println("Do you want to modify another brightness level? (yes/no)");
            response = input.next();
        }


        System.out.println("\n=== Part C: String Operations ===");
        String mode = "Energy Saving Mode";

        System.out.println("Current Mode: " + mode);
        System.out.println("Length of mode: " + mode.length());
        System.out.println("Mode in uppercase: " + mode.toUpperCase());
        System.out.println("Mode in lowercase: " + mode.toLowerCase());
        System.out.println("Character at index 5: " + mode.charAt(5));
        System.out.println("Index of 'Saving': " + mode.indexOf("Saving"));
        String updatedMode = mode.replace("Saving", "Efficiency");
        System.out.println("Updated Mode: " + updatedMode);
        System.out.println("Substring (first 6 characters): " + mode.substring(0, 6));


        System.out.println("\n=== Part D: Final Output ===");
        System.out.println("Final Brightness levels:");
        for (int brightness : brightnessList) {
            System.out.println(brightness + "%");
        }
        System.out.println("Current Mode: " + updatedMode);
        System.out.println("Smart Light Controller is successfully configured.");

        input.close();
    }
}
