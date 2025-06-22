class HomeAutomationDevice {
    String deviceName;
    boolean powerStatus;
    int lightIntensity;

    public HomeAutomationDevice() {
        deviceName = "Living Room Lamp";
        powerStatus = false;
        lightIntensity = 0;
    }

    public HomeAutomationDevice(String deviceName) {
        this.deviceName = deviceName;
        powerStatus = false;
        lightIntensity = 0;
    }

    public HomeAutomationDevice(String deviceName, boolean powerStatus, int intensity) {
        this.deviceName = deviceName;
        this.powerStatus = powerStatus;
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
            System.out.println(deviceName + " is now ON");
            System.out.println("Brightness Level: " + this.lightIntensity);
        } else {
            System.out.println(deviceName + " is now OFF");
        }
    }
}

public class TaskThree {
    public static void main(String[] args) {
        HomeAutomationDevice livingRoomLamp = new HomeAutomationDevice();
        livingRoomLamp.showDeviceStatus();

        HomeAutomationDevice livingRoomLamp1 = new HomeAutomationDevice("Living Room Lamp");
        livingRoomLamp1.showDeviceStatus();

        HomeAutomationDevice kitchenLamp = new HomeAutomationDevice("Kitchen Lamp", true, 75);
        kitchenLamp.showDeviceStatus();
    }
}
