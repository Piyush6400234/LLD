package practice.Lambdas.third;

public class Main {
    public static void main(String[] args) {
        int result = calculator((a, b)-> {int c = a + b; return c;}, 5, 2);
        var result2 = calculator((var a, var b)->a+b, 10.0, 2.5);
        var result3 = calculator((a, b)-> a.toUpperCase() +" "+ b.toUpperCase(), "Ralph", "Karmden");
    }
    public static <T> T calculator(Operation<T> function, T value1, T value2){
        T result = function.Operate(value1, value2);
        System.out.println("result of operation "+result);
        return result;
    }
}