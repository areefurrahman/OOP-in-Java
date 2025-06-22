import java.util.Scanner;
import java.util.ArrayList;

public class Lab_3_task_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int level;
        ArrayList<Integer> Brightness_Levels = new ArrayList<>();

        System.out.println("Enter the Brightness levels");
        for (int i = 0; i < 5; i++) {
            System.out.println("Light " + (i + 1) + ": ");
            level = input.nextInt();

            Brightness_Levels.add(level);
        }


        System.out.println("Brightness levels");
        for (int i : Brightness_Levels) {
            System.out.println(i + "%");
        }


        System.out.println("Enter the light number: ");
        int light_number = input.nextInt();

        System.out.println("Enter the new  brightness level: ");
        int new_light_level = input.nextInt();

        Brightness_Levels.add(light_number - 1, new_light_level);
        Brightness_Levels.remove(light_number);

        System.out.println("New Brightness levels");
        for (int i : Brightness_Levels) {
            System.out.println(i + "%");
        }

    }
}