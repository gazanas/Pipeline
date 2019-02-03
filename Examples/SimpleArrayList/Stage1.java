package Examples.SimpleArrayList;

import Pipeline.StageInterface;

import java.util.ArrayList;

public class Stage1 implements StageInterface<ArrayList<String>, ArrayList<String>> {

    public ArrayList run(ArrayList payload) {

        payload.remove(0);

        return payload;
    }
}
