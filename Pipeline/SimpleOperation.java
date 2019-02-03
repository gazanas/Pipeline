package Pipeline;

import java.util.ArrayList;

public class SimpleOperation<T> implements OperationInterface<T> {

    public SimpleOperation() {
    }

    /**
     * Copy Constructor
     *
     * @param copy
     */
    public SimpleOperation(OperationInterface copy) {
    }

    public Object operate(ArrayList<StageInterface> stages, T payload) {
        ArrayList<Object> payloads = new ArrayList<>();
        payloads.add(payload);
        for(StageInterface stage : stages) {
            payloads.add(stage.run(payloads.get(payloads.size()-1)));
        }

        return payloads.get(payloads.size()-1);
    }
}