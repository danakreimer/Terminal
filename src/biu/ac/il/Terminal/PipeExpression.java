package biu.ac.il.Terminal;

import java.util.ArrayList;

public class PipeExpression implements Expression {
    private String expression;

    public PipeExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public boolean interpret() {
        String[] expressions = expression.split("\\s\\|\\s");
        ArrayList<Boolean> results = new ArrayList<>();
        for (String ex: expressions) {
            results.add(new TerminalExpression(ex).interpret());
        }

        boolean allCommandsWorked = results.stream().allMatch(r -> r.equals(true));

        return allCommandsWorked;
    }
}
