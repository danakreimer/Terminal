package biu.ac.il.Terminal;

import java.util.ArrayList;

public class PipeExpressionDecorator extends ExpressionDecorator {
    public PipeExpressionDecorator(Expression expression) {
        super(expression);
    }

    @Override
    public boolean interpret(String toInterpret) {
        if (!toInterpret.contains("|")) {
            return expression.interpret(toInterpret);
        }

        String[] expressions = toInterpret.split("\\s\\|\\s");
        ArrayList<Boolean> results = new ArrayList<>();
        for (String ex : expressions) {
            results.add(expression.interpret(ex));
        }

        boolean allCommandsWorked = results.stream().allMatch(r -> r.equals(true));

        return allCommandsWorked;
    }
}
