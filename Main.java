import java.util.*;

// Main class to run the Smart Home System
public class Main {
    public static void main(String[] args) {
        SmartHomeHub hub = new SmartHomeHub(); // Creating an instance of the Smart Home Hub

        Device light1 = DeviceFactory.createDevice("light", 1);
        Device thermostat = DeviceFactory.createDevice("thermostat", 2);
        Device doorLock = DeviceFactory.createDevice("door", 3);

        hub.registerDevice(light1);
        hub.registerDevice(thermostat);
        hub.registerDevice(doorLock);

        Scheduler scheduler = new Scheduler(); 
        TriggerManager triggerManager = new TriggerManager(); 

        
        Map<String, List<Integer>> deviceGroups = new HashMap<>();
        createDeviceGroups(deviceGroups);

        Scanner scanner = new Scanner(System.in); // Create a scanner for user input
        boolean exit = false;

        
        while (!exit) {
            System.out.println("Smart Home System - Choose an option:");
            System.out.println("1. View Status of All Devices");
            System.out.println("2. Issue Voice Command");
            System.out.println("3. Set Schedule for a Device");
            System.out.println("4. Automate Task based on Condition");
            System.out.println("5. Control a Device Group");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    // View status of all devices
                    hub.getStatusReport();
                    break;
                case 2:
                    // Issue a voice command
                    System.out.print("Enter a command (e.g., 'Turn on light 1', 'Set thermostat to 72'): ");
                    String command = scanner.nextLine();
                    processVoiceCommand(command, hub);
                    break;
                case 3:
                    
                    System.out.print("Enter device ID: ");
                    int deviceId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter time (HH:MM): ");
                    String time = scanner.nextLine();
                    System.out.print("Enter command (e.g., 'Turn On', 'Turn Off'): ");
                    String scheduleCommand = scanner.nextLine();
                    scheduler.scheduleTask(deviceId, time, scheduleCommand);
                    break;
                case 4:
                    // Automate task 
                    System.out.print("Enter condition (e.g., 'temperature > 75'): ");
                    String condition = scanner.nextLine();
                    System.out.print("Enter action (e.g., 'Turn off light 1'): ");
                    String action = scanner.nextLine();
                    triggerManager.addTrigger(condition, () -> processVoiceCommand(action, hub));
                    break;
                case 5:
                    
                    System.out.print("Enter group name (e.g., 'Living Room Lights'): ");
                    String groupName = scanner.nextLine();
                    List<Integer> deviceIds = deviceGroups.get(groupName);
                    if (deviceIds != null) {
                        System.out.print("Enter command (e.g., 'Turn On', 'Turn Off'): ");
                        String groupCommand = scanner.nextLine();
                        controlDeviceGroup(deviceIds, groupCommand, hub);
                    } else {
                        System.out.println("Group not found.");
                    }
                    break;
                case 6:
                 
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close(); 
    }

    // Processing a voice command entered by the user
    private static void processVoiceCommand(String command, SmartHomeHub hub) {
        String[] parts = command.split(" ");
        
        if (parts.length < 4) {
            System.out.println("Invalid command format.");
            return;
        }
        
        try {
            if (command.startsWith("Turn on")) {
                int deviceId = Integer.parseInt(parts[3]);
                hub.turnOnDevice(deviceId);
            } else if (command.startsWith("Turn off")) {
                int deviceId = Integer.parseInt(parts[3]);
                hub.turnOffDevice(deviceId);
            } else if (command.startsWith("Set thermostat to")) {
                int temperature = Integer.parseInt(parts[4]);
                hub.setThermostat(2, temperature); 
            } else {
                System.out.println("Unknown command.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in command.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Command is missing parameters.");
        }
    }

    private static void createDeviceGroups(Map<String, List<Integer>> deviceGroups) {
        deviceGroups.put("Living Room Lights", Arrays.asList(1));
        deviceGroups.put("Bedroom Lights", Arrays.asList(2));
    }

    // Control a group of devices 
    private static void controlDeviceGroup(List<Integer> deviceIds, String command, SmartHomeHub hub) {
        for (int deviceId : deviceIds) {
            if (command.equalsIgnoreCase("Turn On")) {
                hub.turnOnDevice(deviceId);
            } else if (command.equalsIgnoreCase("Turn Off")) {
                hub.turnOffDevice(deviceId);
            } else {
                System.out.println("Unknown command.");
            }
        }
    }
}
