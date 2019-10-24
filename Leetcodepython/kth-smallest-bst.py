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
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        self.k = k
        self.smallest = None
        self.rec(root)
        return self.smallest

    def rec(self, node):
        if node is None:
            return

        else:
            self.rec(node.left)
            if self.smallest is None:
                if self.k == 1:
                    self.smallest = node.val
                    return
                else:
                    self.k -= 1
            self.rec(node.right)


n = [None,None,None,None,None,None,None,None,None,None,None]
n[3] = TreeNode(3)
n[1] = TreeNode(1)
n[2] = TreeNode(2)
n[4] = TreeNode(4)
n[3].left = n[1]
n[3].right = n[4]
n[1].right = n[2]
x = Solution()

print(x.kthSmallest(n[3],2))
