import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LC103Test {

    @org.junit.Test
    public void zigzagLevelOrder() {

        LC103.TreeNode root = new LC103.TreeNode(3);
        root.left = new LC103.TreeNode(9);
        root.right = new LC103.TreeNode(20);
        root.right.right = new LC103.TreeNode(7);
        root.left.left = new LC103.TreeNode(15);

        List<List<Integer>> actual = LC103.zigzagLevelOrder(root);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(3));
        expected.add(Arrays.asList(20,9));
        expected.add(Arrays.asList(15,7));


        assertEquals(actual, expected);
    }
}