public class BrightnessAndLightChecker_task_8 {

    static int brightnessLevel;
    static boolean isLightOn;

    static void checkBrightnessAndLightStatus(int brightness, boolean mode) {
        brightnessLevel = brightness;
        isLightOn = mode;
        System.out.println("Light status: " + isLightOn + ", Brightness level: " + brightnessLevel + "%");
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            checkBrightnessAndLightStatus(75, true);
        } else {
            System.out.println("Argument length is too high.");
        }
    }
}
