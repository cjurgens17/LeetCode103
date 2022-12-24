import javax.swing.tree.TreeNode;
import java.util.*;

public class LC103 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(15);


        System.out.println(zigzagLevelOrder(root));

    }

    //Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
    // (i.e., from left to right, then right to left for the next level and alternate between).
    //

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
     }
  }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
        if(root == null) return new ArrayList<>();
        List<List<Integer>> megaList = new ArrayList<>();
        megaList.add(new ArrayList(Arrays.asList(root.val)));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int reverse = 0;

        while(!q.isEmpty()){
            int length = q.size();
            List<Integer> list = new ArrayList<>();

            for(int i = 0;i<length;i++){
                TreeNode node = q.remove();

                if(node.left != null){
                    q.add(node.left);
                    list.add(node.left.val);
                }

                if(node.right != null){
                    q.add(node.right);
                    list.add(node.right.val);
                }
            }

            if(reverse % 2 == 0){
                Collections.reverse(list);
            }
            megaList.add(list);
            reverse++;
        }

        int index = megaList.size() - 1;
        megaList.remove(index);
        return megaList;
    }
}
