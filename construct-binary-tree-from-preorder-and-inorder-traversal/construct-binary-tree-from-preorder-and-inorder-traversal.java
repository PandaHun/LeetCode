class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return generateTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode generateTree(int[] preOrder, int[] inOrder, int preStartIdx, int inStartIdx, int inEndIdx) {
        if (preStartIdx >= preOrder.length || inStartIdx > inEndIdx) {
            return null;
        }

        TreeNode treeNode = new TreeNode(preOrder[preStartIdx]);
        int inOrderIdx = 0;
        for (int i = inStartIdx; i <= inEndIdx; i++) {
            if (inOrder[i] == treeNode.val) {
                inOrderIdx = i;
                break;
            }
        }

        treeNode.left = generateTree(preOrder, inOrder, preStartIdx + 1, inStartIdx, inOrderIdx - 1);
        treeNode.right = generateTree(preOrder, inOrder, preStartIdx + inOrderIdx - inStartIdx + 1, inOrderIdx + 1, inEndIdx);

        return treeNode;
    }
}

