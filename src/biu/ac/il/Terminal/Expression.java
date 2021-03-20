package biu.ac.il.Terminal;

public interface Expression {
    String expression = null;
    boolean interpret();
    void setExpression(String expression);
    String getExpression();
}
