import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class Solution {
    public List<Integer> bottomView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> hdQueue = new LinkedList<>();
        
        queue.offer(root);
        hdQueue.offer(0);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int hd = hdQueue.poll();
            
            map.put(hd, node.val);
            
            if (node.left != null) {
                queue.offer(node.left);
                hdQueue.offer(hd - 1);
            }
            
            if (node.right != null) {
                queue.offer(node.right);
                hdQueue.offer(hd + 1);
            }
        }
        
        result.addAll(map.values());
        return result;
    }

    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(2);
        
        Solution solution = new Solution();
        List<Integer> bottomView = solution.bottomView(root);
        
        for (int val : bottomView) {
            System.out.println(val);
        }
    }
}
