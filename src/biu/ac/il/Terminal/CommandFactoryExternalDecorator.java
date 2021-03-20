package biu.ac.il.Terminal;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Locale;

public class CommandFactoryExternalDecorator extends CommandFactoryDecorator {
    private static final String PACKAGE_NAME = "src/biu/ac/il/Terminal/external";
    private HashMap<String, Constructor> externalCommandsMap = new HashMap();

    public CommandFactoryExternalDecorator(Factory<Command> factory) {
        super(factory);
        this.loadExternalCommands();
    }

    @Override
    protected Command create(String command, String[] args) throws UnknownCommandException {
        if (externalCommandsMap.containsKey(command)) {
            try {
                Command c = (Command) externalCommandsMap.get(command).newInstance((Object) args);

                return c;
            } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return super.create(command, args);
    }

    public void loadExternalCommands() {
        File file = new File(PACKAGE_NAME);
        File[] files = file.listFiles();

        if (files == null) return;

        for (File f : files) {
            if (f.getName().endsWith(".java")) {
                try {
                    // Convert File to a URL
                    URL url = file.toURI().toURL();
                    URL[] urls = new URL[]{url};

                    // Create a new class loader with the directory
                    ClassLoader cl = new URLClassLoader(urls);

                    String name = f.getName().replace(".java", "").toLowerCase(Locale.ROOT);
                    String path = f.getPath().replace(".java", "")
                            .replace("/", ".")
                            .replace("\\", ".")
                            .replace("src.", "");
                    Class cls = cl.loadClass(path);
                    Constructor[] constructors = cls.getConstructors();
                    Constructor constructor = cls.getConstructor();
                    for (Constructor c: constructors) {
                        if (c.getParameterCount() == 1) {
                            constructor = c;
                        }
                    }

                    externalCommandsMap.put(name, constructor);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
