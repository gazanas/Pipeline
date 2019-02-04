package Examples.SimpleAddition;

import Pipeline.*;

public class Main {

    public static void main(String args[]) {
        Stage1 stage1 = new Stage1();
        Stage2 stage2 = new Stage2();
        Stage3 stage3 = new Stage3();

        Pipeline<Integer> p = new Pipeline<Integer>(new SimpleOperation<Integer>());

        int payload = 2;

        try {
            p = p.pipe(stage1).pipe(stage2).pipe(stage3);
            System.out.println(p.run(payload));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
