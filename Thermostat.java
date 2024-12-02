
public class Thermostat extends Device {
    private int temperature; 

    // Constructor having thermostat set to a default temperature
    public Thermostat(int id) {
        super(id, "thermostat");
        this.temperature = 70; 
    }

    // Setting a new temperature 
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    // Get the status of the thermostat 
    @Override
    public String getStatus() {
        return super.getStatus() + " Temperature set to " + temperature + " degrees.";
    }
}
