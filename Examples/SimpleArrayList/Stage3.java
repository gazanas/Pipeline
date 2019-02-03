package Examples.SimpleArrayList;

import Pipeline.StageInterface;

import java.util.ArrayList;

public class Stage3 implements StageInterface<ArrayList<String>, ArrayList<String>> {

    public ArrayList run(ArrayList payload) {

        payload.add("result");

        return payload;
    }
}
