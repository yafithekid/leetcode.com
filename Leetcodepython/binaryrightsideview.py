# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def __init__(self):
        self.smallest = None
        self.dict = {}

    def rightSideView(self, root: TreeNode) -> List[int]:
        self.rec(root, 0)
        ret = []
        for key in sorted(self.dict.keys()):
            ret.append(self.dict[key])
        return ret

    def rec(self, node, level):
        if node is None:
            return

        self.rec(node.right, level + 1)
        if not level in self.dict:
            self.dict[level] = node.val
        self.rec(node.left, level + 1)


n = [None, None, None, None, None, None, None, None, None, None, None]
n[3] = TreeNode(3)
n[1] = TreeNode(1)
n[2] = TreeNode(2)
n[4] = TreeNode(4)
n[3].left = n[1]
n[3].right = n[4]
n[1].right = n[2]
x = Solution()

print(x.rightSideView(n[3]))
