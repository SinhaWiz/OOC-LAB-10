public class AirConditioner implements PoweredDevice, AirConditionerSettings {
    private String location;
    private boolean isOn;
    private String fanSpeed = "low";
    private int temperature = 20;
    private double powerConsumption;

    @Override
    public void turnOn() {
        isOn = true;
    }
    @Override
    public void turnOff() {
        isOn = false; }
    @Override
    public String getLocation() {
        return location;
    }
    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void adjustPowerLevel(int level) {
        fanSpeed = level > 50 ? "high" : "low";
        temperature = 18 + (level / 10);
        updatePowerConsumption();
    }

    @Override
    public double getCurrentPowerConsumption() {
        return powerConsumption; }

    private void updatePowerConsumption() {
        if(fanSpeed.equals("high")){
            powerConsumption =1500;
        }
        else {
            powerConsumption = 1000;
        }
    }

    @Override
    public void setFanSpeed(String speed) {
        fanSpeed = speed;
        updatePowerConsumption();
    }

    @Override
    public void setTemperature(int temp) {
        if (temp < 18 || temp > 25){
            throw new IllegalArgumentException("Temperature must be between 18 and 25");
        }
        else {
            temperature = temp;
            updatePowerConsumption();
        }
    }
}
