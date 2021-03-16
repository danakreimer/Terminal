package biu.ac.il.Terminal.exoressions;

import biu.ac.il.Terminal.interfaces.Expression;

public class TerminalExpression implements Expression {
    private String expression;

    public TerminalExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public boolean interpret() {
        return false;
    }
}
