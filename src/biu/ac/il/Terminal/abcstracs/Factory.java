package biu.ac.il.Terminal.abcstracs;

import biu.ac.il.Terminal.exceptions.UnknownCommandException;

public abstract class Factory<T> {
    protected abstract T create(String command, String[] args) throws UnknownCommandException;
}
