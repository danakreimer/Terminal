package biu.ac.il.Terminal.exoressions;

import biu.ac.il.Terminal.interfaces.Expression;

import java.util.ArrayList;

public class PipeExpression implements Expression {
    private String expression;

    public PipeExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public boolean interpret() {
        String[] expressions = expression.split("/|");
        ArrayList<Boolean> results = new ArrayList<>();
        for (String ex: expressions) {
            results.add(new TerminalExpression(ex).interpret());
        }

        boolean allCommandsWorked = results.stream().allMatch(r -> r.equals(true));

        return allCommandsWorked;
    }
}
