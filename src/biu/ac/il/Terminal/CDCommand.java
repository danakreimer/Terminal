package biu.ac.il.Terminal;

import java.util.Arrays;
import java.util.stream.Stream;

public class CDCommand extends BasicCommand {
    public CDCommand(String[] args) {
        super(args);
    }

    @Override
    public String getCommand() {
        return "cd";
    }

    @Override
    public String execute() {
        // Create the full command - we add the "&&" so the output will also contain the current directory after the cd execution
        this.args = Stream.concat(Arrays.stream(this.args), Arrays.stream(new String[] { "&&", "cd" }))
                .toArray(String[]::new);
        String result = super.execute();
        // In windows the command "cd" is being executed using the "dir" command
        System.setProperty("user.dir", result);

        return "Directory changed to " + result;
    }
}
