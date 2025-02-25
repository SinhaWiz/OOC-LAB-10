public interface PoweredDevice extends Device {

    void adjustPowerLevel(int level);

    double getCurrentPowerConsumption();

}