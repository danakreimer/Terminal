package biu.ac.il.Terminal;

public class LogInCommand extends AdvancedCommand {

    public LogInCommand(String[] args) {
        super(args);
    }

    @Override
    public String execute() {
        UserManager userManager = UserManager.getInstance();

        String credentials = args.length > 0 ? args[0] : null;
        User user = userManager.login(credentials);

        if (user == null) {
            System.out.println("Error: No Such User");
            return null;
        }

        return "Logged In Successfully as " + credentials;
    }
}
