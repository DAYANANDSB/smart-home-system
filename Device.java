// Creating an abstract class for a device
public abstract class Device {
    private int id; 
    private String type; 
    private String status;

    
    public Device(int id, String type) {
        this.id = id;
        this.type = type;
        this.status = "off"; // Default status
    }

    // Getting the device ID
    public int getId() {
        return id;
    }

    // Getting the device type
    public String getType() {
        return type;
    }

    // Getting the current status of the device
    public String getStatus() {
        return type + " " + id + " is " + status + ".";
    }

    // Turn on the device on
    public void turnOn() {
        status = "on";
        System.out.println(type + " " + id + " is now on.");
    }

    // Turn off the device
    public void turnOff() {
        status = "off";
        System.out.println(type + " " + id + " is now off.");
    }
}
