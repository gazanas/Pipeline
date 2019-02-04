package Pipeline;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.ArrayList;

public class Pipeline<T> implements PipelineInterface<T>, StageInterface<Object, T> {

    private final OperationInterface operation;
    private final ArrayList<StageInterface> stages;

    public Pipeline(StageInterface...stages) {
        this.operation = new SimpleOperation<T>();
        this.stages = (stages == null) ? new ArrayList<>() : new ArrayList<>(Arrays.asList(stages));
    }

    public Pipeline(OperationInterface<T> operation, StageInterface...stages) {
        this.operation = operation;
        this.stages = (stages == null) ? new ArrayList<>() : new ArrayList<>(Arrays.asList(stages));
    }

    /**
     * Creating a deep copy utilizing a copy constructor.
     *
     * @param copy
     */
    public Pipeline(Pipeline copy) throws Exception {
        Class operationClass = Class.forName(copy.operation.getClass().getCanonicalName());
        Constructor operationConstruct = operationClass.getConstructor(OperationInterface.class);
        OperationInterface operation = (OperationInterface) operationConstruct.newInstance(copy.operation);
        this.operation = operation;

        Class stageClass;
        Constructor stageConstruct;
        StageInterface stageInstance;
        this.stages = new ArrayList();
        for(Object stage : copy.stages) {
            stageClass = Class.forName(stage.getClass().getCanonicalName());
            stageConstruct = stageClass.getConstructor();
            stageInstance = (StageInterface) stageConstruct.newInstance();
            this.stages.add(stageInstance);
        }
    }

    /**
     * Pipes the stages one by one.
     *
     * @param stage
     *
     * @return Pipeline.Pipeline
     */
    public Pipeline pipe(StageInterface stage) throws Exception {
        this.stages.add(stage);
        return new Pipeline(this);
    }

    public Object run(T payload) {
        try {
            return this.start(payload);
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Starts the execution of the pipeline
     *
     * @param payload
     *
     * @return result
     *
     * @throws Exception
     */
    public Object start(T payload) throws Exception {
        return this.operation.operate(this.stages, payload);
    }
}
