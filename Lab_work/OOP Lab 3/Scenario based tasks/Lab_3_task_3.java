import java.util.Scanner;
import java.util.ArrayList;

public class Lab_3_task_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String mode1 = "Energy Saving Mode";
        String mode3 = "Day time";


        System.out.println("Current Mode: " + mode1);
        String update_mode = mode1 + " Night time";

        System.out.println("Update mode: " + update_mode);
        mode1.concat(mode3);

        System.out.println("After the use concatinate function: " + mode1);
    }
}