package biu.ac.il.Terminal;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

abstract class BasicCommand extends Command {
    protected String[] args;

    public BasicCommand(String[] args) {
        super();
        this.args = args;
    }

    public ShellCommandResult runShellCommand(String command, String[] args) throws IOException, InterruptedException {
        // Prepare the command to be executed in the cmd terminal
        String[] baseCommand = new String[]{"cmd", "/c", command};
        // Create the full command with it's arguments and turn it into a string array
        String[] fullCommand = Stream.concat(Arrays.stream(baseCommand), Arrays.stream(args))
                .toArray(String[]::new);
        // Execute the command in the cmd terminal
        Process process = Runtime.getRuntime().exec(fullCommand, null, new File(System.getProperty("user.dir")));
        int exitCode = process.waitFor();
        String output = this.getOutput(process);

        return new ShellCommandResult(exitCode == 0, output);
    }

    public String getOutput(Process process) throws IOException {
        // Get the command's output
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        StringBuilder lines = new StringBuilder();
        // Go through the output lines and create one string of all the output
        while ((line = reader.readLine()) != null) {
            lines.append(line);

            if (lines.toString().length() > line.length()) {
                lines.append("\n");
            }
        }

        return lines.toString();
    }

    public abstract String getCommand();

    public String execute() {
        try {
            // Run the command in the cmd terminal
            ShellCommandResult result = this.runShellCommand(this.getCommand(), this.args);

            if (!result.getSuccess()) {
                return null;
            }

            return result.getOutput();
        } catch (IOException | InterruptedException ioe) {
            return null;
        }
    }
}
