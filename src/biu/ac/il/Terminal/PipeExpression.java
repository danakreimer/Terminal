package biu.ac.il.Terminal;

import java.util.ArrayList;

public class PipeExpression implements Expression {
    private Expression expression;

    public PipeExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public boolean interpret() {
        String[] expressions = this.expression.getExpression().split("\\s\\|\\s");
        ArrayList<Boolean> results = new ArrayList<>();
        for (String ex: expressions) {
            expression.setExpression(ex);
            results.add(expression.interpret());
        }

        boolean allCommandsWorked = results.stream().allMatch(r -> r.equals(true));

        return allCommandsWorked;
    }

    @Override
    public void setExpression(String expression) {
        this.expression.setExpression(expression);
    }

    @Override
    public String getExpression() {
        return this.expression.getExpression();
    }
}
