package characters;

import events.Command;
import events.Event;
import items.Clothing;
import roles.Role;

import java.util.ArrayList;
import java.util.List;

public class Leader extends Shorty{
    private List<Command> commandQueue;

    public Leader(String name, Role role, Clothing clothing, MaxHealth startHealth){
        super(name, role, clothing, startHealth);
        this.commandQueue = new ArrayList<>();
    }
    public void giveCommand(Shorty target, Command command){
        commandQueue.add(command);
        System.out.println(name + " отдает команду " + target.getName() + ": " + command.getDescription());
        target.reactToCommand(command);
    }
    public void evaluateSituation(List<Event> events) {
        for (Event event : events) {
            System.out.println(name + " анализирует событие: " + event.getType());
        }
    }

}

