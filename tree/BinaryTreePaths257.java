package tree;
/*
257. Binary Tree Paths
Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

 

Example 1:


Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
Example 2:

Input: root = [1]
Output: ["1"]
 

Constraints:

The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100
 */
public class BinaryTreePaths257 {
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        traverse(root, result, new ArrayList<>());
        return result;
    }

    private void traverse(TreeNode node, List<String> result, List<String> current) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            current.add(String.valueOf(node.val));
            result.add(String.join("->", current));
            current.removeLast();
            return;
        }
        current.add(String.valueOf(node.val));
        traverse(node.left, result, current);
        traverse(node.right, result, current);
        current.removeLast();
    }

}
