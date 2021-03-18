package biu.ac.il.Terminal;

import java.util.Arrays;
import java.util.List;

public class PrintCommand extends AdvancedCommand {

    public PrintCommand(String[] args) {
        super(args);
    }

    @Override
    public String execute() {
        List<String> argsList = Arrays.asList(this.args);

        return String.join(" ", argsList);
    }
}
