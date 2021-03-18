package biu.ac.il.Terminal;

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
