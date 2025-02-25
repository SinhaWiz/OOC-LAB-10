public class SmokeDetector implements SensoryDevice, SmokeDetectorSettings, Notifiable {
    private String location;
    private boolean isSprinkleActive;
    private boolean notificationsEnabled;
    private NotificationListener listener;
    private int sensitivity;

    @Override
    public void turnOn() {
        activateSprinkle();
        isSprinkleActive = true;

    }
    @Override
    public void turnOff() {
        deactivateSprinkle();
        isSprinkleActive = false;
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
    public void setSensitivity(int level) {
        if (level < 1 || level > 10) {
            throw new IllegalArgumentException("Sensitivity must be between 1-10");
        }
        sensitivity = level;
    }

    @Override
    public int getSensitivity() {
        return sensitivity;
    }

    @Override
    public void activateSprinkle() {
        isSprinkleActive = true;
        if (notificationsEnabled && listener != null)
            listener.onNotification(this, "Sprinkle activated");
    }

    @Override
    public void deactivateSprinkle() {
        isSprinkleActive = false;
    }

    @Override
    public void setNotificationEnabled(boolean enabled) {
        notificationsEnabled = enabled;
    }

    @Override
    public void setNotificationListener(NotificationListener listener) {
        this.listener = listener;
    }
}
