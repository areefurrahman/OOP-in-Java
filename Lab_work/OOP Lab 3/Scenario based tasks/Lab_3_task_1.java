import java.util.Scanner;

public class Lab_3_task_1 {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
        int[] B_level = {17, 34, 26, 64, 14};

        System.out.println("Brightness levels");
        for (int i : B_level) {
            System.out.println(i + "%");
        }

        System.out.println("Enter the light number: ");
        int light_number = input.nextInt();

        System.out.println("Enter the new  brightness level: ");
        int new_light_level = input.nextInt();

        B_level[light_number-1] = new_light_level;

        System.out.println("New Brightness levels");
        for (int i : B_level) {
            System.out.println(i + "%");
        }

    }
}