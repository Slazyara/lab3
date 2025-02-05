package events;

import events.Command;


public class MoveToRocketCommand implements Command {
    @Override
    public String getDescription() {
        return "залезть в ракету";
    }
}
