public class EnergySaver_task_7 {

    static boolean isEnergySavingMode;

    static void checkEnergyMode(boolean mode) {
        isEnergySavingMode = mode;
        if (isEnergySavingMode) {
            System.out.println("Energy-saving mode is enabled.");
        } else {
            System.out.println("Energy-saving mode is disabled.");
        }
    }

    public static void main(String[] args) {
        checkEnergyMode(true);
        checkEnergyMode(false);
    }
}
