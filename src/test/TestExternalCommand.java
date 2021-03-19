package test;


import biu.ac.il.Terminal.external.factory.CommandFactoryExternalDecorator;
import org.junit.Test;

public class TestExternalCommand {
    @Test
    public void test() {
        CommandFactoryExternalDecorator.getInstance().start();

    }

}
