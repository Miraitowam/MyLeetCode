package 华为机考;

import org.junit.Test;
import 树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Test11 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<>());
        return res;
    }

    public void dfs(TreeNode root, int targetSum, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) res.add(new ArrayList<>(ans));
        dfs(root.left, targetSum - root.val, ans);
        dfs(root.right, targetSum - root.val, ans);
        ans.remove(ans.size() - 1);
    }

    @Test
    public void test() {
        String[] nums = {"5", "4", "8", "11", null, "13", "4", "7", "2", null, null, "5", "1"};
        TreeNode root = TreeNode.getHead(nums);
        System.out.println(pathSum(root, 22));
    }
}
