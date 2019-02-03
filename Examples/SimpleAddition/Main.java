package Examples.SimpleAddition;

import Pipeline.*;

public class Main {

    public static void main(String args[]) {
        Stage1 stage1 = new Stage1();
        Stage2 stage2 = new Stage2();

        Pipeline<Integer> p = new Pipeline<Integer>(new SimpleOperation<Integer>());

        int payload = 2;

        try {
            Pipeline p2 = p.pipe(stage1).pipe(stage2);
            System.out.println(p2.run(payload));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
