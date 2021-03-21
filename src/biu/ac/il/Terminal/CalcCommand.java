package biu.ac.il.Terminal;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalcCommand extends AdvancedCommand {

    public CalcCommand(String[] args) {
        super(args);
    }

    @Override
    public String execute() {

        // Normalize expression spaces
        String expression = String.join(" ", args);

        // Calculate the expression using javascript external code
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String result;
        try {
            result = engine.eval(expression).toString();
        } catch (ScriptException e) {
            System.out.println("Invalid math expression given");
            return null;
        }

        return result;
    }
}
