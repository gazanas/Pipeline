package Pipeline;

public interface StageInterface<T1, T2> {

    T1 run(T2 payload);
}
