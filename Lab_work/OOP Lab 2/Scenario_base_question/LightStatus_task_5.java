
public class LightStatus_task_5 {

    public static void displayLightStatus(boolean isLightOn) {
        if (isLightOn) {
            System.out.println("The Light is: ON");
        } else {
            System.out.println("The Light is: OFF");
        }
    }

    public static void main(String[] args) {
        displayLightStatus(true);
        displayLightStatus(false);
    }
}
