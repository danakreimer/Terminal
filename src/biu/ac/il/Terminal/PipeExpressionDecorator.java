package biu.ac.il.Terminal;

import java.util.ArrayList;

public class PipeExpressionDecorator extends ExpressionDecorator {
    public PipeExpressionDecorator(Expression expression) {
        super(expression);
    }

    @Override
    public boolean interpret(String toInterpret) {
        // If it's an atomic expression we can interpret it directly
        if (!toInterpret.contains("|")) {
            return expression.interpret(toInterpret);
        }

        String[] expressions = toInterpret.split("\\s\\|\\s");
        ArrayList<Boolean> results = new ArrayList<>();

        // Send each part of expression to be interpreted
        for (String ex : expressions) {
            results.add(expression.interpret(ex));
        }

        boolean allCommandsWorked = results.stream().allMatch(r -> r.equals(true));

        return allCommandsWorked;
    }
}
