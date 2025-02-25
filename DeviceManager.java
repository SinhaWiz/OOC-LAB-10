import java.util.HashMap;
import java.util.Map;

public class DeviceManager implements NotificationListener {
    private Map<String, Device> devices = new HashMap<>();

    public void addDevice(Device device) {
        String location = device.getLocation();
        if (devices.containsKey(location))
            throw new IllegalArgumentException("Device location already exists");
        devices.put(location, device);
        if (device instanceof Notifiable)
            ((Notifiable) device).setNotificationListener(this);
    }

    public void removeDevice(String location) {
        devices.remove(location);
    }

    public void turnOnDevice(String location) {
        Device device = devices.get(location);
        if (device != null)
            device.turnOn();
    }

    public void turnOffDevice(String location) {
        Device device = devices.get(location);
        if (device != null) device.turnOff();
    }

    public void adjustPowerLevel(String location, int level) {
        Device device = devices.get(location);
        if (device instanceof PoweredDevice)
            ((PoweredDevice) device).adjustPowerLevel(level);
        else
            throw new UnsupportedOperationException("Device does not support power level adjustment");
    }

    public void setLightIntensity(String location, int lux) {
        Device device = devices.get(location);
        if (device instanceof LightSettings)
            ((LightSettings) device).setIntensity(lux);
        else
            throw new UnsupportedOperationException("Device is not a light");
    }


    @Override
    public void onNotification(Device device, String message) {
        System.out.println("Notification from " + device.getLocation() + ": " + message);
    }
}
