package biu.ac.il.Terminal;

public class LogInCommand extends AdvancedCommand {

    public LogInCommand(String[] args) {
        super(args);
    }

    @Override
    public String execute() {
        // Get the current connected user in the terminal
        UserManager userManager = UserManager.getInstance();

        // Check the user's name
        String credentials = args.length > 0 ? args[0] : null;
        // If the user exists in the system - get the user in
        User user = userManager.login(credentials);

        if (user == null) {
            System.out.println("Error: No Such User");
            return null;
        }

        return "Logged In Successfully as " + credentials;
    }
}
