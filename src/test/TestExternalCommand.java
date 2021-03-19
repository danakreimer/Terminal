package test;


import biu.ac.il.Terminal.Command;
import biu.ac.il.Terminal.CommandFactory;
import biu.ac.il.Terminal.external.factory.CommandFactoryExternalDecorator;
import org.junit.Assert;
import org.junit.Test;

public class TestExternalCommand {
    @Test
    public void test() {
        CommandFactoryExternalDecorator.getInstance().start();
        Assert.assertNotNull(CommandFactoryExternalDecorator.getInstance().getCommand("DummyCommand"));
        Assert.assertNotNull(CommandFactoryExternalDecorator.getInstance().getCommand("DummyCommand2"));
    }

}
