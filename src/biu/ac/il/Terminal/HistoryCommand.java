package biu.ac.il.Terminal;

import java.util.ArrayList;
import java.util.List;

public class HistoryCommand extends AdvancedCommand {
    static List<String> history = new ArrayList<>();

    public HistoryCommand(String[] args) {
        super(args);
    }

    @Override
    public String execute() {
        return "Commands history:\n" + String.join("\n", history);
    }
}
