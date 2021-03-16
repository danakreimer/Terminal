package biu.ac.il.Terminal.model;

import biu.ac.il.Terminal.interfaces.Role;

public class Guest implements Role {
    @Override
    public String[] getAllowedCommands() {
        return new String[]{ "ls", "cd", "history" };
    }
}
