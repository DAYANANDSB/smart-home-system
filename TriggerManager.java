import java.util.*;

public class TriggerManager {
    private List<Trigger> triggers = new ArrayList<>(); 


    public void addTrigger(String condition, Runnable action) {
        triggers.add(new Trigger(condition, action));
        System.out.println("Trigger added: " + condition);
    }

    public void checkTriggers(int temperature) {
        for (Trigger trigger : triggers) {
            if (trigger.condition.equals("temperature > " + temperature)) {
                trigger.action.run(); 
                System.out.println("Trigger condition met: " + trigger.condition);
            }
        }
    }

    static class Trigger {
        private String condition; 
        private Runnable action;  

        public Trigger(String condition, Runnable action) {
            this.condition = condition;
            this.action = action;
        }
    }
}
