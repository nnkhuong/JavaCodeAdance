package lambda;

public interface QuadFunction<T, U, V, X, R> {
	R apply(T t, U u, V v, X x);
}
