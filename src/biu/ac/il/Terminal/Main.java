package biu.ac.il.Terminal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // set the cwd before we change it with the cd command
        JSONReader.cwd = System.getProperty("user.dir");
        System.out.println("Welcome to the non-official Bar Ilan Terminal - JTerm");
        Scanner scanner = new Scanner(System.in);

        System.out.print(System.getProperty("user.dir") + ">");
        String command = scanner.nextLine();

        // Create the expression interpreter instance
        Expression expression = new PipeExpressionDecorator(new TerminalExpression());
        while (!command.equals("exit")) {
            // Send the command string to be interpreted and executed
            boolean success = expression.interpret(command);

            // Save the current command to the history of all previous commands
            if (success) {
                HistoryCommand.history.add(0, command);
            }

            System.out.print(System.getProperty("user.dir") + ">");
            command = scanner.nextLine();
        }
    }
}
