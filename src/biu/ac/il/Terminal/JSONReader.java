package biu.ac.il.Terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JSONReader {
    public static String cwd;
    private ScriptEngine engine;

    // Convert the received json into a map
    public static Map<String, Object> parseJson(String filename) throws IOException, ScriptException {
        String json = new String(Files.readAllBytes(Paths.get(cwd, filename)));

        return JSONToMap(json);
    }

    // Convert the json string into a map using the javascript code
    public static Map<String, Object> JSONToMap(String json) throws ScriptException {
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");
        String script = "Java.asJSONCompatible(" + json + ")";
        Object result = engine.eval(script);

        return (Map) result;
    }
}
