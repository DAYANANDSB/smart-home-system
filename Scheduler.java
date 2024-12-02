import java.util.*;

// Class to manage scheduling of tasks for devices
public class Scheduler {
    private Map<Integer, List<ScheduledTask>> schedules = new HashMap<>(); // Store schedules for each device

    // Schedule a new task for a device
    public void scheduleTask(int deviceId, String time, String command) {
        ScheduledTask task = new ScheduledTask(deviceId, time, command);
        schedules.computeIfAbsent(deviceId, k -> new ArrayList<>()).add(task);
        System.out.println("Scheduled task: Device " + deviceId + " at " + time + " - " + command);
    }

    // View all scheduled tasks
    public void viewScheduledTasks() {
        for (Map.Entry<Integer, List<ScheduledTask>> entry : schedules.entrySet()) {
            int deviceId = entry.getKey();
            List<ScheduledTask> tasks = entry.getValue();
            System.out.println("Device " + deviceId + " has the following schedules:");
            for (ScheduledTask task : tasks) {
                System.out.println("  Time: " + task.getTime() + ", Command: " + task.getCommand());
            }
        }
    }

    
    static class ScheduledTask {
        private int deviceId;
        private String time;
        private String command;

        public ScheduledTask(int deviceId, String time, String command) {
            this.deviceId = deviceId;
            this.time = time;
            this.command = command;
        }

        public int getDeviceId() {
            return deviceId;
        }

        public String getTime() {
            return time;
        }

        public String getCommand() {
            return command;
        }
    }
}
