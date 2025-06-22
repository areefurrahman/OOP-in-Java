class SmartLight {
    private String lightName;
    private boolean lightState;

    public SmartLight(String lightName) {
        this.lightName = lightName;
        this.lightState = false;
    }

    public void switchOn() {
        lightState = true;
    }

    public void switchOff() {
        lightState = false;
    }

    public String getLightStatus() {
        return lightState ? "On" : "Off";
    }

    public String getLightName() {
        return lightName;
    }
}

class SmartHomeController {
    private SmartLight[] smartLights;

    public SmartLight controlLight(SmartLight singleLight) {
        System.out.println("Initial Light status: " + singleLight.getLightStatus());
        singleLight.switchOn();
        return singleLight;
    }

    public void setupLights() {
        smartLights = new SmartLight[5];
        smartLights[0] = new SmartLight("Kitchen Light");
        smartLights[1] = new SmartLight("Bedroom Light");
        smartLights[2] = new SmartLight("Living Room Light");
        smartLights[3] = new SmartLight("Bathroom Light");
        smartLights[4] = new SmartLight("Garage Light");
    }

    public void switchAllLightsOn() {
        for (SmartLight light : smartLights) {
            light.switchOn();
        }
    }

    public void displayAllLightsStatus() {
        for (SmartLight light : smartLights) {
            System.out.println(light.getLightName() + " status: " + light.getLightStatus());
        }
    }
}

public class Scenario_based {
    public static void main(String[] args) {
        SmartHomeController homeController = new SmartHomeController();

        SmartLight livingRoomLight = new SmartLight("Living Room Light");
        SmartLight updatedLight = homeController.controlLight(livingRoomLight);
        System.out.println("After operation: " + updatedLight.getLightStatus());

        homeController.setupLights();
        System.out.println("\nInitial statuses of all lights:");
        homeController.displayAllLightsStatus();

        homeController.switchAllLightsOn();
        System.out.println("\nStatuses of all lights after turning them on:");
        homeController.displayAllLightsStatus();
    }
}
