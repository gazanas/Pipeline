package Pipeline;

import java.util.ArrayList;

public class LoggingOperation<T> implements OperationInterface<T> {

    private final ArrayList<Object> payloads;
    private final Interruptible interrupt;

    public LoggingOperation() {
        this.payloads = new ArrayList<>();
        this.interrupt = (payload) -> true;
    }

    public LoggingOperation(Interruptible interrupt) {
        this.payloads = new ArrayList<>();
        this.interrupt = interrupt;
    }

    /**
     * Copy Constructor
     *
     * @param copy
     */
    public LoggingOperation(LoggingOperation copy) {
        this.payloads = new ArrayList<>(copy.payloads);
        this.interrupt = copy.interrupt;
    }

    public Object operate(ArrayList<StageInterface> stages, T payload) throws Exception {
        this.payloads.add(payload);

        for(StageInterface stage : stages) {
            /**
             * Add the result of the last executed stage to the payloads list.
             */
            this.payloads.add(stage.run(this.payloads.get(this.payloads.size()-1)));

            if(!this.interrupt.interrupt(this.payloads.get(this.payloads.size()-1))) {
                throw new Exception("Something went wrong at stage "+(this.payloads.size()-1));
            }

            /**
             * Print out the result of the last executed stage.
             */
            System.out.println("Stage "+(payloads.size()-1)+": "+payloads.get(payloads.size()-1));
        }

        return payloads.get(payloads.size()-1);
    }
}
