public class Lab_3_task_4 {
    public static void main(String[] args) {
        // Create a string to represent the smart light's mode
        String mode = "Energy Saving Mode";

        System.out.println("Length of mode: " + mode.length());

        System.out.println("Mode in uppercase: " + mode.toUpperCase());

        System.out.println("Mode in lowercase: " + mode.toLowerCase());

        System.out.println("Character at index 5: " + mode.charAt(5));

        System.out.println("Index of 'Saving': " + mode.indexOf("Saving"));

        String updatedMode = mode.replace("Saving", "Efficiency");
        System.out.println("Updated Mode: " + updatedMode);

        System.out.println("Substring (first 6 characters): " + mode.substring(0, 6));
    }
}
