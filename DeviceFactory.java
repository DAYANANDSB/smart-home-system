// creating different types of devices
public class DeviceFactory {
    // Creating a device based on its type and ID
    public static Device createDevice(String type, int id) {
        switch (type.toLowerCase()) {
            case "light":
                return new Light(id); 
            case "thermostat":
                return new Thermostat(id); 
            case "door":
                return new DoorLock(id);
            default:
                throw new IllegalArgumentException("Unknown device type: " + type); // Handle unknown types
        }
    }
}
