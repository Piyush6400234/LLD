package structural.composite.Airthmetic;

public class Number implements ArithmeticExpression{

    private int value;

    public Number(int val){
        this.value = val;
    }

    @Override
    public int evaluate(){
        return value;
    }
}
