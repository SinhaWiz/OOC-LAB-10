public class SecurityAlarm implements SecurityDevice, SecurityAlarmSettings, Notifiable {
    private String location;
    private boolean isActive;
    private String password;
    private NotificationListener listener;

    @Override
    public void turnOn() {
        activate();
    }
    @Override
    public void turnOff() {
        deactivate();
    }
    @Override
    public String getLocation() {
        return location;
    }
    @Override
    public void setLocation(String location) {
        this.location = location; }

    @Override
    public void activate() {
        isActive = true;
    }
    @Override
    public void deactivate() {
        isActive = false;
    }


    public boolean verifyPassword(String input) {
        boolean correct = input.equals(password);
        if (listener != null) {
            String message = correct ? "Correct password entered" : "Incorrect password";
            listener.onNotification(this, message);
        }
        return correct;
    }


    public void setPassword(String newPassword) {
        password = newPassword;
    }
    @Override
    public void setNotificationListener(NotificationListener listener) { this.listener = listener; }

    @Override
    public void setHumidityMeasurementUnit(String unit) {

    }

    @Override
    public void setNotificationEnabled(boolean enabled) {

    }
}