/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int preIndex;
  
  public TreeNode solve(int preorder[], int inorder[], int start, int end) {
    if (start > end) {
      return null;
    }

    TreeNode node = new TreeNode(preorder[preIndex++]);

    if (start == end) {
      return node;
    }

    int inoderIndex = getInorderIndex(node.val, inorder, start, end);

    node.left = solve(preorder, inorder, start, inoderIndex - 1);
    node.right = solve(preorder, inorder, inoderIndex + 1, end);

    return node;
  }

  private int getInorderIndex(int data, int in[], int start, int end) {
    for (int i = start; i <= end; i++) {
      if (in[i] == data) {
        return i;
      }
    }

    return -1;
  }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        TreeNode root = solve(preorder, inorder, 0, inorder.length-1);
        return root;
        
    }
}
