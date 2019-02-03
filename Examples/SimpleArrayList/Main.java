package Examples.SimpleArrayList;

import Pipeline.*;

import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {
        Stage1 stage1 = new Stage1();
        Stage2 stage2 = new Stage2();

        Pipeline<ArrayList<String>> p = new Pipeline(new SimpleOperation());

        ArrayList<String> payload = new ArrayList();
        payload.add("payload1");
        payload.add("payload2");

        try {
            p.pipe(stage1).pipe(stage2);
            System.out.println(p.run(payload));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Pipeline<ArrayList<String>> p2 = new Pipeline(new SimpleOperation());

        ArrayList<String> payload2 = new ArrayList();
        payload2.add("payload1");
        payload2.add("payload2");

        Stage3 stage3 = new Stage3();

        try {
            p2.pipe(stage1).pipe(stage2);
            Pipeline<ArrayList<String>> p3 = new Pipeline();
            p3.pipe(p2).pipe(stage3);
            System.out.println(p3.run(payload2));
            System.out.println();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}