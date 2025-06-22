class IntelligentLamp {
    private String lampName;
    private boolean powerStatus;
    private int lightLevel;

    public IntelligentLamp() {
        lampName = "Living Room Lamp";
        powerStatus = false;
        lightLevel = 75;
    }

    public void setLampName(String lampName) {
        this.lampName = lampName;
    }

    public void setPowerStatus(boolean powerStatus) {
        this.powerStatus = powerStatus;
    }

    public void setLightLevel(int level) {
        if (level <= 100 && level >= 0) {
            this.lightLevel = level;
        } else if (level < 0) {
            this.lightLevel = 0;
        } else {
            this.lightLevel = 100;
        }
    }

    public void setLightLevel(String level) {
        if (level.equals("low")) {
            this.lightLevel = 25;
            System.out.println("Brightness set to " + this.lightLevel + " based on level: " + level);
        } else if (level.equals("medium")) {
            this.lightLevel = 50;
            System.out.println("Brightness set to " + this.lightLevel + " based on level: " + level);
        } else {
            this.lightLevel = 75;
            System.out.println("Brightness set to 75 based on level: high");
        }
    }

    String getLampName() {
        return lampName;
    }

    boolean getPowerStatus() {
        return powerStatus;
    }

    int getLightLevel() {
        return lightLevel;
    }

    void powerOn() {
        this.powerStatus = true;
        this.lightLevel = 75;
        System.out.println(this.lampName + " is now ON");
        System.out.println("Brightness set to " + this.lightLevel);
    }

    void powerOff() {
        this.powerStatus = false;
        System.out.println(this.lampName + " is now OFF");
    }

    void showStatus() {
        if (powerStatus) {
            System.out.println(lampName + " is ON with Brightness level: " + this.lightLevel);
        } else {
            System.out.println(lampName + " is OFF with Brightness level: " + this.lightLevel);
        }
    }
}

public class TaskSix {
    public static void main(String[] args) {
        IntelligentLamp lamp = new IntelligentLamp();
        lamp.powerOn();
        lamp.showStatus();
        lamp.powerOff();
        lamp.showStatus();
        lamp.setLampName("Default Lamp");
        lamp.setLightLevel(0);
        lamp.setPowerStatus(false);
        lamp.showStatus();
        lamp.setLampName("Kitchen Lamp");
        lamp.setPowerStatus(false);
        lamp.setLightLevel(0);
        lamp.showStatus();
        lamp.setLampName("Bedroom Lamp");
        lamp.setPowerStatus(true);
        lamp.setLightLevel(50);
        lamp.showStatus();
        lamp.setLampName("Living Room Lamp");
        lamp.setPowerStatus(true);
        lamp.setLightLevel("medium");
        lamp.showStatus();
    }
}
