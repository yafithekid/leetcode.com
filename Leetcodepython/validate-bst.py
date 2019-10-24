# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class TreeNode:
    def __init__(self,x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def rec(self, root: TreeNode, minval: int, maxval: int) -> bool:
        
        if root == None:
            return True
        print(root.val, ' ', minval, ' ', maxval)
        if (root.val < minval or root.val > maxval):
            return False
        if (root.left != None and root.left.val >= root.val):
            return False
        if (root.right != None and root.right.val <= root.val):
            return False
        return self.rec(root.left,minval,min(maxval,root.val - 1)) and self.rec(root.right,max(minval,root.val + 1),maxval)
    
        
        
    def isValidBST(self, root: TreeNode) -> bool:
        return self.rec(root,-1_000_000_000_000,1_000_000_000_000)

e = TreeNode(20)
d = TreeNode(6)
c = TreeNode(15); c.left = d; c.right = e;
b = TreeNode(5)
a = TreeNode(10); a.left = b; a.right = c;

x = Solution()

print(x.isValidBST(a))
