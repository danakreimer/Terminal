package biu.ac.il.Terminal;

abstract class Factory<T> {
    protected abstract T create(String command, String[] args) throws UnknownCommandException;
}
