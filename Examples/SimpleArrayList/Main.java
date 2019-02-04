package Examples.SimpleArrayList;

import Pipeline.*;

import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {
        Stage1 stage1 = new Stage1();
        Stage2 stage2 = new Stage2();
        Stage3 stage3 = new Stage3();

        Pipeline<ArrayList<String>> p = new Pipeline(new SimpleOperation());

        ArrayList<String> payload = new ArrayList();
        payload.add("payload1");
        payload.add("payload2");

        try {
            p = p.pipe(stage1).pipe(stage2).pipe(stage3);
            System.out.println(p.run(payload));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}