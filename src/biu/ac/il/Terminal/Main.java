package biu.ac.il.Terminal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        JSONReader.cwd = System.getProperty("user.dir");
        System.out.println("Welcome to the non-official Bar Ilan Terminal");
        Scanner scanner = new Scanner(System.in);

        System.out.print(System.getProperty("user.dir") + ">");
        String command = scanner.nextLine();
        Expression expression = new PipeExpressionDecorator(new TerminalExpression());
        while (!command.equals("exit")) {
            boolean success = expression.interpret(command);

            if (success) {
                HistoryCommand.history.add(0, command);
            }

            System.out.print(System.getProperty("user.dir") + ">");
            command = scanner.nextLine();
        }
    }
}
