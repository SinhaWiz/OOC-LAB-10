//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        DeviceManager deviceManager=new DeviceManager();
        Light l1= new Light();
        l1.setLocation("Living Room");
        l1.setColor("Amber");
        l1.adjustPowerLevel(12);
        l1.adjustPowerLevel(25);
        Light l2= new Light();
        l2.setLocation("Kitchen");
        l2.setColor("CoolWhite");
        l2.adjustPowerLevel(14);
        AirConditioner a1 = new AirConditioner();
        a1.setLocation("Dining Room");
        AirConditioner a2 = new AirConditioner();
        l2.setColor("Rest Room");
        deviceManager.addDevice(l1);
        deviceManager.addDevice(l2);
        deviceManager.addDevice(a1);
        deviceManager.addDevice(a2);
    }
}