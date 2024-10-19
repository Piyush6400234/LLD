package structural.composite.Airthmetic;

public class Expression implements ArithmeticExpression{
    ArithmeticExpression leftExpression;
    ArithmeticExpression rightExpression;
    Operation operation;

    public Expression(ArithmeticExpression leftExpression, ArithmeticExpression rightExpression, Operation operation){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operation = operation;
    }

    @Override
    public int evaluate(){
        int value = 0;
        switch (this.operation){
            case ADD:
                value = this.leftExpression.evaluate() + this.rightExpression.evaluate();
                break;
            case SUBTRACT:
                value = this.leftExpression.evaluate() - this.rightExpression.evaluate();
                break;
            case MULTIPLY:
                value = this.leftExpression.evaluate() * this.rightExpression.evaluate();
                break;
            case DIVIDE:
                value = this.leftExpression.evaluate() / this.rightExpression.evaluate();
                break;
        }
        System.out.println("Evaluated value is: "+value);
        return value;
    }
}