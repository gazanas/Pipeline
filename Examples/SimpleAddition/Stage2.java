package Examples.SimpleAddition;

import Pipeline.StageInterface;

public class Stage2 implements StageInterface<Integer, Integer> {

    public Integer run(Integer payload) {
        return payload+1;
    }

}
