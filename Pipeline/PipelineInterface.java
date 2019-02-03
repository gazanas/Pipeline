package Pipeline;

public interface PipelineInterface<T> {

    Pipeline pipe(StageInterface stage) throws CloneNotSupportedException;
    Object start(T payload) throws Exception;
}
