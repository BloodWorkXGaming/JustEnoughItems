package mezz.jei.test;

import it.unimi.dsi.fastutil.ints.IntSet;
import mezz.jei.suffixtree.GeneralizedSuffixTree;
import mezz.jei.suffixtree.Node;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class SuffixTreeTest {
    @Test
    public void testWorking() {
        GeneralizedSuffixTree tree = new GeneralizedSuffixTree();

        tree.put("MAGIC KEY1", 1);
        tree.put("NOT MAGIC KEY2", 2);
        tree.put("NO KEY2", 3);

        IntSet res = tree.search("MAGIC");

        Node iter = tree.getRoot();
        while (iter != null) {
            System.out.println("iter = " + iter);

                iter = iter.getSuffix();
            }

        System.out.println("res = " + res);
        assert res.size() == 2 && res.contains(1) && res.contains(2);


        res = tree.search("NO");
        System.out.println("res = " + res);
        assert res.size() == 2 && res.contains(3) && res.contains(2);
    }

    @Test
    public void testMassive() {
        GeneralizedSuffixTree tree = new GeneralizedSuffixTree();

        for (int i = 0; i < 100000; i++) {
            if (i == 5000) {
                tree.put("BLABLABLA", 5000);
            } else {
                tree.put(RandomStringUtils.randomAlphanumeric(20), i);
            }
        }

        IntSet res = tree.search("BLABLABLA");

        Node iter = tree.getRoot();
        while (iter != null) {
            System.out.println("iter = " + iter);
                iter = iter.getSuffix();
            }

        System.out.println("res = " + res);
    }
}
