package structural.composite.Airthmetic;

import javax.management.openmbean.OpenMBeanAttributeInfo;

//2*(1+7)
/*
                 *
               /   \
             2      +
                   / \
                  /   \
                 1     7
                /       \
               +         *
               |         |
               *         -
              / \       / \
             5   2     8   2
            2*(((5*2)+1) + (7*(8-2))) = 2*(11+42) = 2*53 = 106
*/
public class Main {
    public static void main(String[] args) {

        Number one = new Number(1);
        Number two = new Number(2);
        Number seven = new Number(7);
        ArithmeticExpression bottom = new Expression(new Number(5), new Number(2), Operation.MULTIPLY);
        ArithmeticExpression bottomr  = new Expression(new Number(8), new Number(2), Operation.SUBTRACT);

        ArithmeticExpression right = new Expression(new Expression(new Number(1), bottom, Operation.ADD),new Expression(bottomr, seven, Operation.MULTIPLY), Operation.ADD);
        ArithmeticExpression val = new Expression(two, right, Operation.MULTIPLY);

        System.out.println(val.evaluate());

    }
}
