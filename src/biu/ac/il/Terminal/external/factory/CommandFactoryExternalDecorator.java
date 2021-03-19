package biu.ac.il.Terminal.external.factory;

import biu.ac.il.Terminal.Command;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommandFactoryExternalDecorator {

    private static final String PACKAGE_NAME = "src/biu/ac/il/Terminal/external/commands";
    private HashMap<String, Command> mCommandsHashMap = new HashMap();

    //Singleton thread-safe
    public static class Holder {
        static CommandFactoryExternalDecorator inst = new CommandFactoryExternalDecorator();
    }

    public static CommandFactoryExternalDecorator getInstance() {
        return Holder.inst;
    }

    public void start() {
        File file = new File(PACKAGE_NAME);
        File[] files = file.listFiles();
        for (File f : files) {
            try {
                String name = f.getPath().replace(".java", "").replace("/", ".").replace("src.", "");
                Command command = (Command) this.getClass().getClassLoader().loadClass(name).getDeclaredConstructor().newInstance();
                mCommandsHashMap.put(command.getClass().getSimpleName(), command);
            } catch (Exception e) {

            }
        }
    }

    public Command getCommand(String command) {
        return mCommandsHashMap.get(command);
    }

}
