package biu.ac.il.Terminal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the non-official Bar Ilan Terminal");
        Scanner scanner = new Scanner(System.in);

        System.out.print(System.getProperty("user.dir") + ">");
        String command = scanner.nextLine();
        while (!command.equals("exit")) {
            boolean result;
            if (command.contains("|")) {
                result = new PipeExpression(command).interpret();
            } else {
                result = new TerminalExpression(command).interpret();
            }

            System.out.print(System.getProperty("user.dir") + ">");
            command = scanner.nextLine();
        }
    }
}
