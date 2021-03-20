package biu.ac.il.Terminal.external;

import biu.ac.il.Terminal.Command;

import java.util.Arrays;
import java.util.List;

public class Greet extends Command {
    String[] args;

    public Greet() {}

    public Greet(String[] args) {
        this.args = args;
    }

    public String execute() {
        List<String> argsList = Arrays.asList(this.args);

        return "Hey " + String.join(" ", argsList) + ", welcome to JTerm!";
    }
}
