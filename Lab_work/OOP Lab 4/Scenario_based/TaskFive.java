class IntelligentLamp {
    private String lampName;
    private boolean powerStatus;
    private int lightLevel;
    private String color;

    public IntelligentLamp() {
        lampName = "Living Room Lamp";
        powerStatus = false;
        lightLevel = 10;
        color = "Red";
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
            System.out.println(this.lampName + " Brightness set to " + this.lightLevel + " based on level: " + level);
        } else if (level.equals("medium")) {
            this.lightLevel = 50;
            System.out.println(this.lampName + " Brightness set to " + this.lightLevel + " based on level: " + level);
        } else {
            this.lightLevel = 75;
            System.out.println(this.lampName + " Brightness set to 75 based on level: high");
        }
    }

    public void setColor(String color) {
        this.color = color;
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

    String getColor() {
        return color;
    }

    void powerOn() {
        this.powerStatus = true;
    }

    void powerOff() {
        this.powerStatus = false;
    }

    void showStatus() {
        System.out.println("Lamp Name: " + lampName);
        if (powerStatus) {
            System.out.println(lampName + " is now ON");
            System.out.println("Brightness Level: " + this.lightLevel);
        } else {
            System.out.println(lampName + " is now OFF");
        }
        System.out.println("Lamp Color: " + color);
    }
}

public class TaskFive {
    public static void main(String[] args) {
        IntelligentLamp lamp = new IntelligentLamp();
        lamp.powerOn();
        lamp.showStatus();
        lamp.powerOff();
        lamp.showStatus();
        lamp.setLampName("Kitchen Lamp");
        lamp.setPowerStatus(true);
        lamp.setLightLevel(65);
        lamp.setColor("Green");
        lamp.showStatus();
        lamp.setLampName("Bedroom Lamp");
        lamp.setPowerStatus(true);
        lamp.setLightLevel("low");
        lamp.setColor("Blue");
        lamp.showStatus();
    }
}
