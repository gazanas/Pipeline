package Pipeline;

public interface PipelineInterface<T> {

    Pipeline pipe(StageInterface stage) throws Exception;
    Object start(T payload) throws Exception;
}
