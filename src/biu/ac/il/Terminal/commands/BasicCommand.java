package biu.ac.il.Terminal.commands;


import biu.ac.il.Terminal.abcstracs.Command;

abstract class BasicCommand extends Command {
    String[] args;

    public BasicCommand(String[] args) {
        super();
        this.args = args;
    }
}
