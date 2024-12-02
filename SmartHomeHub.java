import java.util.ArrayList;
import java.util.List;

public class SmartHomeHub {
    private List<Device> devices = new ArrayList<>(); 

  
    public void registerDevice(Device device) {
        devices.add(device);
    }

    // Notify all devices about an action
    public void notifyAllDevices(String action) {
        for (Device device : devices) {
            System.out.println("[Hub] " + action + " device " + device.getId());
            
        }
    }

    // Get a status report of all devices
    public void getStatusReport() {
        for (Device device : devices) {
            System.out.println(device.getStatus());
        }
    }

    // Turn on a specific device by ID
    public void turnOnDevice(int deviceId) {
        for (Device device : devices) {
            if (device.getId() == deviceId) {
                device.turnOn();
                System.out.println("Device " + deviceId + " turned on.");
                return;
            }
        }
        System.out.println("Device " + deviceId + " not found.");
    }

    // Turn off a specific device by ID
    public void turnOffDevice(int deviceId) {
        for (Device device : devices) {
            if (device.getId() == deviceId) {
                device.turnOff();
                System.out.println("Device " + deviceId + " turned off.");
                return;
            }
        }
        System.out.println("Device " + deviceId + " not found.");
    }

    // Set the temperature of a thermostat by ID
    public void setThermostat(int deviceId, int temperature) {
        for (Device device : devices) {
            if (device.getId() == deviceId && device instanceof Thermostat) {
                ((Thermostat) device).setTemperature(temperature);
                System.out.println("Thermostat " + deviceId + " set to " + temperature + " degrees.");
                return;
            }
        }
        System.out.println("Thermostat " + deviceId + " not found.");
    }
}
