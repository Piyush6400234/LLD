package practice.Lambdas.fourth;


@FunctionalInterface
public interface Operation<T> {
    T Operate(T value1, T value2);
}