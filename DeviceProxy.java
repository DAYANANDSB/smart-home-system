//  access to a Device
public class DeviceProxy {
    private Device device; 
    private boolean hasPermission; 

    public DeviceProxy(Device device) {
        this.device = device;
        this.hasPermission = true; 
    }

    // turns on the device if permission is given
    public void turnOn(boolean withPermission) {
        if (withPermission && hasPermission) {
            device.turnOn(); 
            System.out.println("Device with ID " + device.getId() + " has been turned on via proxy.");
        } else {
            System.out.println("Permission denied. Cannot turn on device with ID " + device.getId() + ".");
        }
    }

    // turns off the device if permission is given
    public void turnOff(boolean withPermission) {
        if (withPermission && hasPermission) {
            device.turnOff(); 
            System.out.println("Device with ID " + device.getId() + " has been turned off via proxy.");
        } else {
            System.out.println("Permission denied. Cannot turn off device with ID " + device.getId() + ".");
        }
    }
}
