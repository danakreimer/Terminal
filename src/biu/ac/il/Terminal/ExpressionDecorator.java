package biu.ac.il.Terminal;

public class ExpressionDecorator implements Expression  {
    protected Expression expression;

    public ExpressionDecorator(Expression expression) {
        this.expression = expression;
    }

    @Override
    public boolean interpret(String ex) {
        return this.expression.interpret(ex);
    }
}
