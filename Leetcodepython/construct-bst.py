# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def __init__(self):
        self.preorder_i = 0

    def buildTree(self, preorder, inorder) -> TreeNode:
        return self.rec(preorder, inorder, 0, len(preorder) - 1)

    def rec(self, preorder, inorder, inorder_l: int, inorder_r: int) -> TreeNode:
        if inorder_l > inorder_r:
            return None

        node = TreeNode(preorder[self.preorder_i])
        center = self.preorder_i
        self.preorder_i += 1

        left_l = inorder_l
        right_l = inorder_l
        while preorder[center] != inorder[right_l]:
            right_l += 1

        node.left = self.rec(preorder, inorder, left_l, right_l - 1)
        node.right = self.rec(preorder, inorder, right_l + 1, inorder_r)

        return node


x = Solution()
y = x.buildTree([3, 9, 20, 15, 7], [9, 3, 15, 20, 7])
print('here')