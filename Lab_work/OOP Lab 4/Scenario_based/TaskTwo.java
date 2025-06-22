class HomeAutomationSystem {
    String deviceName;
    boolean powerStatus;
    int lightIntensity;

    public HomeAutomationSystem() {
        deviceName = "Living Room Lamp";
        powerStatus = false;
        lightIntensity = 0;
    }

    void powerOn() {
        powerStatus = true;
    }

    void powerOff() {
        powerStatus = false;
    }

    void adjustLightIntensity(int intensity) {
        if (intensity <= 100 && intensity >= 0) {
            this.lightIntensity = intensity;
        } else if (intensity < 0) {
            this.lightIntensity = 0;
        } else {
            this.lightIntensity = 100;
        }
    }

    void showDeviceStatus() {
        if (powerStatus) {
            System.out.println("Living Room Lamp is now ON");
            System.out.println("Brightness Level: " + this.lightIntensity);
        } else {
            System.out.println("Living Room Lamp is now OFF");
        }
    }
}

public class TaskTwo {
    public static void main(String[] args) {
        HomeAutomationSystem livingRoomLamp = new HomeAutomationSystem();
        livingRoomLamp.showDeviceStatus();
        livingRoomLamp.powerOn();
        livingRoomLamp.adjustLightIntensity(75);
        livingRoomLamp.showDeviceStatus();
        livingRoomLamp.powerOff();
        livingRoomLamp.showDeviceStatus();
    }
}
