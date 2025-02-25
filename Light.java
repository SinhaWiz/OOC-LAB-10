public class Light implements PoweredDevice, LightSettings {
    private String location;
    private boolean isOn;
    private int intensity;
    private String color;
    private double powerConsumption;

    @Override
    public void turnOn() {
        isOn = true;
    }
    @Override
    public void turnOff() {
        isOn = false;
    }
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
        intensity = (int) (level * 4.0);
        updatePowerConsumption();
    }

    @Override
    public double getCurrentPowerConsumption() {
        return powerConsumption;
    }

    private void updatePowerConsumption() {
        if(color.equals("CoolWhite")){
            powerConsumption = intensity * 1.0;
        }
        else{
            powerConsumption = intensity * 0.8;
        }
    }

    @Override
    public void setIntensity(int lux) {
        intensity = lux;
        updatePowerConsumption();
    }

    @Override
    public void setColor(String color) {
        this.color = color;
        updatePowerConsumption();
    }
}

