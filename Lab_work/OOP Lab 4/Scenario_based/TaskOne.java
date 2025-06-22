class IntelligentLamp {
    String lampName;
    boolean powerStatus;
    int lightLevel;

    public IntelligentLamp() {
        lampName = "Living Room Lamp";
        powerStatus = false;
        lightLevel = 0;
    }

    void powerOn() {
        powerStatus = true;
    }

    void powerOff() {
        powerStatus = false;
    }

    void adjustBrightness(int brightnessLevel) {
        if (brightnessLevel <= 100 && brightnessLevel >= 0) {
            this.lightLevel = brightnessLevel;
        } else if (brightnessLevel < 0) {
            this.lightLevel = 0;
        } else {
            this.lightLevel = 100;
        }
    }

    void showStatus() {
        if (powerStatus) {
            System.out.println("Living Room Lamp is now ON");
            System.out.println("Brightness Level: " + this.lightLevel);
        } else {
            System.out.println("Living Room Lamp is now OFF");
        }
    }
}

public class TaskOne {
    public static void main(String[] args) {
        IntelligentLamp livingRoomLamp = new IntelligentLamp();
        livingRoomLamp.showStatus();
        livingRoomLamp.powerOn();
        livingRoomLamp.adjustBrightness(75);
        livingRoomLamp.showStatus();
        livingRoomLamp.powerOff();
        livingRoomLamp.showStatus();
    }
}
