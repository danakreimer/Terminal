package biu.ac.il.Terminal;

public class CommandFactoryDecorator extends Factory<Command> {
    protected Factory<Command> factory;

    public CommandFactoryDecorator(Factory<Command> factory) {
        this.factory = factory;
    }

    @Override
    protected Command create(String command, String[] args) throws UnknownCommandException {
        return this.factory.create(command, args);
    }
}
